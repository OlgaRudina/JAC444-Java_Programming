import java.util.Scanner;


public class Game {


	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[] words = { "book", "program", "powder", "silent", "fiction" };
		
	    String word = words[(int) (Math.random() * words.length)]; //finds random index of the word in array
		
		String secret = new String(new char[word.length()]).replace("\0", "*"); //creates new string random word length and replaces it with *

        int counter = 0; //amount of mistakes
        
        Boolean newGame = true;
        
		while (newGame == true && secret.contains("*")) {

						System.out.println("(Guess) Enter a letter in word " + secret + " > ");
					
						String answer = input.next();
						String newSecret = ""; //empty string that will contain answers
						
						
						for (int j = 0; j < word.length(); j++) {
						
							if (answer.charAt(0) == word.charAt(j)) { //if there is a matching letter in the word, add it to empty string newSecret

								newSecret += answer.charAt(0);
								
							} else if (secret.charAt(j) != '*') {
								newSecret  += word.charAt(j); 
								
								
							} else {
								newSecret  += "*";
				}


			}
						
						if (secret.equals(newSecret)) {
							
							System.out.println(answer + " is not in the word");
							
							
							counter++;
							
						} else {
							secret = newSecret;
						}
						
	
						if (secret.equals(word)) {
							
							System.out.println("The word is " + word +". " + "You missed " + counter + " time(s)");
							
							System.out.println("Do you want to guess another word? Enter y or n > ");
							
							char play = input.next().charAt(0);
;
							
							if(play == 'y' || play == 'Y') 
							
							{
								newGame = true;
								
								word = words[(int) (Math.random() * words.length)]; //determines new index
								
								secret = new String(new char[word.length()]).replace("\0", "*"); //secret word

						        counter = 0; //sets counter of mistakes to 0 again
								
							}
							
							if(play == 'n' || play == 'N') {
								
								newGame = false;	
								
								System.out.print("Bye!");
								
							
						}
							
						
					
						}
	}
		input.close();
	}


	
}

	
			
		
			
 



	
		
		


