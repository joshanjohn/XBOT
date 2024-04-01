package Validation;

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;


public class Validation {

    public Scanner sc = new Scanner(System.in);

    public boolean isValidCity(String city)
    {
        //pattern for checking city name
        String cityNamePattern = "^[A-Za-z]+( [A-Za-z]+)*(-[A-Za-z]+( [A-Za-z]+)*)*$";
        // flag to stop the loop if the input is valid
        boolean valid = false;

        while (!valid) {
            Pattern regex = Pattern.compile(cityNamePattern);
            Matcher matcher = regex.matcher(city.trim());
            if (matcher.matches()) 
                return true;
            else 
               return false;
        }
        return true;
    }
    
}
