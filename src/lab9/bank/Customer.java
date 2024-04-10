package lab9.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.In;

public class Customer implements Serializable{
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.accounts.add(new Account("Savings"));
        this.accounts.add(new Account("Loan"));
    }
    
    public Customer() {
        this.name = readName();
        this.accounts = new ArrayList<>();
        this.accounts.add(new Account("Savings"));
        this.accounts.add(new Account("Loan"));
    }

    private String readName() {        
        System.out.print("Create Accounts for Customer: ");
        return In.nextLine();
    }

    public boolean match(String name){
        return this.name.equals(name);
    }
    
    private Account account(String type){
        for(Account a:accounts)
            if(a.hasType(type))
                return a;
        return null;
    }

    private void deposit() {
        Account savings = account("Savings");
        if(savings != null){
           savings.deposit(readAmount("deposit"));
        }else{
            System.out.println("No such account");
        }
    }

    private void withdraw() {
        double amount = readAmount("withdraw");
        Account savings = account("Savings");
        if(savings != null){
            if (savings.has(amount))
                savings.withdraw(amount);
            else
                System.out.println("Insufficient funds");
        }else{
            System.out.println("No such account");
        }
    }

    private void transfer() {
        double amount = readAmount("transfer");
        Account savings = account("Savings");
        Account loan = account("Loan");
        if(savings != null){
            if (savings.has(amount)){
                if(loan !=null){
                    savings.payTo(amount, loan);
                }else{
                    System.out.println("No such account");
                }
            }else{
                System.out.println("Insufficient funds");
            }
        }else{
            System.out.println("No such account");
        }
    }

    private double readAmount(String action) {
        System.out.print("Amount to "+action+": $");
        return In.nextDouble();
    }

    private void show() {        
        System.out.println(name+" bank statement: "+Bank.DTF.format(Bank.NOW));
        accounts.forEach(System.out::println);        
    }    
    
    @Override 
    public String toString(){
        String s = accounts.stream().map(Object::toString).collect(Collectors.joining(" | "));
        return name+"\t--> "+s; 
    }
    
    private char readChoice(){
        System.out.print("Customer menu (d/w/t/s/x): ");
        return In.nextChar();
    }

    public void use() {
        System.out.println(name+" banking menu: "+Bank.DTF.format(Bank.NOW));
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'd': deposit(); break;
                case 'w': withdraw(); break;
                case 't': transfer(); break;
                case 's': show(); break;
                default: help(); break;
            }
        }
        System.out.println("Back to Bank menu");
    }
    
    private void help() {
        System.out.println("Menu options");
        System.out.println("d = deposit");
        System.out.println("w = withdraw");
        System.out.println("t = transfer");
        System.out.println("s = show");
        System.out.println("x = exit");
    }
}
