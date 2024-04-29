package clothing;

public class WeatherSummary {

    public WeatherSummary(){};
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
    
}
