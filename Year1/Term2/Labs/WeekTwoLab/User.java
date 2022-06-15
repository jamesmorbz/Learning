import java.util.ArrayList;
import java.text.MessageFormat;

public class User{

    private String name;
    private ArrayList<Account> CurrentAccounts = new ArrayList<Account>();

    public User(String name){
        this.name = name;
    }

    public void addAccount(Account NewAccount) {
        int length = this.CurrentAccounts.size();
        if (length > 2) {
            System.out.println("Error Adding Account to User. Max Limit Exceeded");
        } else {
            this.CurrentAccounts.add(NewAccount);
        }
    }

    public int getFunds() {
        int Sum = 0;
        for (Account tempAccount : this.CurrentAccounts) {
            Sum += tempAccount.getBalance();
        }
        return Sum;
    }

    public void deposit(int account, int amount) {

        if (account > CurrentAccounts.size() - 1) {
            System.out.println("Account Not Linked to User");
        } else if (CurrentAccounts.size() == 0) {
            System.out.println("No Accounts Associated with User");
        } else {
            this.CurrentAccounts.get(account).deposit(amount);
        }
    }

    public void withdraw(int account, int amount) {

        if (account > CurrentAccounts.size() - 1) {
            System.out.println("Account Not Linked to User");

        } else if (CurrentAccounts.size() == 0) {
            System.out.println("No Accounts Associated with User");
        } else {
            this.CurrentAccounts.get(account).withdraw(amount);
        }
    }

    public String generateReport() {
        int Sum = 0;
        for (Account tempAccount : this.CurrentAccounts) {
            Sum += tempAccount.getBalance();
        }
       return MessageFormat.format("Name:   {0}.    Funds:  {1} ", this.name, Sum );
    }

    public double calculateEarnings() {
        double Earnings = 0.0;
        for (Account tempAccount : this.CurrentAccounts) {
            Earnings += tempAccount.getBalance() * tempAccount.getInterest();
        }
        return Earnings;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
