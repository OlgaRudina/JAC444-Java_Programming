import java.util.Scanner;

//(Find the number of years) Write a program that prompts the user to enter the
//minutes (e.g., 1 billion), and displays the number of years and days for the minutes.
//For simplicity, assume a year has 365 days.

public class Ex6 {

	public static void main(String[] args) {
		
		int min;
		int minInDay, minInYear, days, years;
		
		System.out.println("Please, enter amount of minutes: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		min = input.nextInt();
		minInDay = 60 * 24;
		minInYear = 365 * minInDay;
		years = min / minInYear;
		days = (min % minInYear) / minInDay; 
		
		System.out.println(min + " minutes is approximately " + years + " years and " + days);
		

	}

}
