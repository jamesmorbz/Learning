public class Test4 extends Test{
    public boolean test() throws ClassNotFoundException{		
	print("**************************************************");
	print("Running test 4");
	print("Expecting 1 error message");

	boolean success = true;

	//--------------------------------------------------
	// Tests for Agent
	Agent agent = new Agent("M. Smart");
	agent.addClient(new Client("Don"));
	agent.addClient(new PremiumClient("Barbara"));
	
	if (arrayLength(agent.getClients())!=2){
	    success = false;
	}
		
	agent.addClient(new Client("Edward"));
	agent.addClient(new PremiumClient("Robert"));
	agent.addClient(new CorporateClient("Bernie", 12345));
	
	if (arrayLength(agent.getClients())!=5){
	    success = false;
	}
	
	agent.addClient(new Client("Hymie"));
	if (arrayLength(agent.getClients())!=5){
	    success = false;
	}
	
	//--------------------------------------------------
	// Reflection tests for Agent
	String[] illegalFields = {};
	String[] illegalMethods = {};
	if (!reflectionTest("Agent", 3, illegalFields, 2, illegalMethods)){
	    success = false;
	}	

	return success;
    }	
}
