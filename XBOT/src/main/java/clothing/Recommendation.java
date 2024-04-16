package clothing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.ForecastDayModel;
import model.WeatherForecastModel;
import weather.WeatherAnalyzer;

public class Recommendation {

//	public static String getRecommendation(String cityName) {
//		StringBuilder data = new StringBuilder();
//		try {
//			WeatherAnalyzer analyser = new WeatherAnalyzer(cityName, 3);
//		
//			//gets the weather forecast
//			WeatherForecastModel weatherForecastModel = analyzer.getWeatherForecastModel();
//			
//			//loop through the forecast for the next 3 days
//			for(int i = 0; i < 3; i++) {
//				ForecastDayModel forecastDay = weatherForecastModel.getForecastDay(i);
//				String date = forecastDay.getDate();
//				Double temp = forecastDay.getMostFeelsLikeTemperature();
//				String weatherCondition = forecastDay.getWeatherCondition();
//				Double wind = forecast.getWind();
//				if (i==0) {
//					data.append(weatherSummary(date,date, weatherCondition,wind));
//				}else {
//					data.append("\n\n\n" + weatherSummary(date,date, weatherCondition,wind));
//				}
//				data.append("\n\n\tRecommendations for this day"));
//				data.append("\n\t" + clothes(temp,weatherCondition));
//			}return null;
//		}catch(Exception e) {
//		}
//		data.replace(0, data.length(),"No data found"));
//		return null;
//	}
	
	//function to convert the date String into the desired format
		private static String generateDate(String dateString) {
			
		
			
			
		}
	
}
