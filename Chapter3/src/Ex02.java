import java.util.Scanner;

//Task 3.3

public class Ex02 {

	public static void main(String[] args) {
		
		System.out.println("Enter a, b, c, d, e, f: ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		float a, b, c, d, e, f, x, y;
		
		a = input.nextFloat();
		b = input.nextFloat();
		c = input.nextFloat();
		d = input.nextFloat();
		e = input.nextFloat();
		f = input.nextFloat();
		
		if( ((a * d) - (b * c)) == 0 ) {
			
			System.out.println("The equation has no solution");
		}
		
		else {
			
			x = (e * d - b * f) / (a * d - b * c);
			y = (a * f - e * c) / (a * d - b * c);
			
			System.out.println("x is " + x + " and y is " + y);
			
		}
	}

}






















