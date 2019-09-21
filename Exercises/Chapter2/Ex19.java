import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

//Task 2.21

public class Ex19 {

	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.##");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
		
		float investmentAmount, annualInterestRate, monthlyInterestRate;
		double futureInvestmentValue;
		
		int numberOfYears;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter investment amount: ");
		
		investmentAmount = input.nextFloat();
		
		System.out.println("Enter annual interest rate in percentage: ");
		
		annualInterestRate = input.nextFloat();
		
		System.out.println("Enter number of years: ");
		
		numberOfYears = input.nextInt();
		
		monthlyInterestRate = (annualInterestRate/100) / 12;
		
		int pow = numberOfYears * 12;
		
		futureInvestmentValue = investmentAmount * (Math.pow((1 + monthlyInterestRate), pow));
		
		System.out.println("Accumulated value is $" + numberFormat.format(futureInvestmentValue));
	}

}
