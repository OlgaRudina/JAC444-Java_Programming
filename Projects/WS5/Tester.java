import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tester extends Application {
	
	//--------------------Main Menu-----------------------//
	
	Button btBeans = new Button("Run Bean Machine");
	Button btNames = new Button("Search Name");
	
	 //--------------------Names Search-----------------------//
	static TextField tfYear = new TextField();
	static TextField tfGender = new TextField();
	static TextField tfName = new TextField();
	static Button btSubmitQ = new Button("Submit Query");
	Button btExit = new Button("Exit");
	static Button btNewName = new Button("Search New Name");
	Text result = new Text();
	// *******************************************START**************************************//

	@Override
	public void start(Stage primaryStage) {
		// Creating User Interface

		HBox hbox = new HBox(10);
		HBox options = new HBox(10);
		Label label = new Label("Select Option");
		hbox.setStyle("-fx-font-size: 18px;");
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		hbox.getChildren().add(label);
		btBeans.setMinSize(90, 2);
		btNames.setMinSize(90, 2);
		options.getChildren().addAll(btBeans, btNames);

		gridPane.add(hbox, 0, 1);
		gridPane.add(options, 0, 3);

		// Setting the properties for the UI
		gridPane.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Menu");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Handling Events
		btBeans.setOnAction(e -> {
			RunBean();
		});

		btNames.setOnAction(e -> {
			RunNames(primaryStage);
		});

	}
	
	
	// *******************************************BABY NAME RANKING**************************************//
	

	public void RunNames(Stage primaryStage) {
		HBox hbox = new HBox(29);
		HBox hbox1 = new HBox(10);
		HBox hbox2 = new HBox(18);
		HBox buttons = new HBox(10);
		GridPane gridPane = new GridPane();
		
		Text year = new Text("Enter the Year:");
		Text gender = new Text("Enter the Gender: ");
		Text name = new Text("Enter the Name: ");
		
		hbox.getChildren().addAll(year, tfYear);
		hbox1.getChildren().addAll( gender, tfGender);
		hbox2.getChildren().addAll( name, tfName);
		buttons.getChildren().addAll( btSubmitQ, btNewName,btExit );
		
		gridPane.add(hbox, 0, 2);
		gridPane.add(hbox1, 0, 4);
		gridPane.add(hbox2, 0, 6);
		gridPane.add(buttons, 0, 18);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.CENTER);
		tfGender.setMinWidth(30);
		tfGender.setMaxWidth(31);
		
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Search Name Ranking Application");
		primaryStage.setScene(scene);
		primaryStage.show();

		btSubmitQ.setOnAction(e -> {
			HBox res = new HBox(10);
			result.setText("");
			res.setAlignment(Pos.CENTER);
			gridPane.getChildren().removeAll(res,result); 
			try {	
				result = SearchName(tfYear, tfGender, tfName);
				res.getChildren().add(result);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			gridPane.add(res, 0,10);
			}
			catch(IllegalArgumentException err) {
				
			//	result.setText("");
				//gridPane.getChildren().removeAll(res,result);
			 
			}
			
			
			
		});

		btNewName.setOnAction(e -> {
		HBox res = new HBox(10);
		res.setAlignment(Pos.CENTER);
		result.setText("");
	    gridPane.getChildren().remove(res);
	    tfYear.setText("");
	    tfGender.setText("");
	    tfName.setText("");
		});
		
		btExit.setOnAction(e -> {
			start(primaryStage);
		});
		
		
	}
	
	//----------------------------------------SEARCH METHOD-------------------------------------------//
	

	public static Text SearchName(TextField tfYear, TextField tfGender, TextField tfName) throws FileNotFoundException {
		Text result = new Text ();
		int year = 0;
		String gender = "";
		String name = "";
		String msg = "";
		

		try {
			year = Integer.parseInt(tfYear.getText());
			}
		catch(NumberFormatException err) {

		};
	
				
		gender = tfGender.getText();
		name = tfName.getText();
		
		try {
			name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
			
		}catch(StringIndexOutOfBoundsException err) {}
		
		if(name != "" && year != 0) {
		msg = "The name " + name + " is not ranked in year " + year;
		}
		else {
			msg = "All fields must be filled";
		}
		ArrayList<String> list = new ArrayList<>();
		
		//read the file
		
		try {
		File file = new File("babynamesranking" + year + ".txt");
		@SuppressWarnings("resource")
		Scanner read = new Scanner(file);
        
        while (read.hasNext()) {
        	
        	for (int i = 0; i < 5; i++) {
				list.add(i, read.next());
			}

			// Display ranking for the name for the year
        	
			if (list.get(gender(gender)).equals(name)) {
				
				if(gender(gender) == 1) {
				msg = "Boy " + name + " is ranked #" + list.get(0) + " in year " + year;
				}
				else if(gender(gender) == 3) {
				msg = "Girl " + name + " is ranked #" + list.get(0) + " in year " + year;
				}
			}
			
			list.clear();
		}
		}
		catch(FileNotFoundException err)
	    {
	
	        }
	        
	
     result = new Text(msg);
     
     return result;


}

