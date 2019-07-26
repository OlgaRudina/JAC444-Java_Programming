import java.util.Scanner;

//3.32

public class Ex24 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three points for p0, p1, and p2: ");
		
		float x0, y0, x1, y1, x2, y2, cond;
	
		x0 = input.nextFloat();
		y0 = input.nextFloat();
		x1 = input.nextFloat();
		y1 = input.nextFloat();
		x2 = input.nextFloat();
		y2 = input.nextFloat();
		
		cond = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	
		if (cond > 0) {
			
			System.out.print("(" + x2 + ", " + y2 + ") is on the left side of the line from "
					+ "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")"  );
		}
		
		else if(cond == 0) {
			
			System.out.print("(" + x2 + ", " + y2 + ") is on the line from "
					+ "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")"  );
		}
		
		else {
			
			System.out.print("(" + x2 + ", " + y2 + ") is on the right side of the line from "
					+ "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")"  );
		}

	}

}
