// Student number: c1767198

package aso.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * Class for management of the third level of the WÆTHER app data model.
 * Each instance of a WeatherDataMap can hold an ArrayList of WeatherDataCollections.
 *
 */
public class WeatherDataMap {

    private List<WeatherDataCollection> weatherMap;
    private List<Integer> years;
    private List<String> stationNames;

    /**
     * Constructor for WatherDataMap - a container for WeatherDataCollections
     * @see WeatherDataCollection
     */
    public WeatherDataMap(){
        weatherMap = new ArrayList<>();
        years = new ArrayList<>();
        stationNames = new ArrayList<>();
    }

    /**
     * Method that loads all weatherdata on file in a given directory into weatherDataCollections.
     * The method finds all csv files in the directory, pulls out the name of each station
     * and passes it to a WeatherDataColelction constructor.
     * @param directory string, The directory where the data files are located
     * @param keepOldCollections boolean, false if old data in map should be cleared.
     */
    public void loadCollections(String directory, Boolean keepOldCollections){

        if ( !keepOldCollections ){
            weatherMap.clear();
            years.clear();
            stationNames.clear();
        }
        // Get file names from directory
        List<String> results = new ArrayList<>();
        File[] files = new File( directory ).listFiles((dir, name) -> name.endsWith( ".csv" ));

        for (File file : files) {
            if (file.isFile()) {
                results.add(FilenameUtils.getBaseName(file.getName()));
            }
        }

        // Create weatherDataCollections for each station
        // Collect station names in stationNames
        for (String station : results) {
            WeatherDataCollection stationWeather = new WeatherDataCollection(station, directory);
            weatherMap.add(stationWeather);
            stationNames.add(stationWeather.getStation());
        }

        // Collect years for which there exists data
        years = weatherMap.get(0).getYears();
    }

    /**
     * Accessor for weatherDataMap, list of weatherDataCollections currently loaded
     * @return List of WeatherDataCollection
     * @see WeatherDataCollection
     */
    public List<WeatherDataCollection> getCollections(){
        return weatherMap;
    }

    /**
     * Accessor for stationNames, list of the names of the stations currently loaded
     * @return list of strings
     */
    public List<String> getStationNames(){
        return stationNames;
    }

    /**
     * Accessor for years, list of the years with data recorded for the stations currently loaded
     * @return list of integers
     */
    public List<Integer> getYears(){
        return years;
    }

    /**
     * Method that returns the weatherdatacollection for a given station
     * @param station The station to get WeatherdataCollection for
     * @return weatherDataCollection
     */
    public WeatherDataCollection getCollection(String station){
        WeatherDataCollection collection = new WeatherDataCollection();
        for (WeatherDataCollection item : weatherMap){
            if (item.getStation().equals(station)){
                collection = item;
            }
        }
        return collection;
    }
}
