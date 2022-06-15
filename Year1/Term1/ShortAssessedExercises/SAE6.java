package Learning.ShortAssessedExercises;
/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Version: 1

    This program also takes user input and performs
    comparisons to check which train is the most punctual.
    The most punctual train and the location it was going to
    will be returned once the user provides the "stopcode" in
    the form of a string containing "XXX" at any point.

  *************************************** */

import java.util.*;

public class SAE6 {

    public static void loop() {
        String BestLocation = ""; //Set string for best location
        int BestTime = 2147483647; //Set unbeatable lateness
        int CumulativeTrainLateTime = 0; // Total lateness across all trains counter
        boolean condition = true; //condition which will make loop continue infinitley
        while (condition) {
            Scanner in = new Scanner(System.in);
            System.out.print("What is the destination of the train that just departed? ");
            String Destination = in.nextLine();
            if (Destination.contains("XXX")) { //Ends program if XXX comes up
                if (BestTime == 2147483647) {
                    System.out.println("");
                    System.out.println("No Train Information has been entered. Ending Program.");
                    System.exit(0); //Ends program if XXX comes up
                } else {
                    break;
                }
                
            }
            System.out.print("How many minutes late was it? ");
            int minutes = in.nextInt();
            System.out.println("");
            CumulativeTrainLateTime = CumulativeTrainLateTime + minutes; //Increment total lateness
            if (minutes < BestTime) { //When current train value for lateness is better than current best then overwrite all data written in "Best" Values
                BestTime = minutes;
                BestLocation = Destination;
            } 
        }
        System.out.println("");
        System.out.println("The trains were in total " + CumulativeTrainLateTime + " minutes late."); //Print out the values
        System.out.print("The most punctual train was to " + BestLocation + "."); //Print out the values
        System.out.print(" It was " + BestTime + " minutes late."); //Print out the values

    }
    public static void main(String[] args) {
        loop();
    }
}
