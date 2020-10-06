/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarasb
 */
public class Accounts {
    
    private String accNo;
    private String accUser;
    private double balance;
    
    public Accounts(String accNumber,String accHolder, double accBalance){
        this.accNo = accNumber;
        this.accUser = accHolder;
        this.balance = accBalance;
        
    }
    
    public void withdraw(double m) {
     this.balance = this.balance -m;
     
}
    public void deposit(double amount) {
        this.balance = this.balance +amount;
    }
    public void transfer(Accounts a, double amount){
      this.withdraw(amount);
      a.deposit(amount);
    }
    public String getAccountHolder() {
        return this.accUser;
    }
    public double getBalance(){
        return this.balance;
    }
    
    @Override
    public String toString() {
        return this.accNo;
    }
}