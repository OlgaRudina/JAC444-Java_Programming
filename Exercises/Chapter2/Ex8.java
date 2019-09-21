import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		double t0, t1, M, Q;
		
		System.out.println("Enter the amount of water in kilograms: ");
		M = input.nextDouble();
		System.out.println("Enter the initial temperature: ");
		t0 = input.nextDouble();
		System.out.println("Enter the final temperature: ");
		t1 = input.nextDouble();
		Q = M * (t1 - t0) * 4184;
		System.out.println("The energy needed is " + Q);
		input.close();
	}

}
