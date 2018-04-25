package aso.gui;

import com.opencsv.CSVReader;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.FileReader;

public class TemperatureChart {

    static String station;
    static String year;
    static NumberAxis yAxis = new NumberAxis();
    static CategoryAxis xAxis = new CategoryAxis();
    static String title;
    static final String DEGREE  = "\u00b0";
    static String yLabel = "Temperature [" + DEGREE + "C]";
    static String xLabel = "Month";

    static final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

    public TemperatureChart( String station, String year ) {
        this.station = station;
        this.year = year;
        title = "Temperature in " + this.station + " (" + this.year + ") ";
        xAxis.setLabel(xLabel);
        yAxis.setLabel(yLabel);
    }

    public LineChart getTemp(){

        XYChart.Series seriesOne = new XYChart.Series();
        XYChart.Series seriesTwo = new XYChart.Series();

        seriesOne.setName("Maximum");
        seriesTwo.setName("Minimum");

        try (CSVReader dataReader = new CSVReader(new FileReader("data/" + station +".csv"))) {
            String[] nextLine;
            while ((nextLine = dataReader.readNext()) != null) {
                String curYear = String.valueOf(nextLine[0]);
                String month = String.valueOf(nextLine[1]);
                float tmax = Float.parseFloat(nextLine[2]);
                float tmin = Float.parseFloat(nextLine[3]);
                if (curYear.equals(year)) {
                    seriesOne.getData().add(new XYChart.Data(month, tmax));
                    seriesTwo.getData().add(new XYChart.Data(month, tmin));
                }
            }
        } catch(Exception e){
            System.out.println(e.getStackTrace());
        }

        lineChart.getData().addAll(seriesOne, seriesTwo);

        lineChart.setTitle(title);
        return lineChart;
    }

    public String getxLabel(){
        return xLabel;
    }

    public String getyLabel(){
        return yLabel;
    }
}
