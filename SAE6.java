import java.util.*;

public class SAE6 {

    public static void loop() {
        String BestLocation = "";
        int BestTime = 2147483647;
        int CumulativeTrainLateTime = 0;
        boolean condition = true;
        while (condition) {
            Scanner in = new Scanner(System.in);
            System.out.print("What is the destination of the train that just departed? ");
            String Destination = in.nextLine();
            if (Destination.contains("XXX")) {
                if (BestTime == 2147483647) {
                    System.out.println("");
                    System.out.println("No Train Information has been entered. Ending Program.");
                    System.exit(0);
                } else {
                    break;
                }
                
            }
            System.out.print("How many minutes late was it? ");
            int minutes = in.nextInt();
            System.out.println("");
            CumulativeTrainLateTime = CumulativeTrainLateTime + minutes;
            if (minutes < BestTime) {
                BestTime = minutes;
                BestLocation = Destination;
            } 
        }
        System.out.println("");
        System.out.println("The trains were in total " + CumulativeTrainLateTime + " minutes late.");
        System.out.print("The most punctual train was to " + BestLocation + ".");
        System.out.print(" It was " + BestTime + " minutes late.");

    }
    public static void main(String[] args) {
        loop();
    }
}
