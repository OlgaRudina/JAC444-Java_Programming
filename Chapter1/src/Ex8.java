
public class Ex8 {

	public static void main(String[] args) {
	
		double distance;
		double speed;
		double time;
		
		time = (60 * 60) + (40 * 60) + 35; // in sec
		
		time = time / 60 / 60; //in hours
		
		distance = 24.0 * 1.6;
		
		speed = distance / time;
		
		System.out.println(speed);


	}

}
