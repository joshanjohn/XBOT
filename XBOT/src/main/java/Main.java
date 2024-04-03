import java.util.Scanner;

import Validation.Validation;
import model.ForecastDayModel;
import model.WeatherForecastModel;
import weather.WeatherAnalyzer;


public class Main {
	public static Validation validation = new Validation();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("Hello! My name is XBOT.");
		System.out.println("Please enter 5 cities.");

		//array for stroing cities
		String[] cities = new String[5];

		//asking for user's input
		for(int i = 1; i != 6; i++ )
		{
			System.out.println("City " + i + ": ");
			String city = sc.nextLine();
			if(validation.isValidCity(city)) 
				cities[i - 1] = city; 
			else
			{
				boolean valid = false;
        		while (!valid) 
				{
					System.out.println("Please enter the valid city name");
					city = sc.nextLine();
				}
			}
		}

		//getting weather data for cities in 3 days
		for(String cityName : cities)
		{
			cityName = cityName.replace(' ', '-');  
			WeatherAnalyzer analyzer = new WeatherAnalyzer(cityName, 3);

            // Get the weather forecast
            WeatherForecastModel weatherForecastModel = analyzer.getWeatherForecastModel();

			System.out.println(cityName);
            // Loop through the forecast for the next 3 days
            for (int i = 0; i < 3; i++) 
			{
                ForecastDayModel forecastDay = weatherForecastModel.getForecastDay(i);
                String date = forecastDay.getDate();
                Double temp = forecastDay.getMostFeelsLikeTemperature();
                String weatherCondition = forecastDay.getWeatherCondition();
                Double wind = forecastDay.getWind();

                System.out.println("Date: " + date);
                System.out.println("Temp: " + temp);
                System.out.println("Weather Condition: " + weatherCondition);
                System.out.println("Wind: " + wind);
                System.out.println("Recomendations for this day:");
                System.out.println(clothes(temp, weatherCondition));
			}
			System.out.println("-------------");
		}
	}

	public static String clothes(Double temp, String weatherCondition) {
		String recommendation = "";
		if (temp > 20)
			recommendation += "It is hot! Wear something light, like shorts and t-shirt. Don't forget about headdress. ";
		else if (temp < 20 && temp >= 15)
			recommendation += "It is warm, but not hot. Wear something light but take the jacket.";
		else if (temp < 15 && temp >= 10)
			recommendation += "It is a little bit cold. Wear something light that warms you, like a long-sleeved shirt with a sweater or fleece, topped with a jacket. ";
		else if (temp < 10 && temp >= 0)
			recommendation += "It is cold! Wear something warm, like sweater, topped with warm jacket and jeans. ";
		else
			recommendation += "It is freezing! Wear something really warm. Don't forget about the gloves, a scarf and a cap. ";
		if (weatherCondition.toLowerCase().contains("rainy")
				|| weatherCondition.toLowerCase().contains("rain"))
			recommendation += "It is also rainy, so don't forget about umbrella!";
		return recommendation;
	}

}
