public class Test2 extends Test{
    public boolean test(){		
	print("**************************************************");
	print("Running test 2");
	
	Client c = new StandardClient("Bob");
	int amount = (int)((Math.random()+1)*1000);
	c.deposit(amount);	
	boolean success = c.getAccount().getBalance() == amount;
	
	return success;
    }	
}
