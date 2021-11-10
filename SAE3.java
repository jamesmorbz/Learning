import java.util.Scanner;

public class SAE3 {
    
    public static boolean isDisabled() {
        Scanner in = new Scanner(System.in);
        System.out.println("Are you disabled? ");
        String isDisabled = in.nextLine();
        if (isDisabled.toLowerCase().equals("yes")) {
            return true;
        } else if (isDisabled.toLowerCase().equals("no")) {
            return false;
        } else {
            isDisabled();
            return true;
        } 
    }

    public static void main(String[] args) {
        boolean disabledBool = isDisabled();
        System.out.println(disabledBool);
        
    }
}
