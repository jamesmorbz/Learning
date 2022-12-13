import java.util.ArrayList;

public class ArrayOfAccounts {

    private final ArrayList<Account> arr;
    private static String ACCOUNT_NOT_FOUND = "ACCOUNT_NOT_FOUND";

    public ArrayOfAccounts() {
        this.arr = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.arr.add(account);
    }

    public Account returnAccountWithHighestBalance() {
        Account highestAccount = this.arr.get(0);
        for (Account account : this.arr) {
            if (account.getBalance() > highestAccount.getBalance()) {
                highestAccount = account;
            }
        }
        return highestAccount;
    }

    public int returnTotalBalance() {
        int totalBalance = 0;
        for (Account account : this.arr) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public Account depositIntoLowestAccount(int amount) {
        Account lowestAccount = this.arr.get(0);
        for (Account account : this.arr) {
            if (account.getBalance() < lowestAccount.getBalance()) {
                lowestAccount = account;
            }
        }
        lowestAccount.deposit(amount);
        return lowestAccount;
    }

    public Account returnAccountAtUniqueIdentifier(int identifier) throws UniqueIdentifierException {
        for (Account account : this.arr) {
            if (account.getUniqueId() == identifier) {
                return account;
            }
        }
        throw new UniqueIdentifierException(ACCOUNT_NOT_FOUND, "there is no Account that has that identifier ");
    }

    public void removeAccountAtUniqueIdentifier(int identifier) throws UniqueIdentifierException {
        boolean exists = false;
        for (int i = 0; i < this.arr.size(); i++) {
            if (this.arr.get(i).getUniqueId() == identifier) {
                exists = true;
                this.arr.remove(i);
            }
        }
        if (!exists) {
            throw new UniqueIdentifierException(ACCOUNT_NOT_FOUND, "there is no Account that has that identifier");
        }
    }

    public static void main(String[] args) throws UniqueIdentifierException {

        ArrayOfAccounts array = new ArrayOfAccounts();
        array.addAccount(new Account(10));
        array.addAccount(new Account(20));
        array.addAccount(new Account(30));

        Account highest = array.returnAccountWithHighestBalance();
        System.out.println(
                "R1+2: Account " + highest.getUniqueId() + " has the highest balance of £" + highest.getBalance());

        System.out.println("R3: The total balance of account is £" + array.returnTotalBalance());

        Account lowest = array.depositIntoLowestAccount(10);
        System.out.println("R4: Account " + lowest.getUniqueId()
                + " had the lowest balance and was deposited an extra 10 pounds giving a balance of £"
                + lowest.getBalance());

        Account uniqueAccount1 = array.returnAccountAtUniqueIdentifier(2);

        try {
            Account uniqueAccount2 = array.returnAccountAtUniqueIdentifier(4); 
        } catch (Exception e) {
            System.out.println("R5: " + e);
        }

        array.removeAccountAtUniqueIdentifier(2);

        try {
            array.removeAccountAtUniqueIdentifier(2);
        } catch (Exception e) {
            System.out.println("R6: " + e);
        }
    }
}
