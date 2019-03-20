import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.RandomAccessFile;  
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class Tester extends Application {
	
	//-------------------Game-----------------------//
	
	private static final int TILE_SIZE = 80;
	private static final int COLUMNS = 7;
	private static final int ROWS = 6;
	private boolean redMove = true;
	private Disc[][] grid = new Disc[COLUMNS][ROWS]; // 2D Grid
	private Pane discRoot = new Pane();
    Button btYes= new Button("Yes");
    Button btNo= new Button("No");

	
	//--------------------Banking-----------------------//
	TextField tfEnterAccount = new TextField();
	TextField tfWithdraw = new TextField();
	TextField tfDeposit = new TextField();
	TextField tfPin = new TextField();
	
	Button btCheckBalance = new Button("Check Balance");
	Button btWithdraw = new Button("Withdraw");
	Button btDeposit = new Button("Deposit");
	Button btSubmit = new Button("Submit");
	Button btExit = new Button("Exit the Account");
	Button btCreateAccount = new Button("Create Account");
	Button btCreatePin = new Button("Create Pin");
	Button btCancel = new Button("Cancel");
	Button btBanking = new Button("Banking");
	Button btAddress = new Button("Address Book");
	Button btGame = new Button("Connect 4");
	Button btConfirm = new Button("Confirm");
	Account[] arr = createArray();
	
	//---------------------Address----------------------//
	
	final int FNAME = 32; 
	final int LNAME= 32; 
	final int CITY = 20; 
	final int PROVINCE = 2; 
	final int ZIP = 6; 
	protected int count = 0;
	
	TextField tfFirstName = new TextField();
	TextField tfLastName = new TextField();
	TextField tfCity = new TextField();
	TextField tfPostalCode = new TextField();
	
	Button btAdd = new Button("Add");
	Button btOK = new Button("Ok");
	Button btFirst = new Button("First");
	Button btNext = new Button("Next");
	Button btPrevious= new Button("Previous");
	Button btLast= new Button("Last");
	Button btUpdate= new Button("Update");
	
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
		btBanking.setMinSize(90, 2);
		btAddress.setMinSize(90, 2);
		btGame.setMinSize(90, 2);
		options.getChildren().addAll(btBanking,btAddress,btGame);

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
		btBanking.setOnAction(e -> {
			BankingOnStart(primaryStage);
		});

		btAddress.setOnAction(e -> {
			try {
				AddressBookOnStart(primaryStage);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btGame.setOnAction(e -> {
			
			primaryStage.setScene(new Scene(createContent(primaryStage)));
			primaryStage.show();});

	}
	
	
	//*******************************************GAME**********************************************//
	
	//--------------------------------------------CREATE FIELD-------------------------------------//
	private Parent createContent(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Connect Four!");
		Pane root = new Pane();
		root.getChildren().add(discRoot);
		Shape gridShape = makeGrid();

		root.getChildren().add(gridShape);
		root.getChildren().addAll(makeColumns(primaryStage));
		return root;

	}

	private Shape makeGrid() {

		Shape shape = new Rectangle((COLUMNS + 1) * TILE_SIZE, (ROWS + 1) * TILE_SIZE);
		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLUMNS; x++) {
				Circle circle = new Circle(TILE_SIZE / 2); //radius
				circle.setCenterX(TILE_SIZE / 2);
				circle.setCenterY(TILE_SIZE / 2);
				circle.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4); //setTranslateX and setTranslateY methods moves the (0, 0) point from the top-left corner to any arbitrary point
				circle.setTranslateY(y * (TILE_SIZE + 5) + TILE_SIZE / 4);

				shape = Shape.subtract(shape, circle);
			}
		}

		Light.Distant light = new Light.Distant();
		light.setAzimuth(45.0);
		light.setElevation(30.0);

		Lighting lighting = new Lighting();
		lighting.setLight(light);
		lighting.setSurfaceScale(5.0);

		shape.setFill(Color.BLUE);
		shape.setEffect(lighting);
		return shape;
	}

	private List<Rectangle> makeColumns(Stage primaryStage) {
		List<Rectangle> list = new ArrayList<>();
		for (int x = 0; x < COLUMNS; x++) {

			Rectangle rect = new Rectangle(TILE_SIZE, (ROWS + 1) * TILE_SIZE);
			rect.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
			rect.setFill(Color.TRANSPARENT);
			rect.setOnMouseEntered(e -> rect.setFill(Color.rgb(200, 200, 50, 0.3)));
			rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));
			final int column = x;
			rect.setOnMouseClicked(e -> 
			{ 
				placeDisc(new Disc(redMove), column, primaryStage);
			});

			list.add(rect);
		}
		return list;
	}
	
	//--------------------------------------------PLACE DISK ON THE CLICKED POSITION-------------------------------------// 
	
	private void placeDisc(Disc disc, int column, Stage primaryStage) {
		
		int row = ROWS - 1; //-1 because ROWS starts from 0
		do {
			if (!getDisc(column, row).isPresent()) {
				break;
			}
			row--;

		} while (row >= 0);

		if (row < 0) {
			return;
		}

		grid[column][row] = disc;
        
		discRoot.getChildren().add(disc);
		disc.setTranslateX(column * (TILE_SIZE + 5) + TILE_SIZE / 4);
		final int currentRow = row;

		TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5), disc);
		animation.setToY(row * (TILE_SIZE + 5) + TILE_SIZE / 4);
		animation.setOnFinished(e -> {
			if (gameEnded(column, currentRow)) {
				gameOver(primaryStage);
			}

			redMove = !redMove;
		});

		animation.play();
	}
	//--------------------------------------------CHECK IF THE GAME ENDED-------------------------------------// 
	
	private boolean gameEnded(int column, int row) {
		//column and row are coordinated of the position where the disc placed at that moment
		//row - 3: we created chain of 4, so we have to check up to 4 values in each direction
		
		List<Point2D> vertical = IntStream.rangeClosed(row - 3, row + 3)
				.mapToObj(r -> new Point2D(column, r))
				.collect(Collectors.toList());
		
		List<Point2D> horizontal = IntStream.rangeClosed(column - 3, column + 3)
				.mapToObj(c -> new Point2D(c, row))
				.collect(Collectors.toList());
		
		Point2D topLeft = new Point2D(column-3, row - 3);
		List<Point2D> diagonal1 = IntStream.rangeClosed(0,6)
				.mapToObj(i -> topLeft.add(i,i))
				.collect(Collectors.toList());
		
		Point2D botLeft = new Point2D(column-3, row + 3);
		List<Point2D> diagonal2 = IntStream.rangeClosed(0,6)
				.mapToObj(i -> botLeft.add(i,-i))
				.collect(Collectors.toList());
		
		return checkRange(vertical)||checkRange(horizontal)||checkRange(diagonal1)||checkRange(diagonal2);
	}

	private boolean checkRange(List<Point2D> points) { // points position of single disk
		int chain = 0;

		for (Point2D p : points) {
			int column = (int) p.getX();
			int row = (int) p.getY();

			Disc disc = getDisc(column, row).orElse(new Disc(!redMove)); // orElse is called if there is no disc on this
																			// position
			if (disc.red == redMove) {
				chain++;
				if (chain == 4) {
					return true;
				}
			}
				else {
					chain = 0;
				}
			}
		
		return false; //if the chain of 4 is not found
	}
	//--------------------------------------------DEFINES THE WINNER-------------------------------------// 
	
	private void gameOver(Stage primaryStage) {

		String s = redMove ? "RED" : "YELLOW";
		GameOver(s, primaryStage);
	}

	//--------------------------------------------CHECKS IF THE DISC CAN BE PLACED-------------------------------------// 
	// Used Optional because it can return null if there
	// is no disc on the position

	private Optional<Disc> getDisc(int column, int row) {
		if (column < 0 || column >= COLUMNS || row < 0 || row >= ROWS) {
			return Optional.empty();
		}
		return Optional.ofNullable(grid[column][row]);

	}
	
	// defines who's turn
	
	private static class Disc extends Circle {
		
		private final boolean red;

		public Disc(boolean red) {
			super(TILE_SIZE / 2, red ? Color.RED : Color.YELLOW);
			this.red = red;
			setCenterX(TILE_SIZE / 2);
			setCenterY(TILE_SIZE / 2);
		}
		
	}
	
	//--------------------------------------------GENERATE GAMEOVER MESSAGE-------------------------------------//
	
    private void GameOver(String s, Stage primaryStage) {
    HBox YN = new HBox(10);
	Text text = new Text ("Game over. The winner is " + s + "!" + "\n" + "    Do you want to play again?");
	
	text.setStyle("-fx-font-size: 14px;");  
	
	GridPane nPane = new GridPane();
	btYes.setMinSize(80, 2);
	btNo.setMinSize(80, 2);
	YN.getChildren().addAll(btYes, btNo);
	
     nPane.setHgap(5);
     nPane.setVgap(10);
     
     nPane.add(text, 0, 1);

     nPane.add(YN, 0, 6);
     YN.setAlignment(Pos.CENTER);
    
     nPane.setAlignment(Pos.CENTER);
     
     Scene scn = new Scene(nPane, 400, 250);
     Stage stage = new Stage();
     stage.setTitle("Game Over");
     stage.setScene(scn);
     stage.show();
     btNo.setOnAction(m -> {
    	 grid = new Disc[COLUMNS][ROWS]; // 2D Grid
    	 discRoot = new Pane();
    	 stage.close();
    	 start(primaryStage);
    	 
		});
     btYes.setOnAction(m -> {
    	 grid = new Disc[COLUMNS][ROWS]; // 2D Grid
    	 discRoot = new Pane();
    	 stage.close();
    	 primaryStage.setScene(new Scene(createContent(primaryStage)));
			primaryStage.show();
		});
     
	}

	// *******************************************ADDRESS BOOK**************************************//
	private void AddressBookOnStart(Stage primaryStage) throws IOException {
		GridPane gridPane = new GridPane();
		
		gridPane.setHgap(2);
		gridPane.setVgap(2);
		
		//HBOX TO SET FIELDS INLINE
		
		HBox hbox = new HBox(10);
		HBox buttons = new HBox(10);
		HBox Fname = new HBox(10);
		HBox Lname = new HBox(10);
		
		//SELECT PROVINCE
		
		ChoiceBox<String> choiceBox = new ChoiceBox<String>();		
		choiceBox.getItems().addAll("Select Province","ON","AB","BC","MB","NT","NB","NL","NS","NU","PE","QC","SK","YT" );
		choiceBox.getSelectionModel().select(0);
	
		
		//FIELDS' MAX WIDTH
		tfFirstName.setMinWidth(600);
		tfFirstName.setMaxWidth(601);
		tfLastName.setMinWidth(600); 
		tfLastName.setMaxWidth(601); 
		tfCity.setMaxWidth(150); 
		tfPostalCode.setMaxWidth(100);
		
		//FIELDS' LABELS
		
		Label label = new Label("City:");
		Label label2 = new Label("Postal Code:");
		Label label3 = new Label("Province:");
		Label label4 = new Label("First Name:");
		Label label5 = new Label("Last Name:");
		
		Fname.getChildren().addAll(label4,tfFirstName);
		Lname.getChildren().addAll(label5,tfLastName);
		hbox.getChildren().addAll(label,tfCity,label3,choiceBox,label2,tfPostalCode );
	
		//BUTTONS' SIZE
		
		btAdd.setMinSize(80, 2);
		btFirst.setMinSize(80, 2);
		btNext.setMinSize(80, 2);
		btPrevious.setMinSize(80, 2);
		btLast.setMinSize(80, 2);
		btUpdate.setMinSize(80, 2);
		btCancel.setMinSize(80, 2);
		
		buttons.getChildren().addAll(btAdd,btFirst,btNext,btPrevious,btLast,btUpdate,btCancel);			
		buttons.setAlignment(Pos.CENTER);
	
		gridPane.add(Fname, 5,10);
		gridPane.add(Lname, 5,20);
		gridPane.add(hbox, 5,30);
		gridPane.add(buttons, 5,50);
		
		Scene scene = new Scene(gridPane, 700, 250);
		primaryStage.setTitle("Address Book");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		RandomAccessFile file = new RandomAccessFile("AddressBook.dat", "rw");
		
		//HANDLE EVENTS
		
		btAdd.setOnAction(e -> {
			String output = choiceBox.getSelectionModel().getSelectedItem().toString();
            if(PostalisValid(tfPostalCode)&&output.length()==2&&tfFirstName.getText().length()!=0&&btLast.getText().length()!=0&&tfCity.getText().length()!=0) {
			try {
				file.seek(file.length());
				write(primaryStage, file,tfFirstName, tfLastName, tfCity, output, tfPostalCode );
			} catch (IOException e2) {
				e2.printStackTrace();
			}
            }

            else if(!PostalisValid(tfPostalCode)&&output.length()==2&&tfFirstName.getText().length()!=0&&btLast.getText().length()!=0&&tfCity.getText().length()!=0) {
	
	          Text text4 = new Text("Incorrect input. Postal Code must contain 6 characters length.");
	          text4.setStyle("-fx-font-size: 12px;");  
	          ErrMessage(primaryStage, "Adress Book",text4);
	          
            }
            
            else if(PostalisValid(tfPostalCode)&&output.length()!=2&&tfFirstName.getText().length()!=0&&btLast.getText().length()!=0&&tfCity.getText().length()!=0) {
            	
  	          Text text4 = new Text("Incorrect input. Select Province.");
  	          text4.setStyle("-fx-font-size: 12px;");
  	          ErrMessage(primaryStage, "Adress Book",text4);
  	        
              }
            
            else if(PostalisValid(tfPostalCode)&&output.length()==2&&tfFirstName.getText().length()==0||btLast.getText().length()==0||tfCity.getText().length()==0) {
            	
            	 Text text4 = new Text("All fields must be filled");
     	         text4.setStyle("-fx-font-size: 12px;");
     	         ErrMessage(primaryStage, "Adress Book",text4);
            }

		});
		
		 
		btFirst.setOnAction(e -> {
			String output = choiceBox.getSelectionModel().getSelectedItem().toString();

			try {
				if (file.length() > 0) {
					file.seek(0);
					read(file, tfFirstName, tfLastName, tfCity, output, choiceBox, tfPostalCode);
					System.out.println("Reading address #1");
					count = 1;
				}
				else {
					System.out.println("Address is empty!");
				}
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
		});
		
		btNext.setOnAction(e -> {
			String output = choiceBox.getSelectionModel().getSelectedItem().toString();

			try {
				if (count * 92 < file.length()) {
					file.seek(count * 92);
					read(file, tfFirstName, tfLastName, tfCity, output, choiceBox, tfPostalCode);
					count++;
					System.out.println("Reading address #" + count);
				}
				else {
					System.out.println("End of file!");
				}
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		});
		
		btPrevious.setOnAction(e -> {
			String output = choiceBox.getSelectionModel().getSelectedItem().toString();

			if (count > 1) 
				count--;
			else
				count = 1;
			
			try {
				file.seek((count * 92) - 92);
			} catch (IOException e1) {
		
				e1.printStackTrace();
			}
			try {
				read(file, tfFirstName, tfLastName, tfCity, output, choiceBox, tfPostalCode);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			System.out.println("Reading address #" + count);
		});
		
		btLast.setOnAction(e -> {
			String output = choiceBox.getSelectionModel().getSelectedItem().toString();

			try {
				count = ((int)file.length()) / 9;
				file.seek((count * 92) - 92);
				read(file, tfFirstName, tfLastName, tfCity, output, choiceBox, tfPostalCode);
				
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
			
			System.out.println("Reading address #" + count);
			
		});
		
		btUpdate.setOnAction(e ->{
		String output = choiceBox.getSelectionModel().getSelectedItem().toString();
	    if(PostalisValid(tfPostalCode)&&output.length()==2&&tfFirstName.getText().length()!=0&&btLast.getText().length()!=0&&tfCity.getText().length()!=0) {
	 	try {
	 		file.seek(count * 92 - 92);
			write(primaryStage, file, tfFirstName, tfLastName, tfCity, output, tfPostalCode);
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
	    }
	 	
	    else if(!PostalisValid(tfPostalCode)&&output.length()==2&&tfFirstName.getText().length()!=0&&btLast.getText().length()!=0&&tfCity.getText().length()!=0) {
	    	
	          Text text4 = new Text("Incorrect input. Postal Code must contain 6 characters length.");
	          text4.setStyle("-fx-font-size: 12px;");  
	          ErrMessage(primaryStage, "Adress Book",text4);
	          
          }
          
          else if(PostalisValid(tfPostalCode)&&output.length()!=2&&tfFirstName.getText().length()!=0&&btLast.getText().length()!=0&&tfCity.getText().length()!=0) {
          	
	          Text text4 = new Text("Incorrect input. Select Province.");
	          text4.setStyle("-fx-font-size: 12px;");
	          ErrMessage(primaryStage, "Adress Book",text4);
	        
            }
          
          else if(PostalisValid(tfPostalCode)&&output.length()==2&&tfFirstName.getText().length()==0||btLast.getText().length()==0||tfCity.getText().length()==0) {
          	
          	 Text text4 = new Text("All fields must be filled");
   	         text4.setStyle("-fx-font-size: 12px;");
   	         ErrMessage(primaryStage, "Adress Book",text4);
          }
	 	
		});
		
		btCancel.setOnAction(e -> {

			start(primaryStage);
		});
		
		file.setLength(0);
	}
	
	
	
	// *******************************************GENERATE ERROR MESSAGE**************************************//
	private void ErrMessage(Stage primaryStage, String title, Text text) {
		
		GridPane nPane = new GridPane();
        nPane.setHgap(1);
        nPane.setVgap(6);
        nPane.add(text, 0, 1);
        nPane.add(btCancel, 0, 6);
        nPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(btCancel, HPos.CENTER);
        Scene scn = new Scene(nPane, 400, 250);
        primaryStage.setTitle(title);
        primaryStage.setScene(scn);
        primaryStage.show();
        btCancel.setOnAction(m -> {try {
			AddressBookOnStart(primaryStage);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}});
	}
	

	// *******************************************GENERATE SUCCESS MESSAGE**************************************//
        private void SuccessMessage(Stage primaryStage, String title, Text text) {
		
		GridPane nPane = new GridPane();
		HBox ok = new HBox(10);
		ok.getChildren().add(btOK);
		ok.setAlignment(Pos.CENTER);
        nPane.setHgap(1);
        nPane.setVgap(6);
        nPane.add(text, 0, 1);
        nPane.add(ok, 0, 6);
        nPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(btCancel, HPos.CENTER);
        Scene scn = new Scene(nPane, 150, 150);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scn);
        stage.show();
        btOK.setOnAction(m -> {
        	stage.close();
		} 
		);
	}
	// *******************************************POSTAL CODE VALIDATION**************************************//
	
	private boolean PostalisValid(TextField code) {
		String str = code.getText();
		
		if(str != " " && str.length() == 6) {	
			return true;	
		}		
		return false;
	}
	
	// *******************************************READ FROM RANDOM ACCESS FILE**************************************//
	
	private void read(RandomAccessFile inout, TextField tfFirstName,TextField tfLastName, TextField tfCity, String province, ChoiceBox<String> choiceBox, TextField tfPostalCode) throws IOException {
		
		@SuppressWarnings("unused")
		int pos;
		
		byte[] fname = new byte[FNAME];	
		pos = inout.read(fname);
		tfFirstName.setText(new String(fname));

		byte[] lname = new byte[LNAME];	
		pos += inout.read(lname);
		tfLastName.setText(new String(lname));

		byte[] city = new byte[CITY];	
		pos += inout.read(city);
		tfCity.setText(new String(city));

		byte[] province1 = new byte[PROVINCE];	
		pos += inout.read(province1);
		province = new String(province1);
		choiceBox.getSelectionModel().select(province);

		byte[] zip = new byte[ZIP];	
		pos += inout.read(zip);
		tfPostalCode.setText(new String(zip));
	}
	
	// *******************************************WRITE TO RANDOM ACCESS FILE**************************************//
	
	private void write(Stage primaryStage, RandomAccessFile inout, TextField tfFirstName,TextField tfLastName, TextField tfCity, String province, TextField tfPostalCode ) throws IOException {
		inout.write(fixedLength(tfFirstName.getText().getBytes(), FNAME)); 
		inout.write(fixedLength(tfLastName.getText().getBytes(), LNAME));
		inout.write(fixedLength(tfCity.getText().getBytes(), CITY));
		inout.write(fixedLength(province.getBytes(), PROVINCE));
		inout.write(fixedLength(tfPostalCode .getText().getBytes(), ZIP));
		Text s = new Text("Address saved!");
		SuccessMessage(primaryStage, "Success", s);
	}
	

	// *******************************************FIXED-LENGTH**************************************//
	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n];
		for (int i = 0; i < x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}

	// *******************************************BANKING**************************************//

	private void BankingOnStart(Stage primaryStage) {
		tfEnterAccount = new TextField();
		GridPane gridPane = new GridPane();
		HBox holder = new HBox(15);
		holder.setAlignment(Pos.CENTER);
		holder.getChildren().addAll(btSubmit,btCancel);
		gridPane.setHgap(2);
		gridPane.setVgap(5);
		gridPane.add(new Label("Enter Account Number: "), 0, 0);
		gridPane.add(tfEnterAccount, 1, 0);
		gridPane.add(holder, 1, 5);

		// Setting the properties for the UI

		gridPane.setAlignment(Pos.CENTER);
		btCancel.setMinSize(50, 2);
		GridPane.setHalignment(btSubmit, HPos.LEFT);
		GridPane.setHalignment(btCancel, HPos.RIGHT);

		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("ATM");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Handling Events
		btSubmit.setOnAction(e -> {
			int _id = 0;

			try {
				String num = tfEnterAccount.getText();
				_id = Integer.parseInt(num);
			}

			catch (NumberFormatException err) {

			}

			if (isIDvalid(_id, arr) && isPin(_id, arr)) {
				displayMenu(_id, primaryStage, arr);
			}

			else if (isIDvalid(_id, arr) && !isPin(_id, arr)) {
				displayNoPinMenu(_id, primaryStage, arr);
			}

			else {
				displayInvalidMenu(_id, primaryStage);
			}
		});

		btCancel.setOnAction(e -> {

			start(primaryStage);
		});
	}

	// *******************************************OBJECT GETTER**************************************//

	public static Account getObjectById(Account[] arr, int _id) {

		Account a = new Account();
		for (int i = 0; i < arr.length; i++) {
			if (_id == arr[i].getId()) {
				a = arr[i];
			}
		}
		return a;
	}

	// *******************************************PIN CHECK METHOD**************************************//
	private boolean isPin(int _id, Account[] arr) {

		if (getObjectById(arr, _id).getPIN() != 0) {
			return true;
		}
		return false;
	}

	// *******************************************PIN VALIDATION METHOD**************************************//

	private boolean isPinCorrect(int _newPin) {

		int length = String.valueOf(_newPin).length();
		if (_newPin != 0 && length == 4)
		{
			return true;
		}
		return false;

	}

	// *******************************************ID VALIDATION METHOD**************************************//

	private boolean isIDvalid(int _id, Account[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (_id == arr[i].getId()) {
			return true;
			}
		}
		return false;

	}

	// *******************************************ACCOUNT MAIN MENU**************************************//

	private void displayMenu(int _id, Stage primaryStage, Account[] arr) {

		Text text = new Text("Welcome");
		Text text2 = new Text("Account " + _id);
		primaryStage.setTitle("ATM");
		GridPane gridPane = new GridPane();
		gridPane.setHgap(6);
		gridPane.setVgap(6);
		gridPane.add(text, 0, 0);
		gridPane.add(text2, 0, 1);
		gridPane.add(btCheckBalance, 0, 3);
		gridPane.add(btWithdraw, 0, 4);
		gridPane.add(btDeposit, 0, 5);
		gridPane.add(btExit, 0, 6);
		gridPane.setAlignment(Pos.CENTER);
		btCancel.setMinSize(50, 2);
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("ATM");
		primaryStage.setScene(scene);
		primaryStage.show();
		getObjectById(arr, _id);

		btCheckBalance.setOnAction(e -> {
			GridPane gPane = new GridPane();
			gPane.setHgap(5);
			gPane.setVgap(5);
			Text text3 = new Text("Balance is $" + getObjectById(arr, _id).getBalance());
			text3.setStyle("-fx-font-size: 14px;");
			gPane.add(text3, 0, 1);
			gPane.add(btCancel, 0, 10);

			gPane.setAlignment(Pos.CENTER);
			GridPane.setHalignment(btCancel, HPos.CENTER);

			Scene sc = new Scene(gPane, 400, 250);
			primaryStage.setTitle("ATM");
			primaryStage.setScene(sc);
			primaryStage.show();
			btCancel.setOnAction(k -> {
				displayMenu(_id, primaryStage, arr);
			});

		});

		btWithdraw.setOnAction(e -> {

			GridPane gPane = new GridPane();
			tfWithdraw = new TextField();
			gPane.setHgap(1);
			gPane.setVgap(7);
			gPane.add(new Label("Enter amount to withdraw: "), 1, 0);
			gPane.add(tfWithdraw, 1, 3);
			gPane.add(btConfirm, 1, 8);
			gPane.add(btCancel, 1, 8);
			
			gPane.setAlignment(Pos.CENTER);
			btConfirm.setAlignment(Pos.BOTTOM_LEFT);
			btCancel.setAlignment(Pos.BOTTOM_RIGHT);
			tfWithdraw.setAlignment(Pos.BOTTOM_CENTER);
			GridPane.setHalignment(btConfirm, HPos.LEFT);
			GridPane.setHalignment(btCancel, HPos.RIGHT);

			Scene sc = new Scene(gPane, 400, 250);
			primaryStage.setTitle("ATM");
			primaryStage.setScene(sc);
			primaryStage.show();

			btConfirm.setOnAction(k -> {

				double amount = 0;
				try {
					String s = tfWithdraw.getText();
					amount = Double.parseDouble(s);
				} catch (NumberFormatException err) {

				}

				double bal = getObjectById(arr, _id).withdraw(amount);
				getObjectById(arr, _id).setBalance(bal);
				displayMenu(_id, primaryStage, arr);
			});
			btCancel.setOnAction(k -> {
				displayMenu(_id, primaryStage, arr);
			});
		});

		btDeposit.setOnAction(e -> {
			GridPane gPane = new GridPane();
			tfDeposit = new TextField();
			gPane.setHgap(1);
			gPane.setVgap(7);
			gPane.add(new Label("Enter amount to deposit: "), 1, 0);
			gPane.add(tfDeposit, 1, 3);
			gPane.add(btConfirm, 1, 8);
			gPane.add(btCancel, 1, 8);
			
			gPane.setAlignment(Pos.CENTER);
			btConfirm.setAlignment(Pos.BOTTOM_LEFT);
			btCancel.setAlignment(Pos.BOTTOM_RIGHT);
			tfDeposit.setAlignment(Pos.BOTTOM_CENTER);
			GridPane.setHalignment(btConfirm, HPos.LEFT);
			GridPane.setHalignment(btCancel, HPos.RIGHT);

			Scene sc = new Scene(gPane, 400, 250);
			primaryStage.setTitle("ATM");
			primaryStage.setScene(sc);
			primaryStage.show();
			btConfirm.setOnAction(k -> {
				double amount = 0;
				try {
					String s = tfDeposit.getText();
					amount = Double.parseDouble(s);

				} catch (NumberFormatException err) {

				}
				double bal = getObjectById(arr, _id).deposits(amount);
				getObjectById(arr, _id).setBalance(bal);
				displayMenu(_id, primaryStage, arr);
			});
			btCancel.setOnAction(k -> {
				displayMenu(_id, primaryStage, arr);
			});
		});

		btExit.setOnAction(e -> {

			BankingOnStart(primaryStage);
		});

	}

	// *******************************************NO PIN MENU**************************************//

	private void displayNoPinMenu(int _id, Stage primaryStage, Account[] arr) {
		Text text3 = new Text("No PIN for this ID. Do you want to create PIN?");
		HBox buttonsHolder = new HBox(20);
		buttonsHolder.getChildren().addAll(btCreatePin,btCancel);
		text3.setStyle("-fx-font-size: 12px;");
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(3);
		gridPane.add(text3, 0, 0);
		gridPane.add(buttonsHolder, 0, 15);
	

		gridPane.setAlignment(Pos.CENTER);
		buttonsHolder.setAlignment(Pos.CENTER);
		GridPane.setHalignment(btCreatePin, HPos.LEFT);
		GridPane.setHalignment(btCancel, HPos.RIGHT);

		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("ATM");
		primaryStage.setScene(scene);
		primaryStage.show();

		btCreatePin.setOnAction(k -> {

			CreatePin(_id, primaryStage, arr);
		});

		btCancel.setOnAction(k -> {
			start(primaryStage);
		});

	}

	// *******************************************CREATE PIN MENU**************************************//

	private void CreatePin(int _id, Stage primaryStage, Account[] arr) {

		GridPane gPane = new GridPane();
		
		gPane.setHgap(1);
		gPane.setVgap(7);
		gPane.add(new Label("Enter PIN (4 digits): "), 1, 0);
		gPane.add(tfPin, 1, 3);
		gPane.add(btConfirm, 1, 8);
		gPane.add(btCancel, 1, 8);

		gPane.setAlignment(Pos.CENTER);
		btConfirm.setAlignment(Pos.BOTTOM_LEFT);
		btCancel.setAlignment(Pos.BOTTOM_RIGHT);

		GridPane.setHalignment(btConfirm, HPos.LEFT);
		GridPane.setHalignment(btCancel, HPos.RIGHT);

		Scene sc = new Scene(gPane, 400, 250);
		primaryStage.setTitle("ATM");
		primaryStage.setScene(sc);
		primaryStage.show();
		btConfirm.setOnAction(l -> {
			int pin = 0;
			// try catch block if user inputs characters instead of digits
			try {

				String s = tfPin.getText();
				pin = Integer.parseInt(s);
			} catch (NumberFormatException e) {

			}

			if (isPinCorrect(pin)) {
				getObjectById(arr, _id).setPIN(pin);
				displayMenu(_id, primaryStage, arr);
			}

			else {

				Text text4 = new Text("Incorrect input. Pin must contain 4 digits.");
				text4.setStyle("-fx-font-size: 12px;");
				GridPane nPane = new GridPane();
				nPane.setHgap(1);
				nPane.setVgap(6);
				nPane.add(text4, 0, 1);
				nPane.add(btCancel, 0, 6);
				nPane.setAlignment(Pos.CENTER);
				GridPane.setHalignment(btCancel, HPos.CENTER);
				Scene scn = new Scene(nPane, 400, 250);
				primaryStage.setTitle("ATM");
				primaryStage.setScene(scn);
				primaryStage.show();
				btCancel.setOnAction(m -> {
					CreatePin(_id, primaryStage, arr);
				});

			}
		});

		btCancel.setOnAction(l -> {
			start(primaryStage);
		});
	}
	// ******************************************* INVALID ID MENU **************************************//

	private void displayInvalidMenu(int _id, Stage primaryStage) {
		Text text3 = new Text("No account for this ID");
		HBox canc = new HBox(10);
		canc.getChildren().add(btCancel);
		text3.setStyle("-fx-font-size: 18px;");
		GridPane gridPane = new GridPane();
		gridPane.setHgap(3);
		gridPane.setVgap(8);
		gridPane.add(text3, 0, 0);
		gridPane.add(canc, 0, 3);
		canc.setAlignment(Pos.CENTER);
		gridPane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("ATM");
		primaryStage.setScene(scene);
		primaryStage.show();

		btCancel.setOnAction(k -> {
			BankingOnStart(primaryStage);
		});

	}

	// *******************************************SERIALIZATION**************************************//

	public static void serializeAccounts(Account[] items) {

		try {
			FileOutputStream fileOut = new FileOutputStream("accounts.dat", true);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(items);
			out.close();
			fileOut.close();
			System.out.println("\nSerialization Successful... Checkout your specified output file..\n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// *******************************************DESERIALIZATION**************************************//

	public static void DeserializeAccounts(Account[] items) throws ClassNotFoundException {
		DecimalFormat numberFormat = new DecimalFormat("#.##");
		numberFormat.setRoundingMode(RoundingMode.CEILING);

		try {
			
			FileInputStream fileIn = new FileInputStream("accounts.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Account ar[] = (Account[]) in.readObject();
			for (int i = 0; i < 10; i++) {
				ar[i] = items[i];
				System.out.println("-----------------------------------");

				System.out.println("First Name: " + ar[i].FName);
				System.out.println("Last Name: " + ar[i].LName);
				System.out.println("ID: " + ar[i].getId());
				System.out.println("Balance: " + ar[i].getBalance());
				System.out.println("Annual Interest Rate: " + ar[i].getAnnualInterestRate());
				System.out.println("Monthly Interest: " + numberFormat.format(ar[i].getMonthlyInterest()));
				System.out.println("Date Created: " + ar[i].getDate());
				in.close();
				fileIn.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// *******************************************CREATE ARRAY OF ACCOUNTS**************************************//

	public static Account[] createArray() {

		int _id = 1234;
		double balance = 100;
		double intRate = 0.2;
		Account[] items = new Account[10];
		String[] names = { "Brian", "John", "Freddie", "Roger", "Syd", "Debbie", "Suzi", "Joan", "Stevie", "Roger" };
		String[] lastnames = { "May", "Dickon", "Mercury", "Taylor", "Barrett", "Harry", "Quatro", "Jett", "Nicks",
				"Waters" };

		for (int i = 0; i < 10; i++) {
			String fName = names[i];
			String lName = lastnames[i];
			Account a = new Account();
			a.FName = fName;
			a.LName = lName;
			a.setId(_id);
			a.setAnnualInterestRate(intRate);
			a.setBalance(balance);
			a.getDate();
			items[i] = a;
			_id++;
			intRate++;

		}

		return items;
	}

	// **************************************************MAIN**************************************************//

	public static void main(String[] args) throws ClassNotFoundException {

		serializeAccounts(createArray());
		DeserializeAccounts(createArray());
		launch(args);
	}
}