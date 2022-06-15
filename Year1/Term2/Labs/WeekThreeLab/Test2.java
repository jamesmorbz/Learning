public class Test2 extends Test{
    public boolean test() throws ClassNotFoundException{		
	print("**************************************************");
	print("Running test 2");
	
	boolean success = true;

	//--------------------------------------------------
	// Tests for CorporateClient
	CorporateClient cc = new CorporateClient("QMUL", 123321);
	if (cc.getCompanyRegistrationNumber() != 123321){
	    success = false;
	}	
	cc.deposit(10);
	cc.deposit(200);
	if (cc.getBalance() != 210){
	    success = false;
	}	

	//--------------------------------------------------
	// Reflection tests for CorporateClient
	String[] illegalFields = {"Account"};
	String[] illegalMethods = {"getBalance"};
	if (!reflectionTest("CorporateClient", 1, illegalFields, 1, illegalMethods)){
	    success = false;
	}
		
	return success;
    }	
}
