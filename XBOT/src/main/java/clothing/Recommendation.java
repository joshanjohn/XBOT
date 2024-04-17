package clothing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.ForecastDayModel;
import model.WeatherForecastModel;
import weather.WeatherAnalyzer;

public class Recommendation {

	// function to convert the date String into the desired format
	protected static String generateDate(String dateString) {

		// parse the input String into a LocalDate object
		LocalDate date = LocalDate.parse(dateString);

		// Format the LocalDate object into the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		String formattedDate = date.format(formatter);

		return formattedDate;

	}

}
