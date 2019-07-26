import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int a, b, c, temp;

		System.out.println("Enter 3 integers: ");

		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();

		if (a > b) {

			temp = b;
			b = a;
			a = temp;
		}

		if (c < b) {

			temp = b;
			b = c;
			c = temp;
		}

		if (a > b) {

			temp = b;
			b = a;
			a = temp;
		}
		
		System.out.println(a + " " + b + " " + c);

	}

}
