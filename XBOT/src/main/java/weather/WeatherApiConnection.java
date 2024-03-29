package weather;

import java.net.HttpURLConnection;

public class WeatherApiConnection {
    private int days; // number of days

    private String cityName; // Name of the city

    // API KEY for weather
    private static final String API_KEY = "dc63076a45354945b01205300241503";

    // API URL without key and parameters
    private static final String BASE_URL = "https://api.weatherapi.com/v1/forecast.json?key=";

    // Constructor for WeatherApiConnection
    WeatherApiConnection(String cityName, int days) {
        this.cityName = cityName;
        this.days = days;
    }

    // Constructor for WeatherApiConnection without city name
    WeatherApiConnection(int days) {
        this.days = days;
    }

    public HttpURLConnection connect() throws Exception {
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
