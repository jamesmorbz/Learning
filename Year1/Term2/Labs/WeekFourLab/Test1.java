import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test1 extends Test{
    public boolean test(){			    
	print("**************************************************");
	print("Running test 1");	
	    
	//--------------------------------------------------
	// Tests for Client
	Account acc1 = new Account();
	int amount = (int)((Math.random()+1)*1000);
	acc1.deposit(amount);
	String report = acc1.toString();
	
	Pattern p = Pattern.compile("\\p{Blank}");
	Matcher m = p.matcher(report);
	String cleanReport = m.replaceAll("");
	boolean success = cleanReport.equals("Balance:"+amount);
	    
	return success;
    }	
}
