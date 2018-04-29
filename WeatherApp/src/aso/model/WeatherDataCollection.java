// Student number: c1767198

package aso.model;

import aso.util.ConvertMonth;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import java.io.FileReader;

/**
 * Class for management of the second level of the WÆTHER app data model.
 * Each instance of a WeatherDataCollection object can hold all data from file
 * on a given station.
 *
 */
public class WeatherDataCollection {

    private ArrayList<WeatherData> weatherDataList;

    /**
     * Default constructor
     * @see WeatherData
     */
    public WeatherDataCollection(){
        weatherDataList =  new ArrayList<>();
    }

    /**
     * Constructor of weatherDataCollection instance
     * Method to load weather data for a given station into a weather data collection
     * @param station The station to load weather data for
     * @param directory The directory to load data from
     * @see WeatherData
     */
    public WeatherDataCollection( String station , String directory){
        weatherDataList =  new ArrayList<>();

        try (CSVReader dataReader = new CSVReader(new FileReader(directory + station +".csv"))) {

            String[] nextLine;
            while ((nextLine = dataReader.readNext()) != null) {
                WeatherData newData = new WeatherData();
                newData.setStation(station);
                newData.setYear( Integer.parseInt(nextLine[0]));
                newData.setMonth( Integer.parseInt(nextLine[1]));
                newData.setTempMax( Double.parseDouble(nextLine[2]));
                newData.setTempMin( Double.parseDouble(nextLine[3]));
                newData.setAirFrostDays( Integer.parseInt(nextLine[4]));
                newData.setRainFall( Double.parseDouble(nextLine[5]));
                weatherDataList.add(newData);
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Method to get weatherData for a selected year in an ArrayList
     * @param year The year to return weather data for
     * @return an ArrayList containing weather data for a given year
     * @see WeatherData
     */
    public ArrayList<WeatherData> getWeatherDataYear( int year ) {
        ArrayList<WeatherData> weatherDataYear = new ArrayList<>();
        for (WeatherData item : weatherDataList){
            if ( item.getYear() == year){
                weatherDataYear.add(item);
            }
        }
        return weatherDataYear;
    }

    /**
     * Method to find the maximum or minimum temperature for a weather data collection.
     * @param year The year to get a minimum or maximum temperature for
     * @param type The type of temperature, either "min" (minimum) or "max" (maximum)
     * @return a double containing the minimum or maximum temperature
     */
    public Double getTemperatureYear( int year, String type){
        Double curTemperature;
        Double givenTemperature;

        curTemperature = ( type.equalsIgnoreCase("min")) ? 1000.:-1000.;

        try {
            ArrayList<WeatherData> weatherDataYear = this.getWeatherDataYear( year );

            for (WeatherData item : weatherDataYear ){
                if (type.equalsIgnoreCase("min")){
                    givenTemperature = item.getTempMin();
                    if ( givenTemperature < curTemperature){
                        curTemperature = givenTemperature;
                    }
                }
                if (type.equalsIgnoreCase("max")){
                    givenTemperature = item.getTempMax();
                    if ( givenTemperature > curTemperature){
                        curTemperature = givenTemperature;
                    }
                }

            }

        } catch (Exception e){
            System.out.println( e.getStackTrace());
        }
        return curTemperature;
    }

    /**
     * Method to find the total number of air frost days for a weather data collection.
     * @param year The year to get air frost days for for
     * @return an integer containing the sum of air frost days for the chosen year
     */
    public Integer getTotalAirFrost( int year ){

        int totalAirFrostDays = 0;
        try {
            ArrayList<WeatherData> weatherDataYear = this.getWeatherDataYear( year );

            for (WeatherData item : weatherDataYear ){
                totalAirFrostDays += item.getAirFrostDays();
            }

        } catch (Exception e){
            System.out.println( e.getStackTrace());
        }
        return totalAirFrostDays;
    }

    /**
     * Method to find the total rainfall for a weather data collection.
     * @param year The year to get total rain fall for for
     * @return a double containing the total rainfall for the chosen year
     */
    public Double getTotalRainFall(int year ){

        double totalRain = 0.;
        try {
            ArrayList<WeatherData> weatherDataYear = this.getWeatherDataYear( year );

            for (WeatherData item : weatherDataYear ){
                totalRain = Double.sum(totalRain,item.getRainFall());
            }

        } catch (Exception e){
            System.out.println( e.getStackTrace());
        }

        return totalRain;
    }

    /**
     * Method to return the name of the station where the weather data was collected.
     * @return string, name of station.
     */
    public String getStation(){
        String station = "";
        for (WeatherData item : weatherDataList){
            station = item.getStation();
        }
        return station;
    }

    /**
     * Method to return the years when data was collected of the station.
     * @return string, name of station.
     */
    public ArrayList<Integer> getYears(){
        ArrayList<Integer> years = new ArrayList<>();
        int curYear = 0;
        int givenYear;
        for (WeatherData item : weatherDataList){
            givenYear = item.getYear();
            if (givenYear != curYear){
                years.add(givenYear);
                curYear = givenYear;
            }
        }

        return years;
    }

    /**
     * Method to return the year and month when the highest temperature was recorded.
     * @return string, the year and month when the highest temperature was recorded.
     */
    public String getHighest(){
        Double curTemperature = -100.;
        Double givenTemperature;
        WeatherData highest = new WeatherData();

        for (WeatherData item : weatherDataList){
            givenTemperature = item.getTempMax();
            if (givenTemperature > curTemperature){
                curTemperature = givenTemperature;
                highest = item;
            }
        }
        return highest.getYear() + " " + ConvertMonth.convertMonth(highest.getMonth());
    }

    /**
     * Method to return the year and month when the lowest temperature was recorded.
     * @return string, the year and month when the lowest temperature was recorded.
     */
    public String getLowest(){
        Double curTemperature = 100.;
        Double givenTemperature;
        WeatherData lowest = new WeatherData();

        for (WeatherData item : weatherDataList){
            givenTemperature = item.getTempMax();
            if (givenTemperature < curTemperature){
                curTemperature = givenTemperature;
                lowest = item;
            }
        }
        return lowest.getYear() + " " + ConvertMonth.convertMonth(lowest.getMonth());
    }

    //Average annual af: <average days of air frost per year>
    /**
     * Method to return the average number of air frost days per year for a station.
     * @return string, the average number of air frost days, rounded to nearest day.
     */
    public String getAF(){
        int totalFrostDays = 0;
        ArrayList<Integer> years = this.getYears();
        int numYears = years.size();

        // Add total for each year
        // Divide by number of years
        for (int year : years){
            totalFrostDays += this.getTotalAirFrost(year);
        }
        double avgFrostDays = (double) totalFrostDays / numYears;

        //Rounding to nearest day
        int avgFrostDaysInt = (int) Math.round(avgFrostDays);

        return String.valueOf(avgFrostDaysInt);
    }

    //Average annual rainfall: <average annual rainfall>
    /**
     * Method to return the average annual rainfall for a station.
     * @return string, the average rainfall, rounded to nearest 1 decimal place.
     */
    public String getAvgRainFall(){
        int totalRainFall = 0;
        ArrayList<Integer> years = this.getYears();
        double numYears = (double) years.size();

        // Add total for each year
        // Divide by number of years
        for (int year : years){
            totalRainFall += this.getTotalRainFall(year);
        }
        // Rounding to nearest 1 decimal
        double avgRainFall = Math.round((totalRainFall / numYears) * 10.0) / 10.0;

        return String.valueOf(avgRainFall);
    }


}
