// package ATM;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.sound.sampled.SourceDataLine;

import java.io.IOException;
import java.text.DecimalFormat;
public class Menu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x=1;

        do{
            try{
                data.put(9876543, 9876);
                data.put(8989898, 3894);
                data.put(8969797,4346);
                
                System.out.println("Welcome to the Atm Project!");

                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2 ; 
            }
            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
        } while (x==1);
    }

    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Current Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
            getCurrent();
            break;

            case 2:
            getSavings();
            break;

            case 3:
            System.out.println("Thank you for using this ATM, bye.");
            break;

            default:
            System.out.println("\n" + "Invalid Choice."+"\n");
            getAccountType();
        }
    } 
    

    public void getCurrent(){
        System.out.println("Current Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
            System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
            getAccountType();
            break;

            case 2:
            getCurrentWithdrawInput();
            getAccountType();
            break;

            case 3:
            getCurrentDepositInput();
            getAccountType();
            break;

            case 4:
            System.out.println("Thank You for using this ATM, bye.");

            default:
            System.out.println("\n" + "Invalid choice." + "\n");
            getCurrent();
        }
    }

    public void getSavings(){
        System.out.println("Savings Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
            System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
            getAccountType();
            break;

            case 2:
            getSavingsWithdrawInput();
            getAccountType();
            break;

            case 3:
            getSavingsDepositInput();
            getAccountType();
            break;

            case 4:
            System.out.println("Thank You for using this ATM, bye.");

            default:
            System.out.println("\n" + "Invalid choice." + "\n");
            getCurrent();
        }

    }
}
