// Student number: c1767198
package aso.util;

import aso.gui.SummaryTab;
import aso.model.WeatherDataCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that manages the creation of a weather summary report.
 *
* */
public class ReportCreator {

    private static final String DEGREE = "\u00b0";

    /**
     * Method to create summary report ArrayList, add an explanatory header
     * and data from WeatherDataMap allStations from the SummaryTab.
     * @return ArrayList of Strings, containing station data
     * @see aso.model.WeatherDataMap
     *
     * */
    public static ArrayList<String> createReport(){
        ArrayList<String> report = new ArrayList<>();

        // Create strings that will be printed for each weather station
        int sequenceNumber = 1;
        String sequence;
        String station;
        String highest;
        String lowest;
        String avgAnnualAF;
        String avgAnnualRain;

        String weatherStation;
        String weatherHighest;
        String weatherLowest;
        String weatherAvgAnnualAF;
        String weatherAvgAnnualRain;

        // Get all of the weather stations
        List<WeatherDataCollection> weatherCollections = SummaryTab.allStations.getCollections();

        // Add header
        report.add("WÆTHER summary report");
        report.add("");
        report.add("==============================================================");
        report.add("");
        report.add("Number - sequence number");
        report.add("Station - name of weather station");
        report.add("Highest - month/year with the highest maximum temperature [" + DEGREE + "]");
        report.add("Lowest - month/year with the lowest minimum temperature [" + DEGREE + "]");
        report.add("Average annual af - average days of air frost in a year");
        report.add("Average annual rainfall - average annual rainfall in [mm]");
        report.add("");
        report.add("==============================================================");
        report.add("");

        // Iterate through weather stations to get information
        for (WeatherDataCollection collection : weatherCollections){

            // Collect information for the station
            weatherStation = collection.getStation();
            weatherHighest = collection.getHighest();
            weatherLowest = collection.getLowest();
            weatherAvgAnnualAF = collection.getAF();
            weatherAvgAnnualRain = collection.getAvgRainFall();

            sequence = ("Number: " + String.valueOf(sequenceNumber));
            station = ("Station: " + weatherStation);
            highest = ("Highest: " + weatherHighest);
            lowest = ("Lowest: " + weatherLowest);
            avgAnnualAF = ("Average Annual AF: " + weatherAvgAnnualAF);
            avgAnnualRain = ("Average Annual Rain: " + weatherAvgAnnualRain);

            // Add strings to ArrayList
            report.add(sequence);
            report.add(station);
            report.add(highest);
            report.add(lowest);
            report.add(avgAnnualAF);
            report.add(avgAnnualRain);
            report.add("-----------------------------------------------------------------");
            report.add("");

            sequenceNumber += 1;
        }
        return report;
    }
}
