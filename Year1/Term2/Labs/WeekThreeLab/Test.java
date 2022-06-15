import java.lang.reflect.*;

public abstract class Test{
    
    protected static void print(Object s){
	System.out.println(s.toString());
    }

    protected static int arrayLength(Object[] arr){
	int length = 0;
	for (int i=0; i < arr.length; i++){
	    if (arr[i] != null){
		length++;
	    }   
	}
	return length;
    }

    public abstract boolean test() throws ClassNotFoundException;

    protected boolean reflectionTest(String className, int maxFields, String[] illegalFields, int maxMethods, String[] illegalMethods) throws ClassNotFoundException{
	boolean success = true;

	Class cl = Class.forName(className);
	Field fieldlist[]  = cl.getDeclaredFields();
	
	boolean hasExtraFields = fieldlist.length > maxFields;
	for (int i = 0; i < fieldlist.length; i++){
	    for (int j = 0; j < illegalFields.length; j++){
		hasExtraFields = hasExtraFields || fieldlist[i].toString().contains(illegalFields[j]);
	    }
	}
	if (hasExtraFields){
	    success = false;
	    print("Hint: Did you define any unnecessary fields in "  + className + "?");
	}

	Method methods[] = cl.getDeclaredMethods();
	boolean hasExtraMethods = methods.length > maxMethods;
	for (int i = 0; i < methods.length; i++){
	    for (int j = 0; j < illegalMethods.length; j++){
		hasExtraMethods = hasExtraMethods || methods[i].toString().contains(illegalMethods[j]);
	    }
	}

	if (hasExtraMethods){
	    success = false;
	    print("Hint: Did you define any unnecessary methods in " + className + "?");
	}

	return success;
	
    }
}
