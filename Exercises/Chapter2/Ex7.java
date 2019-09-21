import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		
		float v0, v1, t, avg;
		System.out.println("Enter v0, v1, and t: ");
		Scanner input = new Scanner(System.in);
		v0 = input.nextFloat();
		v1 = input.nextFloat();
		t = input.nextFloat();
		avg = (v1 - v0) / t;
		System.out.println("The average acceleration is " + avg);
        input.close();

}
}
