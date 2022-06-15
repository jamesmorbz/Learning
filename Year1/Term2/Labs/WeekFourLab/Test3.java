public class Test3 extends Test{
    public boolean test(){		
	print("**************************************************");
	print("Running test 3");

	boolean success = true;

	Resettable r = new StandardClient("Bob");
	StandardClient c = (StandardClient)r;       
	int amount = (int)((Math.random()+1)*1000);
	c.deposit(amount);	
	success = c.getAccount().getBalance() == amount;

	c.reset();
	success = success && c.getAccount().getBalance() == 0;

	return success;
    }	
}
