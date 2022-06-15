
public class Account{
    private int balance;

    
    public Account(){
        this.balance=0;
    }    

    public Account(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }    

    public void setBalance(int amount){
        this.balance = amount;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public void withdraw(int amount) {
    }
    
}
