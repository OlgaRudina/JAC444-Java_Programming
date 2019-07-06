import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		
		float subtotal, gratuity, tips, total;
		
		System.out.println("Enter the subtotal and a gratuity rate: ");
		
		Scanner input = new Scanner(System.in);
		
		subtotal = input.nextFloat();
		gratuity = input.nextFloat();
		
		tips = gratuity / subtotal;
		total = subtotal + tips;
		
		System.out.println("The gratuity is $" + tips + " and total is $" + total);
		input.close();

	}

}
