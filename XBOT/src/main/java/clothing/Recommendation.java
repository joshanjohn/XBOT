package clothing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Recommendation {

	/**
	 * Generates a weather summary based on provided parameters.
	 *
	 * @param date      The date for which the weather summary is generated.
	 * @param temp      The temperature for the given date.
	 * @param condition The weather condition for the given date.
	 * @param wind      The wind speed for the given date.
	 * @return A formatted weather summary string.
	 */
	protected static String weatherSummary(String date, String temp, String condition, Double wind) {
		return "\n\t> On " + generateDate(date) + ", the weather with most feel like \n\ttemperature of " + temp
				+ "°C, \n\taccompanied by " + condition + " weather conditions and \n\ta wind speed of " + wind
				+ "km/h.";
	}

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
