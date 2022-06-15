public abstract class Client extends User {    
     
    private Account account;
    
    public Client(String name){
	super(name);
	this.account = new Account();
    }

    public abstract void deposit(int amount);

    public Account getAccount(){
	return this.account;
    }

    public void setAccount(Account account){
	this.account = account;
    }
    
}
