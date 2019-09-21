import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
		int curpop = 312032486;
		int u_years;
		double birth;
		double death;
		double immigrants;
		
		System.out.println("Enter the number of years: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		u_years = input.nextInt();
		
			//birth per day (every 7 sec)
			
			int year = 365 * 24 * 60 * 60; //seconds in 1 year
			
			birth = year / 7.0;
			
			//death per day (every 13 sec)
			
			death = year / 13.0;

			//immigrants per day (every 45 sec)
			
			immigrants = year / 45.0;
			
			
			double popInyear = birth - death + immigrants;
			
		
			System.out.println("The population in 5 years is " + (curpop + (int)(u_years * popInyear)));
	
	}

}
