import java.util.Scanner;

public class Ex21 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Enter an integer: ");

		int num = input.nextInt();

		System.out.println("Is " + num + " divisible by 5 and 6? ");
		
		System.out.println(num % 5 == 0 && num % 6 == 0);
		
		System.out.println("Is " + num + " divisible by 5 or 6? ");
		
		System.out.println(num % 5 == 0 || num % 6 == 0);
		
		System.out.println("Is " + num + " divisible by 5 or 6, but not both? ");
		
		System.out.println(num % 5 == 0 ^ num % 6 == 0); 
	}

}
