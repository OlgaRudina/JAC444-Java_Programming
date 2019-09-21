import java.util.Random;

//((max - min) + 1) + min;

public class Ex19 {

	public static void main(String[] args) {

		Random r = new Random();
		
		int suit = r.nextInt(4);
		int card = 1 + (int)(Math.random() * 13);
		

		System.out.print("The card you picked is ");

		if (card > 1 && card < 11)

			System.out.print(card);

		else {
			
			
			switch (card) {
			
			case 1:
				System.out.print("Ace");
				break;
			case 11:
				System.out.print("Jack");
				break;
			case 12:
				System.out.print("Queen");
				break;
			case 13:
				System.out.print("King");
			}
		}

		switch (suit) {
		case 0:
			System.out.print(" of Clubs");
			break;
		case 1:
			System.out.print(" of Diamonds");
			break;
		case 2:
			System.out.print(" of Hearts");
			break;
		case 3:
			System.out.print(" of Spades");
		}

	}

}
