
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WS1 {
    public static void main(String[] args) {
    	
    	DecimalFormat numberFormat = new DecimalFormat("#.##");
    	numberFormat.setRoundingMode(RoundingMode.CEILING);
    	
    	//Task 1
    	
        System.out.print("Enter a,b,c,d,e,f: ");
        Scanner input = new Scanner(System.in);

        double[] nums = new double[6];

        for(int i = 0; i < 6;){

   
            if(input.hasNextDouble()) {
            	 nums[i] = input.nextDouble();
            	 i++;
            }
            
            else {
            	
            	input.nextLine();
            }
            
        }
        

        double x,y;

        if((nums[0]*nums[3] - nums[1]*nums[2]) != 0) {

            x = (nums[4] * nums[3] - nums[1] * nums[5]) / (nums[0] * nums[3] - nums[1] * nums[2]);

            y = (nums[0] * nums[5] - nums[4] * nums[2]) / (nums[0] * nums[3] - nums[1] * nums[2]);

            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
        
       
    

        else{

            System.out.println("The equation has no solution");
        }
        
        //Task 2
        
        int year, q, m, j, k, h;
        
        System.out.print("Enter year: (e.g., 2012): ");
        
        year = input.nextInt();
        
        System.out.print("Enter month: 1-12: ");
        
        m = input.nextInt();
        
        if(m == 1) {
        	
        	m = 13;
        	year -= 1;
        }
        
        
       if(m == 2) {
        	
        	m = 14;
        	year -= 1;
        }
        
        System.out.print("Enter the day of the month: 1-31: ");
        
        q = input.nextInt();
        
        j = year/100;
        
        k = year%100;
        
        h = (q + 26*(m+1)/10 + k + k/4 + j/4 +5*j)%7;

        System.out.print("Day of the week is " );
        
        switch(h) {
        
        case 0: System.out.println("Saturday");
            break;
          case 1:
        	System.out.println("Sunday");
            break;
          case 2:
        	  System.out.println("Monday");
            break;
          case 3:
        	  System.out.println("Tuesday");           
            break;
          case 4:
        	  System.out.println("Wednesday");   
            break;
          case 5:
        	  System.out.println("Thursday");
            break;
          case 6:
        	  System.out.println("Friday");
            break;
        }
        
        
      //Task 3
        
        double mPayment, mIntRate, loan, factor, total, interest, principal;
        int numOfYears;
        
        System.out.print("Loan Amount: ");
        
        loan = input.nextDouble();
        
        System.out.print("Number of Years: ");
        
        numOfYears = input.nextInt();
        numOfYears *= 12;
        
        System.out.print("Annual Interest Rate: ");
        
        mIntRate = input.nextDouble();
        
        
        double l = (mIntRate/100)/12;
        
        factor = ((Math.pow((1+l),numOfYears)) - 1)/(l*(Math.pow((1+l),numOfYears)));
        
        mPayment = loan/factor; 
        
        System.out.println("Monthly Payment: " +  numberFormat.format(mPayment));
        
        total = mPayment*numOfYears;
        
        System.out.println("Total Payment: " + numberFormat.format(total));
        System.out.println("\n" + "Payment#" + "\t" + "Interest" + "\t" + "Principal" + "\t" + "Balance" + "\n");
        for (int i = 1; i <= numOfYears; i++) {
        	interest = l * loan;
        	principal = mPayment - interest;
        	loan = loan - principal;
            if(i == numOfYears && loan != 0) {
        		
        		loan = 0;
        	}
        	System.out.println(i + "\t\t" + numberFormat.format(interest)
        	+ "\t\t" + numberFormat.format(principal) + "\t\t" + numberFormat.format(loan));
        	
        	
        	}
        
        input.close();
        }

    }




