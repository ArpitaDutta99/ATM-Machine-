// package ATM;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Account {
        private int customerNumber;
        private int pinNumber;
        private double CurrentBalance = 0 ;
        private double SavingsBalance=0;
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    
    
    public int setCustomerNumber(int customerNumber){ //set the customer number...
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber(){//get the customer number...
        return customerNumber;
    }

    public int setPinNumber(int PinNumber){ //Set the pin number...
        this.pinNumber = PinNumber;
        return PinNumber;
    }

    public int getPinNumber(){ //get the pin number...
        return pinNumber;
    }

    public double getCurrentBalance(){ //get Current account balance...
        return CurrentBalance;
    }

    public double getSavingsBalance(){ //get Savings account balance...
        return SavingsBalance;
    }

    public double calcCurrentWithdraw(double amount){ // Calculate Current Account balance after withdraw 
        CurrentBalance = (CurrentBalance - amount);
        return CurrentBalance;
    }

    public double calcSavingsWithdraw(double amount){ //Calculate Savings Account balance after withdraw...
        SavingsBalance = (SavingsBalance - amount);
        return SavingsBalance;
    }

    public double calcCurrentDeposit(double amount){ //Calculate Current Account balance after Deposit....
        CurrentBalance = (CurrentBalance + amount);
        return CurrentBalance;
    }

    public double calcSavingsDeposit(double amount){
        SavingsBalance = (SavingsBalance + amount);
        return SavingsBalance;
    }

    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(CurrentBalance));
        System.out.print("Amount you want to withdraw from Current Account: ");
        double amount = input.nextDouble();

        if ((CurrentBalance - amount) >= 0){
            calcCurrentWithdraw(amount);
            System.out.println("New Current Account Balance: " + moneyFormat.format(CurrentBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getSavingsWithdrawInput(){
        System.out.println("Savings Account Balance: " + moneyFormat.format(SavingsBalance));
        System.out.print("Amount you want to withdraw from Savings Account: ");
        double amount = input.nextDouble();

        if((SavingsBalance - amount) >= 0) {
            calcSavingsWithdraw(amount);
            System.out.println("New Savings Account balance: "+ moneyFormat.format(SavingsBalance) +"\n");
        }else{
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getCurrentDepositInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(CurrentBalance));
        System.out.print("Amount you want to deposit to the Current Account: ");
        double amount = input.nextDouble();

        if((CurrentBalance + amount) >= 0){
            calcCurrentDeposit(amount);
            System.out.println("New Current account balance: " + moneyFormat.format(CurrentBalance)); 
        }else{
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getSavingsDepositInput(){
        System.out.println("Savings Account Balance: " + moneyFormat.format(SavingsBalance));
        System.out.println("Amount you want to deposit to the Savings Account: ");
        double amount = input.nextDouble();

        if ((SavingsBalance + amount) >= 0) {
            calcSavingsDeposit(amount);
            System.out.println("New Savings account balance: " + moneyFormat.format(SavingsBalance));
        }else{
            System.out.println("Balance cannot be negative." + "\n");
        }

        
    }


}



	
