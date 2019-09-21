import java.util.Scanner;

//3.30

public class Ex23 {

	public static void main(String[] args) {
		
		System.out.print("Enter the exchange rate from dollars to RMB: ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		float rate = input.nextFloat();
		
		System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
		
		int choice = input.nextInt();
		float dollars, yuan;
		
		if(choice == 0) {
			
			System.out.print("Enter the dollar amount: ");
			
			dollars = input.nextFloat();
			yuan = dollars * rate;
			
			System.out.print("$" + dollars + " is " + yuan + " yuan");
		}
		
		else if(choice == 1) {
			System.out.print("Enter the yuan amount: ");
			
			yuan = input.nextFloat();
			dollars  =  yuan / rate;
			
			System.out.print(yuan + " is $" + dollars);
		}
		
		else {
			
			System.out.print("Incorrect input");
		}
	}

}
