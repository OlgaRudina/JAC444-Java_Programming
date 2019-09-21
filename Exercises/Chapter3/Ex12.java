import java.util.Random;
import java.util.Scanner;

//Task *3.17

public class Ex12 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		System.out.println("scissor (0), rock (1), paper (2): ");

		int user = input.nextInt();
		int comp = r.nextInt(2);
		String compw = null, userw = null;

		switch (comp) {
		case 0:
			compw = "scissor";
			break;
		case 1:
			compw = "rock";
			break;
		case 2:
			compw = "paper";

		}
		
		switch (user) {
		case 0:
			userw = "scissor";
			break;
		case 1:
			userw = "rock";
			break;
		case 2:
			userw = "paper";

		}

		if (user == comp) {
			System.out.println("The computer is " + compw + "."  +  " You are" + userw + "too." + "It is a draw");
		}
		
		else if(user == 0 && comp == 2 || user == 1 && comp == 0 || user == 2 && comp == 1) {
			
			System.out.println("The computer is " + compw + "." + " You are " + userw + "." 
			+ " You won");
		}
		
		else {
			
			System.out.println("The computer is " + compw + " You are " + userw + "." 
					+ " Computer won");
			}

	}

}
