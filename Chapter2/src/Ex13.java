import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		float x1, x2, y1, y2;
		double distance;

		System.out.println("Enter x1 and y1: ");
		x1 = input.nextFloat();
		y1 = input.nextFloat();
		System.out.println("Enter x2 and y2: ");
		x2 = input.nextFloat();
		y2 = input.nextFloat();
		
		distance  = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

		System.out.println("The distance between the two points is " + distance);
	}

}
