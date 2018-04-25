package aso.model;

public class WeatherData {
    private String station;
    private int year;
    private int month;
    private Double tempMax;
    private Double tempMin;
    private int airFrostDays;
    private Double rainFall;


    /**
     * Default constructor for weather data
     */
    public WeatherData( ){
        station = "";
        year = -1;
        month = -1;
        tempMax = -1.;
        tempMin = 1.;
        airFrostDays = 0;
        rainFall = 0.;
    }

    /**
     * Constructor for weather data
     *
     * @param station The station the weather data was collected at
     * @param year The year that the data was taken
     * @param month The month that the data was taken, integer (Jan:1 - Dec:12)
     * @param tempMax The maximum temperature recorded
     * @param tempMin The minimum temperature recorded
     * @param airFrostDays The number of days with recorded air frost
     * @param rainFall Total recorded rainfall
     */
    public WeatherData(String station, int year, int month, Double tempMax, Double tempMin, int airFrostDays, Double rainFall ){
        this.station = station;
        this.year = year;
        this.month = month;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.airFrostDays = airFrostDays;
        this.rainFall = rainFall;
    }

    /**
     * Accessor for station
     * @return the station
     */
    public String getStation( ){
        return station;
    }

    /**
     * Mutator for station
     * @param station The station that data has been collected at
     */
    public void setStation( String station ){
        this.station = station;
    }

    /**
     * Accessor for year
     * @return the year
     */
    public int getYear( ){
        return year;
    }

    /**
     * Mutator for year
     * @param year The year that data was collected
     */
    public void setYear( int year ){
        this.year = year;
    }

    /**
     * Accessor for month
     * @return the month
     */
    public int getMonth( ){
        return month;
    }

    /**
     * Mutator for month
     * @param month The month that data was collected
     */
    public void setMonth( int month ){
        this.month = month;
    }

    /**
     * Accessor for tempMax
     * @return the tempMax
     */
    public Double getTempMax( ){
        return tempMax;
    }

    /**
     * Mutator for tempMax
     * @param tempMax The Maximum recorded temperature in the month
     */
    public void setTempMax( Double tempMax ){
        this.tempMax = tempMax;
    }

    /**
     * Accessor for tempMin
     * @return the tempMin
     */
    public Double getTempMin( ){
        return tempMin;
    }

    /**
     * Mutator for tempMin
     * @param tempMin The Minimum recorded temperature in the month
     */
    public void setTempMin( Double tempMin ){
        this.tempMin = tempMin;
    }

    /**
     * Accessor for airFrostDays
     * @return the airFrostDays
     */
    public int getAirFrostDays( ){
        return airFrostDays;
    }

    /**
     * Mutator for airFrostDays
     * @param airFrostDays The number of days with recorded air frost in the month
     */
    public void setAirFrostDays( int airFrostDays ){
        this.airFrostDays = airFrostDays;
    }

    /**
     * Accessor for rainFall
     * @return the rainFall
     */
    public Double getRainFall( ){
        return rainFall;
    }

    /**
     * Mutator for rainFall
     * @param rainFall The total recorded rainfall in the month
     */
    public void setRainFall( Double rainFall ){
        this.rainFall = rainFall;
    }

    @Override
    public String toString(){
        return "Station: " + getStation() + " (" + getYear() + ", " + getMonth() + "), Temperatures: " + getTempMin()
                + " - " + getTempMax() + ", Days of air frost: " + getAirFrostDays() + ", Total rainfall: " + getRainFall() + "\n\n";
    }

}
