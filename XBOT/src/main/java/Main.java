import java.util.Scanner;

import Validation.Validation;

public class Main {
	public static Validation validation = new Validation();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Hello! My name is XBOT.");
		System.out.println("Please enter 5 cities.");
		String[] cities = new String[5];
		for(int i = 1; i != 6; i++ )
		{
			System.out.println("City " + i + ": ");
			String city = sc.nextLine();
			if(validation.isValidCity(city)) cities[i - 1] = city; 
		}
	}

}
