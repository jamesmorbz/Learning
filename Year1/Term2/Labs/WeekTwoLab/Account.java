public class Account{
    private int balance;
    private static int count = 0;
    private int id = 0;
    private double interest = 0.01;

    public Account(){
        this.balance=0;
        this.id = count++;
    }

    public Account(int balance){
        this.balance = balance;
    }

    public Account(int balance, double interest){
        this.balance = balance;
        this.interest = interest;
    }

    public int getBalance(){
        return this.balance;
    }

    public int getUniqueId(){
        return this.id;
    }
    
    public double getInterest(){
        return this.interest;
    }

    public void setBalance(int amount){
        this.balance = amount;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public void withdraw(int amount){
        if (amount > this.balance){
            System.out.println("Error. The amount to be withdrawn exceeds this account's balance.");
        } else{
            this.balance -= amount;
        }
    }
}
