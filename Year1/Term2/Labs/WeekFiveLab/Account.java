
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

    public void deposit(int amount){
        this.balance += amount;
    }    

    public void withdraw(int amount){
        this.balance -= amount;
    }

    public String toString(){
	return "Balance: " + this.balance;
    }
    
}
