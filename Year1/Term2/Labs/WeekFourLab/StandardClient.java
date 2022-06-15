public class StandardClient extends Client implements Resettable{

    public StandardClient(String name){
	super(name);
    }

    public void deposit(int amount) {
        Account account = getAccount();
        account.deposit(amount);
    }

    public void reset() {
        setAccount(new Account());
    }
}


