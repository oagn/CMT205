package aso.gui;

import aso.model.WeatherDataCollection;
import aso.model.WeatherData;
import aso.util.ConvertMonth;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class DetailedTab {

    private static int year;
    private static String station = "";
    private static ChoiceBox<Integer> cbYears;
    private static ChoiceBox<String> cbStations;
    private static final String DEGREE  = "\u00b0";
    private static WeatherDataCollection weatherCollection;
    private static ArrayList<WeatherData> weather;

    // Charts displaying detailed data for selected year
    private static NumberAxis compTempyAxis = new NumberAxis();
    private static CategoryAxis compTempxAxis = new CategoryAxis();
    private static final LineChart<String, Number> temperatureComparison = new LineChart<>(compTempxAxis, compTempyAxis);

    private static NumberAxis rainYAxis = new NumberAxis();
    private static CategoryAxis rainXAxis = new CategoryAxis();
    private static final BarChart<String, Number> rainfall = new BarChart<>(rainXAxis, rainYAxis);

    private static NumberAxis afYAxis = new NumberAxis();
    private static CategoryAxis afXAxis = new CategoryAxis();
    private static final BarChart<String, Number> airFrost = new BarChart<>(afXAxis, afYAxis);

    // Charts displaying summarised data for selected station
    private static NumberAxis tempByYearYAxis = new NumberAxis();
    private static CategoryAxis tempByYearXAxis = new CategoryAxis();
    private static final LineChart<String, Number> temperatureByYear = new LineChart<>(tempByYearXAxis, tempByYearYAxis);

    private static NumberAxis afByYearYAxis = new NumberAxis();
    private static CategoryAxis afByYearXAxis = new CategoryAxis();
    private static final BarChart<String, Number> airFrostByYear = new BarChart<>(afByYearXAxis, afByYearYAxis);

    private static NumberAxis rainByYearYAxis = new NumberAxis();
    private static CategoryAxis rainByYearXAxis = new CategoryAxis();
    private static final BarChart<String, Number> rainfallByYear = new BarChart<>(rainByYearXAxis, rainByYearYAxis);

    public static Tab create(){
        Tab detailTab = new Tab("Detail");
        BorderPane detail = new BorderPane();

        // Create Top VBox for station information and year selection
        HBox hb = new HBox();
        hb.setPadding(new Insets(25));
        hb.setSpacing(30);

        Label stationName = new Label();
        stationName.setText("Station: ");

        station = "Aberporth";
        year = 2017;

        // ChoiceBox for choice of station to view detailed data for
        List<String> stations = SummaryTab.allStations.getStationNames();
        cbStations = new ChoiceBox<>();
        ObservableList<String> choiceStations = FXCollections.observableArrayList(stations);
        cbStations.setItems(choiceStations);
        cbStations.setValue(station);

        cbStations.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                station = cbStations.getSelectionModel().getSelectedItem();
                updateWeatherData(station, year);

                updateComparisonTempChart(station, year);
                updateRainChart(station, year);
                updateAFChart(station, year);

                updateYearlyTempChart();
                updateYearlyRainChart();
                updateYearlyAFChart();
            }
        });

        // ChoiceBox for choice of year to view data for
        List<Integer> years = SummaryTab.allStations.getYears();
        cbYears = new ChoiceBox<>();
        ObservableList<Integer> choiceYears = FXCollections.observableArrayList(years);

        cbYears.setItems(choiceYears);
        cbYears.setValue(year);

        cbYears.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                year = cbYears.getSelectionModel().getSelectedItem();
                updateWeatherData(station, year);

                updateComparisonTempChart(station, year);
                updateRainChart(station, year);
                updateAFChart(station, year);
            }
        });

        hb.getChildren().addAll(stationName, cbStations, cbYears);
        detail.setTop(hb);

        // Create charts
        // Create scrollpane for charts
        ScrollPane scroll = new ScrollPane();
        scroll.setFitToWidth(false);
        scroll.setFitToHeight(false);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // HBox to place two sets of charts in
        HBox hbCharts = new HBox();
        hbCharts.setPadding(new Insets(10, 5, 10, 5));
        hbCharts.setSpacing(10);

        // 1. Charts for data from selected year
        // VBox to place charts for selected year in
        VBox vbYear = new VBox();
        vbYear.setPadding(new Insets(10, 0, 10, 0));
        vbYear.setSpacing(10);

        // 1.a. Temperature comparison (line chart)
        String compTempYLabel = "Temperature [" + DEGREE + "C]";
        String compTempXLabel = "Month";
        compTempxAxis.setLabel(compTempXLabel);
        compTempyAxis.setLabel(compTempYLabel);

        // 1.b. Monthly rain (bar chart)
        String rainYLabel = "Rainfall [mm]";
        String rainXLabel = "Month";
        rainYAxis.setLabel(rainYLabel);
        rainXAxis.setLabel(rainXLabel);

        // 1.c. Monthly air frost days (bar chart)
        String afYLabel = "Air frost [days]";
        String afXLabel = "Month";
        afYAxis.setLabel(afYLabel);
        afXAxis.setLabel(afXLabel);


        // 2. Charts for data summarised by year
        // VBox to place charts for summarised/extreme values selected station in
        VBox vbStation = new VBox();
        vbStation.setPadding(new Insets(10, 0, 10, 0));
        vbStation.setSpacing(10);

        // 2.a. Yearly minimum and maximum temperatures
        String tempByYearYLabel = "Temperature [" + DEGREE + "C]";
        String tempByYearXLabel = "Year";
        tempByYearXAxis.setLabel(tempByYearXLabel);
        tempByYearYAxis.setLabel(tempByYearYLabel);

        // 2.b. Yearly rainfall (bar chart)
        String rainByYearYLabel = "Rainfall [mm]";
        String rainByYearXLabel = "Year";
        rainByYearYAxis.setLabel(rainByYearYLabel);
        rainByYearXAxis.setLabel(rainByYearXLabel);

        // 2.c. Yearly air frost days (bar chart)
        String afByYearYLabel = "Air frost [days]";
        String afByYearXLabel = "Year";
        afByYearYAxis.setLabel(afByYearYLabel);
        afByYearXAxis.setLabel(afByYearXLabel);

        // Update weather data
        updateWeatherData(station, year);

        // Update charts to display initial data
        updateComparisonTempChart(station, year);
        updateRainChart(station, year);
        updateAFChart(station, year);
        updateYearlyTempChart();
        updateYearlyRainChart();
        updateYearlyAFChart();

        vbYear.getChildren().addAll(temperatureComparison, rainfall, airFrost);
        vbStation.getChildren().addAll(temperatureByYear, rainfallByYear, airFrostByYear);
        hbCharts.getChildren().addAll(vbYear, vbStation);

        scroll.setContent(hbCharts);
        scroll.setPannable(true);

        // Add charts to layout
        detail.setCenter(scroll);

        detailTab.setContent(detail);
        return detailTab;
    }

    private static void updateWeatherData(String station, int year){
        weatherCollection = SummaryTab.allStations.getCollection(station);
        weather = weatherCollection.getWeatherDataYear(year);
    }

    private static void updateComparisonTempChart(String station, int year){

        if (!temperatureComparison.getData().isEmpty()){
            System.out.println("Remove Series");
            temperatureComparison.getData().remove(0);
            temperatureComparison.getData().remove(1);
        }

        XYChart.Series tempComp1 = new XYChart.Series();
        XYChart.Series tempComp2 = new XYChart.Series();

        String title = "Temperature in " + station + " (" + year + ") ";

        for(WeatherData item : weather){
            String month = ConvertMonth.convertMonth(item.getMonth());
            tempComp1.getData().add(new XYChart.Data(month, item.getTempMax()));
            tempComp2.getData().add(new XYChart.Data(month, item.getTempMin()));
        }
        temperatureComparison.getData().addAll(tempComp1, tempComp2);

        temperatureComparison.setTitle(title);
    }

    private static void updateRainChart(String station, int year){

        if (!rainfall.getData().isEmpty()){
            System.out.println("Remove Series");
            rainfall.getData().remove(0);
        }

        String title = "Rainfall in " + station + " (" + year + ") ";

        XYChart.Series seriesOne = new XYChart.Series();

        for(WeatherData item : weather){
            String month = ConvertMonth.convertMonth(item.getMonth());
            seriesOne.getData().add(new XYChart.Data(month, item.getRainFall()));
        }

        rainfall.getData().addAll(seriesOne);

        rainfall.setTitle(title);

    }

    private static void updateAFChart(String station, int year){

        if (!airFrost.getData().isEmpty()){
            System.out.println("Remove Series");
            airFrost.getData().remove(0);
        }

        String title = "Air frost in " + station + " (" + year + ") ";

        XYChart.Series seriesOne = new XYChart.Series();

        for(WeatherData item : weather){
            String month = ConvertMonth.convertMonth(item.getMonth());
            seriesOne.getData().add(new XYChart.Data(month, item.getAirFrostDays()));
        }

        airFrost.getData().addAll(seriesOne);

        airFrost.setTitle(title);

    }

    private static void updateYearlyTempChart(){

        if (!temperatureByYear.getData().isEmpty()){
            System.out.println("Remove Series");
            temperatureByYear.getData().remove(0);
            temperatureByYear.getData().remove(1);
        }

        String title = "Temperature in " + weatherCollection.getStation();

        XYChart.Series seriesOne = new XYChart.Series();
        XYChart.Series seriesTwo = new XYChart.Series();

        seriesOne.setName("Maximum");
        seriesTwo.setName("Minimum");

        for (int year : cbYears.getItems()){
            seriesOne.getData().add(new XYChart.Data(String.valueOf(year), weatherCollection.getTemperatureYear(year, "max")));
            seriesTwo.getData().add(new XYChart.Data(String.valueOf(year), weatherCollection.getTemperatureYear(year, "min")));
        }

        temperatureByYear.getData().addAll(seriesOne, seriesTwo);

        temperatureByYear.setTitle(title);

    }

    private static void updateYearlyRainChart(){

        if (!rainfallByYear.getData().isEmpty()){
            System.out.println("Remove Series");
            rainfallByYear.getData().remove(0);
        }

        String title = "Total rainfall in " + weatherCollection.getStation();

        XYChart.Series seriesOne = new XYChart.Series();

        for (int year : cbYears.getItems()){
            seriesOne.getData().add(new XYChart.Data(String.valueOf(year), weatherCollection.getTotalRainFall(year)));
        }

        rainfallByYear.getData().addAll(seriesOne);

        rainfallByYear.setTitle(title);

    }

    private static void updateYearlyAFChart(){

        if (!airFrostByYear.getData().isEmpty()){
            System.out.println("Remove Series");
            airFrostByYear.getData().remove(0);
        }

        String title = "Total air frost in " + weatherCollection.getStation();

        XYChart.Series seriesOne = new XYChart.Series();

        for (int year : cbYears.getItems()){
            seriesOne.getData().add(new XYChart.Data(String.valueOf(year), weatherCollection.getTotalAirFrost(year)));
        }

        airFrostByYear.getData().addAll(seriesOne);

        airFrostByYear.setTitle(title);

    }
}
