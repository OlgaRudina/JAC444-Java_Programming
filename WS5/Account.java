import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient int id;
	private transient int pin;
	String FName;
	String LName;
	private transient double balance;
	private transient double annualInterestRate;
	private transient Date dateCreated;

	/** Default constructor **/
	public Account() {
		this.id = 0;
		this.pin = 0;
		this.FName = " ";
		this.LName = " ";
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	/** Constructor with parameters **/
	public Account(int id, double balance) {
		this.id = id;
		this.pin = 0;
		this.balance = balance;
		this.FName = " ";
		this.LName = " ";
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	/** Interest Rate accessor **/
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/** Interest Rate mutator **/
	public void setAnnualInterestRate(double annualInterestRate) {

		this.annualInterestRate = annualInterestRate;
	}
	
	/** ID accessor **/
	public int getId() {
		return id;
	}
	
	/** PIN accessor **/
	public int getPIN() {
		return pin;
	}
	
	/** PIN mutator **/
	public void setPIN(int _pin) {
		this.pin = _pin;
	}
	
	/** ID mutator **/
	public void setId(int id) {

		this.id = id;
	}

	/** Balance accessor **/
	public double getBalance() {
		return balance;
	}
	
	/** Balance mutator **/
	public void setBalance(double balance) {

		this.balance = balance;
	}

	/** Date accessor **/
	 public Date getDate() {
		    return dateCreated;
		  }
	
	 /** The method that returns the monthly interest rate **/
	 public double getMonthlyPayment() {
		    double monthlyInterestRate = annualInterestRate / 1200;
		    return monthlyInterestRate;
	 }
	 
	 
	 /** The method that returns the monthly interest **/
	 
	 public double getMonthlyInterest() {
			double monthlyInterest = Math.pow(1 + annualInterestRate, 1.0 / 12);
			return balance * monthlyInterest;
		}
	 /** The method that withdraws a specified amount from the account **/ 
	 
	 public double withdraw(double amount) {
		    
		 return balance -= amount;
	
	 }
	 
	 /** The method that deposits a specified amount from the account **/
	 
	 public double deposits(double amount) {
		    
		 balance += amount;
		    return balance;
	 }
	 
}
