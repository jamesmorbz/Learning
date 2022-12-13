public class Account {
    private int balance;

    private static int uniqueIdCounter = 0;
    private int uniqueId;

    private double interestRate;

    public Account() {
        this.balance = 0;
        this.interestRate = 0.01;
        this.uniqueId = uniqueIdCounter;
        uniqueIdCounter++;
    }

    public Account(int balance) {
        this();
        this.balance = balance;
    }

    public Account(int balance, double interestRate) {
        this();
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int amount) {
        this.balance = amount;
    }

    public int getUniqueId() {
        return this.uniqueId;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > this.balance) {
            System.out.println("Error. The amount to be withdrawn exceeds this account's balance.");
        } else {
            this.balance -= amount;
        }
    }
}
