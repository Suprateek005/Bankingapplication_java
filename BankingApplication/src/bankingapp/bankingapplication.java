package bankingapp;//package name

import java.util.Scanner;

public class bankingapplication {//class name
 public static void main(String[] args) {//main method
	 Scanner scanner = new Scanner(System.in);

     System.out.println("Welcome to IDBI Banking Application!");
     System.out.print("Enter your Customer Name: ");
     String name = scanner.nextLine();
     System.out.print("Enter your Customer ID: ");
     String id = scanner.nextLine();

     if (name.isEmpty() || id.isEmpty()) {
         System.out.println("Invalid credentials! Both Customer Name and ID are required.");
     } else {
         Bankaccount Bankaccount = new Bankaccount(name, id);
         Bankaccount.showmenu();
     }
 }
}


//closing the main method 
class Bankaccount{//sub class 
	 private String customerName;
	 private String customerId;
	 private double balance = 1000.0;
	 private double previousTransaction;
	
	
	 public Bankaccount(String customerName, String customerId) {
	        this.customerName = customerName;
	        this.customerId = customerId;
	    }
	
	 void deposit(double amt) {
		 if(amt>0) {
			 balance +=amt;
			 previousTransaction =amt;
			 System.out.println("Amount of " + amt + " deposited successfully.");
	        } else {
	            System.out.println("Invalid deposit amount. Please enter a positive value.");
	        }
		 }
			
	
    void withdraw(double amt) {
    	 if (amt > 0 && (balance - amt) >= 1000) {
             balance -= amt;
             previousTransaction = -amt;
             System.out.println("Amount of " + amt + " withdrawn successfully.");
         } else if (amt <= 0) {
             System.out.println("Invalid withdrawal amount. Please enter a positive value.");
         } else {
             System.out.println("Invalid transaction! Insufficient balance or below minimum balance requirement.");
         }
     }
    
    void getpreviousTransaction() {//getter method is used to view the transaction only 
    	if(previousTransaction >0) {//the amount should be greater than 0 value or +ve value
    		System.out.println(" Deposited"+previousTransaction);
    	}
    	else if(previousTransaction <0){
    		System.out.println(" withdraw " +Math.abs(previousTransaction));
    		
    	}
    	else {
    		System.out.println("No transaction occured");
    	}
    }

    	
    void showmenu() {
    	char option;
    	Scanner sc=new Scanner (System.in);
    	
        System.out.println("********************************************");
        System.out.println("Welcome to IDBI Banking Services!");
        System.out.println("Dear " + customerName + ", we are delighted to have you.");
        System.out.println("Your customer ID is: " + customerId);
        System.out.println("********************************************\n");
    	
    	do {
    		System.out.println("===============================================");
    		System.out.println("Enter your option:");
    		System.out.println("===============================================");
    		option=sc.next().charAt(0);
    		System.out.println("\n");
    	
    		switch(option) {
    		 case 'A':
                 System.out.println("Your balance is: " + balance);
                 break;
             case 'B':
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = sc.nextDouble();
                 deposit(depositAmount);
                 break;
             case 'C':
                 System.out.print("Enter amount to withdraw: ");
                 double withdrawAmount = sc.nextDouble();
                 withdraw(withdrawAmount);
                 break;
             case 'D':
                 getpreviousTransaction();
                 break;
             
             default:
                 System.out.println("Invalid option! Please select a valid option.");
         }
    		  System.out.println();
        } while (option != 'E');
    	 System.out.println("Thank you for banking with us, " + customerName + "! See you again.");
        sc.close();
    
    }}
 
    
    	
   

    		
    	
    	
    	
    	
    	
    	
    
