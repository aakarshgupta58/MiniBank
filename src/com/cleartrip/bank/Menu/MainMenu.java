package com.cleartrip.bank.Menu;

import com.cleartrip.bank.Account.BankAccount;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by gaakarsh on 01/04/18.
 */
public class MainMenu {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Scanner str =new Scanner(System.in);
        int userChoice;
        Integer tmpAccountNumber = 0;
        Double amount = 0.0;
        Boolean quit = false;
        BankAccount account;

        Map<Integer, BankAccount> accountMap = new HashMap<Integer, BankAccount>();

        do{
            System.out.println("1. Create Account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Display Account Details");
            System.out.println("0. to quit: \n");
            System.out.print("Enter Your Choice : ");
            userChoice = in.nextInt();
            switch (userChoice) {

            case 1:// Create Account
                System.out.print("Enter your Name : ");
                account = new BankAccount(str.nextLine()); // New Account creation
                accountMap.put(account.getAccountNumber(), account);
                account.getDetailsOfAccount();
                break;

            case 2: // deposit
                System.out.print("Enter your account Number : ");
                tmpAccountNumber=in.nextInt();
                if(accountMap.containsKey(tmpAccountNumber)){
                    account = accountMap.get(tmpAccountNumber);
                    System.out.print("Enter Amount Of Money : ");
                    amount = in.nextDouble();
                    account.depositMoney(amount);
                    System.out.println("\t Successfully Deposited.");
                    System.out.println("Your Current Balance : "+account.getAvailableBalance());
                }
                else
                    System.out.println("Wrong Account Number.");
                break;

            case 3: // withdraw money
                System.out.print("Enter your account Number : ");
                tmpAccountNumber=in.nextInt();

                if(accountMap.containsKey(tmpAccountNumber)){
                    account = accountMap.get(tmpAccountNumber);
                    if(account.getAvailableBalance()==0)
                        System.out.print("Your Account is Empty.");

                    else{
                        System.out.print("Enter Amount Of Money : ");
                        amount=in.nextDouble();
                        account.withdrawMoney(amount);
                        System.out.println("\t Successfully Withdrawn.");
                        System.out.println("Your Current Balance : "+account.getAvailableBalance());
                    }
                }
                else
                    System.out.println("Wrong Account Number.");
                break;

            case 4: // check balance

                System.out.print("Enter your Account Number : ");
                tmpAccountNumber=in.nextInt();

                if(accountMap.containsKey(tmpAccountNumber)){
                    account = accountMap.get(tmpAccountNumber);
                    System.out.println("Your Current Balance : "+account.getAvailableBalance());
                }
                else
                    System.out.println("Wrong Account Number.");
                break;

            case 5: // display all info

                System.out.print("Enter your Account Number :");
                tmpAccountNumber=in.nextInt();
                if(accountMap.containsKey(tmpAccountNumber)){
                    account = accountMap.get(tmpAccountNumber);
                    account.getDetailsOfAccount();
                }else
                    System.out.println("Wrong Account Number.");

                break;
            case 0:
                quit = true;
                break;
            default:
                System.out.println("Wrong Choice.");
                break;
            }

            System.out.println("\n");
        }
        while (!quit);
        System.out.println("Thanks for using the ClearTrip Bank.");
    }
}
