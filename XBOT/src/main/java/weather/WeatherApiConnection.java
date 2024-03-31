package weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

    public HttpURLConnection connect() throws Exception {
        /*
         * method to establish connection with weather API it take cityName as Argument
         * and connect with API. method return an HttpURLConnection object
         */

         URL url = new URL(BASE_URL + API_KEY + "&q=" + this.cityName + "&days=" + this.days); // Create the URL for the API request

         // Open connection
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 
         // Set request method
         connection.setRequestMethod("GET");
 
         // connecting API
         connection.connect();
 
         // Get response code
         int responseCode = connection.getResponseCode();
 
         if (responseCode != HttpURLConnection.HTTP_OK) {
             /*
              * checking if the respose code is not ok if so it throw an RuntimeException
              * checking is done using the response Code. (200 means connected sucessfully)
              */
             throw new RuntimeException("Failed to retrieve weather data: HTTP error code " + responseCode);
         }
 
         return connection;
    }

    public String getCityName()
    {
        /*
         * method to get the city name
         */
        return this.cityName;
    }

    public  String getWeatherData() throws Exception
    {

        /*
		 * Method to return the weather JSON information method takes city name as
		 * argument
		 * 
		 */

        // getting the HttpURLConnection
        HttpURLConnection connection = this.connect();

        // reading the inputs from the connection
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // declaring an String builder
		StringBuilder stringBuilder = new StringBuilder();

        String line;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}
		reader.close();

        return stringBuilder.toString();
    }
}
