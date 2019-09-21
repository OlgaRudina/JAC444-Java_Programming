import java.util.Scanner;
//3.11
public class Ex09 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int month_number, year;

		System.out.println("Enter a month number: ");
		
		month_number = input.nextInt();
		
		System.out.println("Enter a year: ");

		year = input.nextInt();

		switch (month_number) {

		case 1:
			System.out.println("January " + year + " has 31 days");
			break;
		case 2:
			if (year % 4 != 0) {
				System.out.println("February " + year + " has 28 days");
			} else {
				System.out.println("February " + year + " has 29 days");
			}
			break;
		case 3:
			System.out.println("March " + year + " has 31 days");
			break;
		case 4:
			System.out.println("April " + year + " has 30 days");
			break;
		case 5:
			System.out.println("May " + year + " has 31 days");
			break;
		case 6:
			System.out.println("June " + year + " has 30 days");
			break;
		case 7:
			System.out.println("July " + year + " has 31 days");
			break;
		case 8:
			System.out.println("August " + year + " has 31 days");
			break;
		case 9:
			System.out.println("September " + year + " has 30 days");
			break;
		case 10:
			System.out.println("October " + year + " has 31 days");
			break;
		case 11:
			System.out.println("November " + year + " has 30 days");
			break;
		case 12:
			System.out.println("December has " + year + " has 31 days");

		}

	}

}
