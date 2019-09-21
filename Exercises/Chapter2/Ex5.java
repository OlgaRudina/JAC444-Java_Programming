import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		
		int number;
		
		
		System.out.println("Enter a number between 0 and 1000: ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		number = input.nextInt();
		
		int sum = number / 100;
		System.out.println(sum);
		sum += (number % 100) / 10;
		System.out.println(sum);
		sum += number % 10;
		System.out.println(sum);
		
		System.out.println("The sum of the digits is " + sum);


}
}
	
