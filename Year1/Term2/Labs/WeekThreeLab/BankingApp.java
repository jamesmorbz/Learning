/**
* ECS414U - Object Oriented Programming
* Queen Mary University of London, 2021/22.
* <p>
* Week 3 lab session.
*/

public class BankingApp{
    public static void main(String[] args){

	//////////////////////////////////////////////////
	// DO NOT MODIFY THIS CODE
	Client c;
	PremiumClient pc;
	CorporateClient cc;
	Agent ag;
	//------------------------------------------------

	try{
	    // Uncomment the following tests to verify if your code passes them
	    System.out.println("Test 1 " + ((new Test1()).test()?"OK":"Failed") + "\n--------------------------------------------------\n");
	    System.out.println("Test 2 " + ((new Test2()).test()?"OK":"Failed") + "\n--------------------------------------------------\n");
	    System.out.println("Test 3 " + ((new Test3()).test()?"OK":"Failed") + "\n--------------------------------------------------\n");	    
	    System.out.println("Test 4 " + ((new Test4()).test()?"OK":"Failed") + "\n--------------------------------------------------\n");	    
	} catch (ClassNotFoundException e) {
	    System.out.println("A class was not found. Check that all necessary files are in the directory.");
	}        
    }
}
