package weather;

import java.net.HttpURLConnection;

public class WeatherApiConnection {
    private int days; // number of days

    private String cityName; // Name of the city

    WeatherApiConnection(String cityName, int days) 
    {
        this.cityName = cityName;
        this.days = days;
    }

    private HttpURLConnection connect() throws Exception {
        /*
         * method to establish connection with weather API it take cityName as Argument
         * and connect with API. method return an HttpURLConnection object
         */
        
        return null;
    }

    public String getCityName()
    {
        /*
         * method to get the city name
         */
        return null;
    }

}
