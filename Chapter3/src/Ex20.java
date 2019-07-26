import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");

		float x1, x2, x3, x4, y1, y2, y3, y4, x, y, a, b, c, d, e, f;

		x1 = input.nextFloat();
		y1 = input.nextFloat();
		x2 = input.nextFloat();
		y2 = input.nextFloat();
		x3 = input.nextFloat();
		y3 = input.nextFloat();
		x4 = input.nextFloat();
		y4 = input.nextFloat();
		
		a = (y1 - y2);
		b = (x1 - x2);
		c = (y3 - y4);
		d = (x3 - x4);
		

		e = (a * x1) - (b * y1);
		f = (c * x3) - (d * y3);

		if (((a * d) - (b * c)) == 0) {

			System.out.println("The two lines are parallel");
		}

		else {

			x = (e * d - b * f) / (a * d - b * c);
			y = (a * f - e * c) / (a * d - b * c);
			
			System.out.println("The intersecting point is at (" + x + ", " + y + ")");
		}

	}

}
