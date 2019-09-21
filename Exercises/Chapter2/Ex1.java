import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		double numberC;
		double numberF;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a degree in Celsius: ");
		numberC = input.nextDouble();
		numberF = ( 9.0 / 5 ) * numberC + 32;
		System.out.println( numberC + " Celsius is " + numberF + " Fahrenheit ");
		input.close();

	}

}
