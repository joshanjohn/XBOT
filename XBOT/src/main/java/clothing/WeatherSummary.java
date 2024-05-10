package clothing;

public class WeatherSummary {

	/**
	 * Generates a weather summary based on provided parameters.
	 *
	 * @param date      The date for which the weather summary is generated.
	 * @param temp      The temperature for the given date.
	 * @param condition The weather condition for the given date.
	 * @param wind      The wind speed for the given date.
	 * @return A formatted weather summary string.
	 */

	protected static String weatherSummary(String date, Double temp, String condition, Double wind) {
		return "\n\t> On " + Recommendation.generateDate(date) + ", -> " + temp + "°C, \n\taccompanied by " + condition
				+ " weather conditions and \n\ta wind speed of " + wind + "km/h.";
	}

	public static int analyseWind(Double wind) {
		// method that returns wind description according to its speed

		/*
		 * method that returns wind description according to its speed
		 * groups:
		 * 1 means the light wind
		 * 2 means the moderate wind
		 * 3 means strong wind
		 * 4 means very strong wind
		 */

		if (wind <= 1 && wind >= 0)
			return 1;
		else if (wind <= 5 && wind > 1)
			return 1;
		else if (wind <= 11 && wind > 5)
			return 1;
		else if (wind <= 19 && wind > 11)
			return 1;
		else if (wind <= 29 && wind > 19)
			return 2;
		else if (wind <= 39 && wind > 29)
			return 2;
		else if (wind <= 49 && wind > 39)
			return 2;
		else if (wind <= 61 && wind > 49)
			return 2;
		else if (wind <= 74 && wind > 61)
			return 3;
		else if (wind <= 88 && wind > 74)
			return 3;
		else if (wind <= 102 && wind > 88)
			return 4;
		else if (wind <= 117 && wind > 102)
			return 4;
		else if (wind <= 134 && wind > 117)
			return 4;
		return 0;
	}

	// Method to check if it's raining
    protected static boolean isRaining(String weatherCondition) {
        return weatherCondition.toLowerCase().contains("rainy") || weatherCondition.toLowerCase().contains("rain");
    }

	// Method to check if it's sunny
	protected static boolean isSunny(String weatherCondition) {
		return weatherCondition.toLowerCase().contains("sunny") || weatherCondition.toLowerCase().contains("sun");
	}

	// Method to check if it's snowing
	protected static boolean isSnowy(String weatherCondition) {
		return weatherCondition.toLowerCase().contains("snow") || weatherCondition.toLowerCase().contains("snowy");
	}

	//Method to give the info about temperature
	protected static int temp(Double temp)
	{
		return 0;
	}
}
