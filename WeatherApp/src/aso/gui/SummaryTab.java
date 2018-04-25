package aso.gui;

import aso.model.WeatherDataMap;
import aso.model.WeatherDataCollection;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class SummaryTab {

    private static GridPane summaryGridPane;
    public static WeatherDataMap allStations;
    private static final String DEGREE = "\u00b0";

    public static Tab create(){
        Tab summaryTab = new Tab("Summary");

        ScrollPane scroll = new ScrollPane();
        scroll.setFitToWidth(false);
        scroll.setFitToHeight(false);
        scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);

        summaryGridPane = new GridPane();
        summaryGridPane.setHgap(30);
        summaryGridPane.setVgap(15);
        summaryGridPane.setPadding(new Insets(25,25,10,10));

        ColumnConstraints column1 = new ColumnConstraints(250, 250, Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(250, 250, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        column2.setHgrow(Priority.ALWAYS);
        summaryGridPane.getColumnConstraints().addAll(column1, column2);

        updateGrid(2017, "data/");

        summaryTab.setContent(scroll);
        scroll.setContent(summaryGridPane);
        scroll.setPannable(true);

        summaryGridPane.getStyleClass().addAll("grid");
        return summaryTab;

    }

    /**
     * Method to update grid pane with weather summary data for a given year
     * @param year, the year that the user wants to view data for
     */
    public static void updateGrid( int year, String folder) {
        // Remove current contents of grid
        try {
            summaryGridPane.getChildren().clear();
        } catch (Exception e){

        }

        Label intro = new Label();
        intro.setText("Welcome to WÆTHER\n\nSUMMARY DATA FOR "+ year);
        summaryGridPane.add(intro,0,0,1,3);



        final Separator sep1 = new Separator();
        sep1.setValignment(VPos.CENTER);
        GridPane.setConstraints(sep1, 0, 3);
        GridPane.setColumnSpan(sep1, 2);
        summaryGridPane.getChildren().add(sep1);

        // Load all data from folder
        allStations = new WeatherDataMap( );
        allStations.loadCollections(folder, Boolean.FALSE);

        int row = 4;

        for( WeatherDataCollection stationData : allStations.getCollections() ){
            Label stationLbl = new Label("Station: ");
            Label minTempLbl = new Label("Minimum Temperature: ");
            Label maxTempLbl = new Label("Maximum Temperature: ");
            Label airFrostLbl = new Label("Total air frost days: ");
            Label rainFallLbl = new Label("Total rainfall: ");

            summaryGridPane.add(stationLbl, 0, row);
            summaryGridPane.add(minTempLbl, 0, row + 2);
            summaryGridPane.add(maxTempLbl, 0, row + 3);
            summaryGridPane.add(airFrostLbl, 0, row + 4);
            summaryGridPane.add(rainFallLbl, 0, row + 5);

            Text stationName = new Text();
            Text minTemperature = new Text();
            Text maxTemperature = new Text();
            Text totalAirFrostDays = new Text();
            Text totalRainFall = new Text();

            // Round to nearest 1 decimal
            double totalRain = Math.round(stationData.getTotalRainFall(year) * 10.0) / 10.0;

            stationName.setText(stationData.getStation());
            minTemperature.setText(stationData.getTemperatureYear(year, "min").toString() + DEGREE + "C");
            maxTemperature.setText(stationData.getTemperatureYear(year, "max").toString() + DEGREE + "C");
            totalAirFrostDays.setText(stationData.getTotalAirFrost(year).toString() + " days");
            totalRainFall.setText(totalRain + " mm");

            summaryGridPane.add(stationName, 1, row);
            summaryGridPane.add(minTemperature, 1, row + 2);
            summaryGridPane.add(maxTemperature, 1, row + 3);
            summaryGridPane.add(totalAirFrostDays, 1, row + 4);
            summaryGridPane.add(totalRainFall, 1, row + 5);

            final Separator sepHor = new Separator();
            sepHor.setValignment(VPos.CENTER);
            GridPane.setConstraints(sepHor, 0, row + 6);
            GridPane.setColumnSpan(sepHor, 2);
            summaryGridPane.getChildren().add(sepHor);

            row += 10;

        }

    }



}

