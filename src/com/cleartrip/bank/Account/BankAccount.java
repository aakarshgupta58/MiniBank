package com.cleartrip.bank.Account;

import com.cleartrip.bank.Exceptions.DailyLimitExceedException;
import com.cleartrip.bank.Exceptions.InsufficientBalanceException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaakarsh on 01/04/18.
 */
public class BankAccount {

    static final Double MAX_WITHDRAWL_LIMIT = 100000.00;

    private String accountHolderName;
    private Integer accountNumber;
    private Double availableBalance;
    private String modifyDate;
    private Double maxWithdrawlLimitForToday;

    public BankAccount(String accountHolderName){
        this.accountHolderName = accountHolderName;
        accountNumber = (int)((Math.random() * 100000000)+100000000);
        availableBalance = 0.0;
        maxWithdrawlLimitForToday = MAX_WITHDRAWL_LIMIT;
        modifyDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
    }


    Boolean checkDailyLimitWithdrawalForToday(Double amount){
        String today = new SimpleDateFormat("ddMMyyyy").format(new Date());
        if(!today.equals(modifyDate)){
            maxWithdrawlLimitForToday = MAX_WITHDRAWL_LIMIT;
            modifyDate = today;
        }
        if(maxWithdrawlLimitForToday >= amount){
            return Boolean.TRUE;
        }else
            return Boolean.FALSE;
    }

    void updateDailyLimitWithdrawalForToday( Double amount){
        maxWithdrawlLimitForToday -= amount;
    }

    Boolean checkForSufficientBalance(Double amount){
        if(availableBalance >=amount)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    public void withdrawMoney( Double amount){
        if(checkDailyLimitWithdrawalForToday(amount)){
            if(checkForSufficientBalance(amount)){
                availableBalance -= amount;
                updateDailyLimitWithdrawalForToday(amount);
            }else
                throw new InsufficientBalanceException("Bank Account: " +accountNumber+ " does not have sufficient Balance to withdraw " +amount+ " Rs.");
        }else
            throw new DailyLimitExceedException("Daily Limit of Withdrawal for Bank Account: " + accountNumber+ " exceeded. Please come again tomorrow.");
    }

    public void depositMoney( Double amount){
        System.out.println(availableBalance+"prev");
        availableBalance +=amount;
        System.out.println(availableBalance+"aftre");
    }

    public void getDetailsOfAccount(){
        System.out.println("-------Bank Account Details-------");
        System.out.println("\n\tDon't Forget Account Number\n");
        System.out.println(" Account Number: "+ accountNumber);
        System.out.println(" Account Holder: "+ accountHolderName);
        System.out.println(" Available Balance: "+ availableBalance);
        System.out.println(" Maximum withdrawal Limit of the Account: "+ MAX_WITHDRAWL_LIMIT);
        System.out.println(" Withdrawal Limit remaining for today: "+ maxWithdrawlLimitForToday);
    }

    public Integer getAccountNumber(){
        return accountNumber;
    }

    public Double getAvailableBalance(){
        return availableBalance;
    }
}
