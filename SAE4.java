/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Version: 1

    This program allows the user to get the
    information relating to the attraction that
    they specify. This information can only be retrieved
    about attractions that are currently hard coded into
    the program.

  *************************************** */

import java.util.Scanner;


public class SAE4 {

    public static int numberOfAttractions() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many attractions do you want to look up: ");
        int numberOfAttractions = in.nextInt();
        System.out.println("You want to see details of " + numberOfAttractions + " attractions, coming up!");
        System.out.println(" ");
        return numberOfAttractions;
    }

    public static void requestedAttraction(attraction TheEdenProject, attraction TateModern, attraction TheLondonZoo, attraction ChessExhibition) {
        int numberOfAttractions = numberOfAttractions();
        for (int i = 0; i < numberOfAttractions; i++) {
            Scanner in = new Scanner(System.in);
            System.out.print("Which Attraction do you want information about? ");
            String requestedAttraction = in.nextLine();
                if (requestedAttraction.equals(TheEdenProject.name)) {
                    if (TheEdenProject.bankHolidays == true) {
                        System.out.println(TheEdenProject.name + " opens on bank holidays!");
                    } else {
                        System.out.println(TheEdenProject.name + " does not opens on bank holidays!"); }
                    System.out.println("It opens at " + TheEdenProject.time + "am.");
                    System.out.println("");
                } else if (requestedAttraction.equals(TateModern.name)) {
                    if (TateModern.bankHolidays == true) {
                        System.out.println(TateModern.name + " opens on bank holidays!");
                    } else {
                        System.out.println(TateModern.name + " does not opens on bank holidays!"); }
                    System.out.println("It opens at " + TateModern.time + "am.");
                    System.out.println(""); 
                } else if (requestedAttraction.equals(TheLondonZoo.name)) {
                    if (TheLondonZoo.bankHolidays == true) {
                        System.out.println(TheLondonZoo.name + " opens on bank holidays!");
                    } else {
                        System.out.println(TheLondonZoo.name + " does not opens on bank holidays!"); }
                    System.out.println("It opens at " + TheLondonZoo.time + "am.");
                    System.out.println("");
                } else if (requestedAttraction.equals(ChessExhibition.name)) {
                    if (ChessExhibition.bankHolidays == true) {
                        System.out.println(ChessExhibition.name + " opens on bank holidays!");
                    } else {
                        System.out.println(ChessExhibition.name + " does not opens on bank holidays!"); }
                    System.out.println("It opens at " + ChessExhibition.time + "am.");
                    System.out.println("");
                } else {
                    System.out.println("I don't have any information about that attraction!");
                    System.out.println(""); }
        }    
    }

    public static void objectAdder() {
        attraction TheEdenProject = new attraction("The Eden Project", 9, true);
        attraction TateModern = new attraction("Tate Modern", 10, false);
        attraction TheLondonZoo = new attraction("The London Zoo", 10, true);
        attraction ChessExhibition = new attraction("Chess Exhibition", 2, true);
        System.out.println("Choose from the selection of attractions below:");
        System.out.println(TheEdenProject.toString());
        System.out.println(TateModern.toString());
        System.out.println(TheLondonZoo.toString());
        System.out.println(ChessExhibition.toString());
        System.out.println("");
        requestedAttraction(TheEdenProject, TateModern, TheLondonZoo, ChessExhibition);
    }
    public static void main(String[] args) {
        objectAdder();
    }
}
class attraction {
    String name;
    int time;
    boolean bankHolidays;
    
    public String toString() {
        return name;
    }
    
    public attraction(String attractionName, int openingTime, boolean openOnBankHolidays) {
        name = attractionName;
        time = openingTime;
        bankHolidays = openOnBankHolidays;
    }
}