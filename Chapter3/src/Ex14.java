import java.util.Scanner;

//3.19

public class Ex14 {

	public static void main(String[] args) {

		double a, b, c, sum1, sum2, sum3, p;

		System.out.print("Enter 3 edges of triangle: ");

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		sum1 = a + b;
		sum2 = a + c;
		sum3 = b + c;
		
		if(sum1 > c && sum2 > b && sum3 > a) {
			
			p = a + b + c;
			System.out.println("Perimeter = " + p);
		}
		
		else {
			System.out.println("Invalid input");
		}
	}

}
