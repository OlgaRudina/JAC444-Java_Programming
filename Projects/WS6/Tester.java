
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tester extends Application {
	int CorrectCounter = 0;
	int WrongCounter = 0;

	TextField tfAdditionAnsw = new TextField();
	TextField tfSubstractionAnsw = new TextField();
	TextField tfMultiplicationAnsw = new TextField();
	TextField tfDivisionAnsw = new TextField();

	Text numbers = new Text("Two randomly generated numbers are:");
	Text addition = new Text("What is addition of");
	Text substraction = new Text("What is substraction of");
	Text multiplication = new Text("What is multiplication of");
	Text division = new Text("What is division of");
	Text correct = new Text("Number of Correct Answers:");
	Text wrong = new Text("Number of Wrong Answers:");
	Text question = new Text("Would you like to try with two diferent numbers?");
	Text msg = new Text();
	Button btNewQuiz = new Button("New Quiz");
	Button btSubmit = new Button("Submit");
	GridPane gridPane = new GridPane();
	int additionRes = 0;
	int substractionRes = 0;
	int multiplicationRes = 0;
	double divisionRes = 0;
	Text correctC = new Text();
	Text wrongC = new Text();
	
	

	// *******************************************START**************************************//

	@Override
	public void start(Stage primaryStage) {
		StartQuiz(primaryStage);
		// Handling Events
		btNewQuiz.setOnAction(e -> {
			StartQuiz(primaryStage);
		});

	}

	// ------------------------------------------------CREATE  INTERFACE-----------------------------------------//

	public void StartQuiz(Stage primaryStage) {

		CorrectCounter = 0;
		WrongCounter = 0;
	    correctC = new Text();
	    wrongC = new Text();
	    
		Text emp = new Text("            ");
		Text emp1 = new Text("      ");
		Text emp2 = new Text("    ");
		Text emp3 = new Text("              ");

		tfAdditionAnsw = new TextField();
		tfSubstractionAnsw = new TextField();
		tfMultiplicationAnsw = new TextField();
		tfDivisionAnsw = new TextField();

		tfAdditionAnsw.setPrefColumnCount(6);
		tfSubstractionAnsw.setPrefColumnCount(6);
		tfMultiplicationAnsw.setPrefColumnCount(6);
		tfDivisionAnsw.setPrefColumnCount(6);

		int a = RandomNum()[0];
		int b = RandomNum()[0];

		HBox line1 = new HBox(5);
		HBox line2 = new HBox(5);
		HBox line3 = new HBox(5);
		HBox line4 = new HBox(5);
		HBox line5 = new HBox(5);
		HBox line6 = new HBox(5);
		HBox line7 = new HBox(5);
		HBox line8 = new HBox(5);
		HBox options = new HBox(5);

		line1.setStyle("-fx-font-size: 15px;");
		GridPane gridPane = new GridPane();
		gridPane.setVgap(7);
		line1.getChildren().addAll(numbers, message(a, b));
		line2.getChildren().addAll(addition, message(a, b), emp, tfAdditionAnsw);
		line3.getChildren().addAll(substraction, message(a, b), emp1, tfSubstractionAnsw);
		line4.getChildren().addAll(multiplication, message(a, b), emp2, tfMultiplicationAnsw);
		line5.getChildren().addAll(division, message(a, b), emp3, tfDivisionAnsw);
		line6.getChildren().add(correct);
		line7.getChildren().add(wrong);

		line8.getChildren().add(question);

		btSubmit.setOnAction(e -> {

			String answ1 = "";
			String answ2 = "";
			String answ3 = "";
			String answ4 = "";
			
			
			try {		
					answ1 = tfAdditionAnsw.getText();
					answ2 = tfSubstractionAnsw.getText();
					answ3 = tfMultiplicationAnsw.getText();
					answ4 = tfDivisionAnsw.getText();
					double divValue = Double.parseDouble(answ4);
					divisionRes = Division(a, b);
					multiplicationRes = Multiplication(a, b);
					additionRes = Addition(a, b);
					substractionRes = Substraction(a, b);
					System.out.println(divisionRes);

					if (isCorrect(additionRes, answ1))

					{
						CorrectCounter++;
						correctC = new Text(Integer.toString(CorrectCounter));

					} else {
						
						tfAdditionAnsw.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
						WrongCounter++;
						wrongC = new Text(Integer.toString(WrongCounter));

					}

					if (isCorrect(substractionRes, answ2)) {
						CorrectCounter++;
						correctC = new Text(Integer.toString(CorrectCounter));

					}

					else {
						tfSubstractionAnsw.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
						WrongCounter++;
						wrongC = new Text(Integer.toString(WrongCounter));

					}

					if (isCorrect(multiplicationRes, answ3)) {
						CorrectCounter++;
						correctC = new Text(Integer.toString(CorrectCounter));

					}

					else {
						tfMultiplicationAnsw.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
						WrongCounter++;
						wrongC = new Text(Integer.toString(WrongCounter));
					}

					if ( isCorrectDouble(divisionRes, divValue)) {
						CorrectCounter++;
						correctC = new Text(Integer.toString(CorrectCounter));

					}

					else {
						tfDivisionAnsw.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
						WrongCounter++;
						wrongC = new Text(Integer.toString(WrongCounter));
					}
					
					line6.getChildren().remove(correctC);
					line6.getChildren().add(correctC);
					line7.getChildren().remove(wrongC);
					line7.getChildren().add(wrongC);
					
			} catch(NumberFormatException err)	{
				GridPane nPane = new GridPane();
				Text text = new Text("Incorrect input");
		        nPane.setHgap(1);
		        nPane.setVgap(6);
		        nPane.add(text, 0, 1);
		        nPane.setAlignment(Pos.CENTER);
		        Scene scn = new Scene(nPane, 200, 250);
		        Stage stg = new Stage();
		        stg.setTitle("Error");
		        stg.setScene(scn);
		        stg.show();

			}
			
			CorrectCounter = 0;
			WrongCounter = 0;
		    correctC = new Text();
		    wrongC = new Text();
	
		});

		btSubmit.setMinSize(90, 2);
		btNewQuiz.setMinSize(90, 2);
		options.getChildren().addAll(btNewQuiz, btSubmit);

		gridPane.add(line1, 0, 1);
		gridPane.add(line2, 0, 3);
		gridPane.add(line3, 0, 5);
		gridPane.add(line4, 0, 7);
		gridPane.add(line5, 0, 9);
		gridPane.add(line6, 0, 11);
		gridPane.add(line7, 0, 13);
		gridPane.add(line8, 0, 15);
		gridPane.add(options, 0, 17);

		// Setting the properties for the UI
		gridPane.setAlignment(Pos.CENTER);
		line1.setAlignment(Pos.CENTER_LEFT);
		line2.setAlignment(Pos.CENTER_LEFT);
		line3.setAlignment(Pos.CENTER_LEFT);
		line4.setAlignment(Pos.CENTER_LEFT);
		line5.setAlignment(Pos.CENTER_LEFT);
		line6.setAlignment(Pos.CENTER_LEFT);
		line7.setAlignment(Pos.CENTER_LEFT);
		line8.setAlignment(Pos.CENTER);
		options.setAlignment(Pos.CENTER);
		Scene scene = new Scene(gridPane, 500, 350);
		primaryStage.setTitle("Quiz Application");
		primaryStage.setScene(scene);
		primaryStage.show();

		btNewQuiz.setOnAction(e -> {
			StartQuiz(primaryStage);
		});

	}

	// ---------------------------------------------------RESULT---------------------------------------------//
	
	public boolean isCorrectDouble(double res, double input) {

		boolean isCorrect = true;

		if (input == res) {

			isCorrect = true;
			
		}

		else {
			isCorrect = false;
			
		}

		return isCorrect;

	}
	public boolean isCorrect(int res, String input) {

		boolean isCorrect = true;
		int userInput = Integer.parseInt(input);

		if (userInput == res) {

			isCorrect = true;
			
		}

		else {
			isCorrect = false;
			
		}

		return isCorrect;

	}

	// --------------------------------------------------ADDITION--------------------------------------------//

	public int Addition(int a, int b) {

		int result = a + b;

		return result;
	}

	// ------------------------------------------------SUBSTRACTION------------------------------------------//

	public int Substraction(int a, int b) {
		if(a<b) {
			a = a+ b;
			b = a -b; 
			a = a -b;

		}
		int result = a - b;

		return result;
	}

	// -----------------------------------------------MULTIPLICATION-----------------------------------------//
	public int Multiplication(int a, int b) {

		int result = a * b;

		return result;
	}
	// --------------------------------------------------DIVISION--------------------------------------------//

	public double Division(int a, int b) {
	
		if(a<b) {
			a = a + b;
			b = a - b; 
			a = a - b;

		}
		
		
		
		double result = (double)a / (double)b;
        result =(double)Math.round(result*100)/100;
		return result;
	}

	// -------------------------------------------GENERATE RANDOM NUMBERS------------------------------------//

	public int[] RandomNum() {

		int[] numbers = new int[2];
		Random rand = new Random();
		int a = rand.nextInt((100 - 1) + 1) +1;
		int b = rand.nextInt((100 - 1) + 1) +1;
		numbers[0] = a;
		numbers[1] = b;
		return numbers;

	}

	// ------------------------------------------------GENERATE MESSAGE-----------------------------------------//
	public Text message(int a, int b) {
         if(a<b) {
	         a = a+ b;
	         b = a -b; 
	         a = a -b;

          }
		msg = new Text(a + " and " + b);

		return msg;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		
		launch(args);
	}
	
}
	
	 