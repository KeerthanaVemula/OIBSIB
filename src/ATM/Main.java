package ATM;

import java.util.Scanner;

public class Main {

	static int accountBalance = 10000;
	static Scanner sc = new Scanner(System.in);
	static String confirm;
	static int amount;
	static int availBalance=10000;

	public static void main(String[] args) {

		System.out.println("Welcome to ATM...");

		System.out.println("Please Enter the User ID: ");
		String userID = sc.nextLine();

		System.out.println("Enter your User Pin: ");
		int userPin = sc.nextInt();

		System.out.println("You have succesfully logged in");

		System.out.println("Welcome " + userID);

		String response="";
		do {
		System.out.println("\n*******Main Menu**********");

		System.out.println("\n Press 1 for View Transcation History");
		System.out.println(" Press 2 for Withdraw");
		System.out.println(" Press 3 for Diposit");
		System.out.println(" Press 4 for Transfer");
		System.out.println(" Press 5 for Quit");

		System.out.println("\n************************");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			transcationHistory();
			break;

		case 2:
			withdraw();
			break;

		case 3:
			diposit();
			break;

		case 4:
			transfer();
			break;

		case 5:
			quit();
			break;
		}
		
		System.out.println("Press 'Y' to go to Main Menu or 'N' to Quit");
		
		response=sc.next();
		}
		
		while(response.equalsIgnoreCase("Y")) ;
		

	}
		

	public static void withdraw() {

		System.out.println("Enter the amount you want to withdraw: ");
		amount = sc.nextInt();
		System.out.println("Confirm? Y/N ");
		confirm = sc.next();
		if (confirm.equalsIgnoreCase("Y")) {
			
			if(amount<accountBalance) {
				System.out.println("Withdrawl successful! Please collect your money " + amount);
				availBalance = accountBalance - amount;
				System.out.println("Available balance :" + availBalance);
				
			}
			
			else {
				System.out.println("Insufficient funds");
			}
		}

		else {
			System.out.println("Withdraw Unsuccesful");
		}

		
	}

	public static void diposit() {

		System.out.println("Enter the amount you want to diposit: ");
		amount = sc.nextInt();
		System.out.println("Confirm? Y/N ");
		confirm = sc.next();

		if (confirm.equalsIgnoreCase("Y")) {
			System.out.println("The amount " + amount + " has been successfully diposited ");
			availBalance = accountBalance + amount;
			System.out.println(" New balance :" + availBalance);

		}

		else {
			System.out.println("Diposition of funds Unsuccesful");
		}
	}
	

	public static void transfer() {

		System.out.println("Enter the amount you want to transfer: ");
		amount = sc.nextInt();
		System.out.println("Confirm? Y/N ");
		confirm = sc.next();

		if (confirm.equalsIgnoreCase("Y")) {
			
			if(amount<accountBalance) {
				System.out.println("transfer successful!");
				availBalance = accountBalance-amount;
				System.out.println("New balance :" + availBalance);
				
			}
			
			else {
				System.out.println("Insufficient funds");
			}
			
			

		} else {
			System.out.println("Transfer of funds Unsuccesful");
		}

	}

	public static void transcationHistory() {

		if (availBalance == accountBalance) {
			System.out.println("No recent transactions");
		}

		else if (availBalance > accountBalance) {
			System.out.println(amount + " credited to your account");
		}

		else if (availBalance <accountBalance) {
			System.out.println(amount + " debited from your account");
		}

	}

	public static void quit() {
        
		System.out.println("Thank you for using ATM!");
		System.exit(0);

	}

}