public static int gender(String gender) {
	if (gender.equalsIgnoreCase("M"))
		return 1;
	else
		return 3;
}
	
	
	// *******************************************BEAN MACHINE**************************************//

	public static void RunBean() {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numberOfBalls = 0;
		int numberOfSlots = 0;
		int[] slots = null;
		String[] ballPaths = null; 

        
		try {
			System.out.println("Enter the number of balls to drop: ");
			numberOfBalls = input.nextInt();
			System.out.println("Enter the number of slots in the bean machine: ");
			ballPaths = new String[numberOfBalls];	
			numberOfSlots = input.nextInt();
		    slots = new int[numberOfSlots];
			// histogram
			for (int i = 0; i < numberOfBalls; i++) {
				ballPaths[i] = dropBall(slots);
				System.out.printf("%10s\n", ballPaths[i]);
			}
			// display game
			System.out.println("");
			printArray(slots, numberOfBalls);

			
		}catch(InputMismatchException err) {
			System.out.println("Input Error");

			
		}
		catch(ArrayIndexOutOfBoundsException err) {
			System.out.println("Array out of bounds");

		}
		catch(NullPointerException err) {
			System.out.println("Null Pointer Exception");

		}

	}
	

	public static String dropBall(int[] slot) {
		StringBuilder ballPath = new StringBuilder();
		for (int i = 0; i < slot.length - 1; i++) {
			int random = (int) (Math.random() * 10) % 2;
			if (random > 0)
				ballPath.append("R");
			else
				ballPath.append("L");
		}
		int position = getBallPosition(ballPath.toString(), 'R');
		slot[position]++;
		return ballPath.toString();

	}

	public static int getBallPosition(String str, char a) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a)
				count++;
		}
		return count;
	}

	public static void printArray(int[] slots, int numberOfBalls) {
		while (!isEmpty(slots)) {
			if (isRowEmpty(slots, numberOfBalls)) {
				numberOfBalls--;
				continue;
			}
			for (int i = 0; i < slots.length; i++) {
				if (slots[i] >= numberOfBalls) {
					System.out.printf("%2c", 'O');
					slots[i]--;
				} else
					System.out.printf("%2c", ' ');

			}
			numberOfBalls--;
			System.out.println("");

		}

	}

	public static boolean isEmpty(int[] slots) {
		for (int slot : slots) {
			if (slot != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isRowEmpty(int[] slots, int rowNum) {

		for (int slot : slots) {
			if (slot == rowNum) {
				return false;
			}
		}
		return true;
	}

	// *******************************************MAIN**************************************//
	
	public static void main(String[] args) {

		launch(args);

	}
}
