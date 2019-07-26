import java.util.Random;

public class Ex03 {

	public static void main(String[] args) {
	
		Random r = new Random();
		
		int num = r.nextInt(11);
		
		switch(num) {
		
		case 0: System.out.println("12" + " December");
		break;
		case 1: System.out.println(num + " January");
		break;
		case 2: System.out.println(num + " February");
		break;
		case 3: System.out.println(num + " March");
		break;
		case 4: System.out.println(num + " April");
		break;
		case 5: System.out.println(num + " May");
		break;
		case 6: System.out.println(num + " June");
		break;
		case 7: System.out.println(num + " July");
		break;
		case 8: System.out.println(num + " August");
		break;
		case 9: System.out.println(num + " September");
		break;
		case 10: System.out.println(num + " October");
		break;
		case 11: System.out.println(num + " November");
		
		}

	}

}
