/**
* ECS414U - Object Oriented Programming
* Queen Mary University of London, 2021/22.
* <p>
* Week 2 lab session.
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BankingApp{

    private static boolean test1(){
	System.out.println("**************************************************");
	System.out.println("Running test 1");
        int numAccounts = 50;
        Account[] accs = new Account[numAccounts];
        
        for (int i = 0; i < numAccounts; i++){
            accs[i] = new Account();
        }

	boolean success = true;	
        for (int i = 0; i < numAccounts; i++){
            for (int j = 0; j < numAccounts; j++){
                if (i != j){
                    success = success && (accs[i].getUniqueId() != accs[j].getUniqueId());
                }
            }
        }
	return success;
    }


    private static boolean test2(){		
	System.out.println("**************************************************");
	System.out.println("Running test 2");
	System.out.println("Expecting 2 error messages.");
	User u1 = new User("Bob");
	boolean success = true;
	success = success && u1.getFunds() == 0;
	u1.addAccount(new Account(10));
	success = success && u1.getFunds() == 10;
	u1.addAccount(new Account(5));
	success = success && u1.getFunds() == 15;
	u1.addAccount(new Account(2));
	success = success && u1.getFunds() == 17;
	u1.addAccount(new Account(2));
	success = success && u1.getFunds() == 17;

	User u2 = new User("Alice");
	success = success && u2.getFunds() == 0;
	u2.addAccount(new Account(1));
	success = success && u2.getFunds() == 1;
	u2.addAccount(new Account(1));
	success = success && u2.getFunds() == 2;
	u2.addAccount(new Account());
	success = success && u2.getFunds() == 2;
	u2.addAccount(new Account(1));
	success = success && u2.getFunds() == 2;
	
	return success;
    }

    private static boolean test3(){		
	System.out.println("**************************************************");
	System.out.println("Running test 3");
	System.out.println("Expecting 6 error messages.");
	User u1 = new User("Bob");
	boolean success = true;
	for (int i=0; i < 4; i++){
	    u1.deposit(i,10);
	    success = success && u1.getFunds() == 0;
	}

	u1.addAccount(new Account(10));
	success = success && u1.getFunds() == 10;
	u1.addAccount(new Account(1));
	success = success && u1.getFunds() == 11;
	u1.withdraw(2,1);
	success = success && u1.getFunds() == 11;
	u1.withdraw(1,10);
	success = success && u1.getFunds() == 11;
	u1.withdraw(1,1);
	success = success && u1.getFunds() == 10;

       
	return success;
    }


    private static boolean test4(){
	System.out.println("**************************************************");
	System.out.println("Running test 4");
	User user = new User("Bob");
	String report = user.generateReport().replaceAll(" ", "");
	Pattern p = Pattern.compile("\\p{Blank}");
	Matcher m = p.matcher(report);
	String cleanReport = m.replaceAll("");
	return cleanReport.equals("Name:"+user.getName()+".Funds:"+user.getFunds());
    }

    
    private static boolean test5(){
	System.out.println("**************************************************");
	System.out.println("Running test 5");
	User user = new User("Bob");
	user.addAccount(new Account(1));
	user.addAccount(new Account(100,0.05));
	user.addAccount(new Account());
	boolean success = 0 == Double.compare(user.calculateEarnings(),  1*0.01 + 100*0.05);
	return success;
	
    }

    public static void main(String[] args){

	// Uncomment the following tests to verify if your code passes them
	
	System.out.println("Test 1 "+ (test1()?"OK":"Failed") + "\n--------------------------------------------------\n");
	System.out.println("Test 2 " + (test2()?"OK":"Failed") + "\n--------------------------------------------------\n");
	System.out.println("Test 3 " + (test3()?"OK":"Failed") + "\n--------------------------------------------------\n");
	System.out.println("Test 4 " + (test4()?"OK":"Failed") + "\n--------------------------------------------------\n");
	System.out.println("Test 5 " + (test5()?"OK":"Failed") + "\n--------------------------------------------------\n");
        
    }
}
