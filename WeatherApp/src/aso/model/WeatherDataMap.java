package aso.model;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

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
     * @param directory string, The directory where the data files are located
     * @param keepOldCollections boolean, false if old data in map should be cleared.
     * @return weatherDataCollection
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
            WeatherDataCollection stationWeather = new WeatherDataCollection(station);
            weatherMap.add(stationWeather);
            stationNames.add(stationWeather.getStation());
        }

        // Collect years for which there exists data
        years = weatherMap.get(0).getYears();
    }

    /**
     * Accessor for weatherDataMap, list of weatherDataCollections currently loaded
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
