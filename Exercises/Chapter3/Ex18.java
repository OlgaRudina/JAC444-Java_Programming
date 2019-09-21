import java.util.Scanner;

//3.23

public class Ex18 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double x, y;
		
		System.out.println("Enter a point with two coordinates: ");
		
		x = input.nextDouble();
		y = input.nextDouble();
		
		System.out.print("Point (" + x + ", " + y + ") is" + (((x > 10.0 / 2)||(y > 5.0 / 2)) ? " not" : "") + " in the rectangle");

	}

}
