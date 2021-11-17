import java.util.Scanner;

public class SAE3 {
    
    public static void isDisabled() {
        Scanner in = new Scanner(System.in);
        System.out.print("Are you disabled? (yes/no) ");
        String isDisabled = in.nextLine();
        if (isDisabled.toLowerCase().equals("yes")) {
            System.out.println("Parking for you is free");
        } else if (isDisabled.toLowerCase().equals("no")){
            CostCorrection();
        } else {
            System.out.println("Please answer \"yes\" or \"no\"");
            isDisabled();
        }
    }

    public static double MainLoop() {
        double cost = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("How many hours have you parked for? (1-8) ");
        int hours = in.nextInt();
        if (hours == 1) {
            cost = 3.00;
            return cost;
        } else if (2<=hours && hours<=4) {
            cost = 4.00;
            return cost;
        } else if (5<=hours && hours<=6) {
            cost = 4.50;
            return cost;
        } else if (7<=hours && hours<=8) {
            cost = 5.50;
            return cost;
        } else {
            System.out.println("Enter an input within range...");
            return MainLoop();
        }

    }
    public static void CostCorrection() {
        Scanner in = new Scanner(System.in);
        boolean LocalBool;
        boolean OAPBool;
        double cost = MainLoop();
        System.out.print("Do you have an \"I live Locally badge\"? (yes/no) ");
        String Local = in.nextLine();
        System.out.print("Are you an OAP? (yes/no) ");
        String OAP = in.nextLine();

        if (Local.toLowerCase().equals("yes")) {
            LocalBool = true;
        } else {
            LocalBool = false;
        }
        if (OAP.toLowerCase().equals("yes")) {
            OAPBool = true;
        } else {
            OAPBool = false;
        }
        
        if (LocalBool == true) {
            cost = cost - 1.00;
        }
        if (OAPBool == true) {
            cost = cost - 2.00;
        }
        System.out.println("The parking charge for you is " + cost + "0 pounds.");
    }
    public static void main(String[] args) {
        isDisabled();
        
    }
}
