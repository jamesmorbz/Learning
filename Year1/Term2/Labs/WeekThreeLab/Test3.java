public class Test3 extends Test{
    public boolean test() throws ClassNotFoundException{		
	print("**************************************************");
	print("Running test 3");

	boolean success = true;


	//--------------------------------------------------
	// Tests for PremiumClient
	PremiumClient pc = new PremiumClient("Alice");
	pc.deposit(10);
	pc.deposit(200);
	if (Double.compare(pc.getEarnedBonus(),  10*0.001 + 200*0.001) != 0){
	    success = false;
	}
	if (pc.getBalance() != 210){
	    success = false;
	}

	//--------------------------------------------------
	// Reflection tests for PremiumClient
	String[] illegalFields = {"Account"};
	String[] illegalMethods = {"getBalance"};
	if (!reflectionTest("PremiumClient", 2, illegalFields, 9999, illegalMethods)){
	    success = false;
	}	

	return success;
    }	
}
