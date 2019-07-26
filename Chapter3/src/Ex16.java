import java.util.Scanner;

//3.21

public class Ex16 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int q, m, j, k, h, year;
		String day = null;
		System.out.println("Enter year: (e.g., 2012): ");
		year = input.nextInt();
		
		
		System.out.println("Enter month: ");
		
		m = input.nextInt();
		
		if(m == 1 || m == 2) {
			
			m += 12;
			year --;
		}
		
		j = year / 100;
		k = year % 100;
		
		System.out.println("Enter the day of the month: 1-31: ");
		q = input.nextInt();

		h = (q + ((26 * (m + 1)) / 10) + k + (k / 4) + (j / 4 ) + (5 * j)) % 7;

		switch (h) {

		case 0:
			day ="Saturday";
			break;
		case 1:
			day = "Sunday";
			break;
		case 2:
			day = "Monday";
			break;
		case 3:
			day = "Tuesday";
			break;
		case 4:
			day = "Wednesday";
			break;
		case 5:
			day = "Thursday";
			break;
		case 6:
			day = "Friday";

		}

		System.out.println("Day of the week is " + day);
	}

}
