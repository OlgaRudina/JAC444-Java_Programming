import java.util.Scanner;

//Task 3.5

public class Ex04 {

	public static void main(String[] args) {

		System.out.println("Enter today's day: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();

		System.out.println("Enter the number of days elapsed since today: ");

		int numDays = input.nextInt();
		

		switch (num) {

		case 0:
			System.out.print("Today is Sunday "); 
			break;
		case 1:
		
			System.out.print("Today is Monday "); 
			break;
		case 2:
			
			System.out.print("Today is Tuesday "); 
			break;
		case 3:
	
			System.out.print("Today is Wednesday "); 
			break;
		case 4:
			
			System.out.print("Today is Thursday "); 
			break;
		case 5:
	
			System.out.print("Today is Friday "); 
			break;
		case 6:
			
			System.out.print("Today is Saturday "); 

		}

		switch ((numDays + num) % 7) {

		case 0:
			System.out.print("and the future day is Sunday"); 
			break;
		case 1:
			System.out.print("and the future day is Monday");
			break;
		case 2:
			System.out.print("and the future day is Tuesday");
			break;
		case 3:
			System.out.print("and the future day is Wednesday");
			break;
		case 4:
			System.out.print("and the future day is Thursday");
			break;
		case 5:
			System.out.print("and the future day is Friday");
			break;
		case 6:
			System.out.print("and the future day is Saturday");

		}
		

	}

}
