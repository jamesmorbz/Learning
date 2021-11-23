/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Version: 1

    This program provides information about the
    olympians and paralympians that the user specifies.
    It lists them in Sport,Name,Medal Order and then performs
    a calculation based on the information that is provided.
    this calculation will provide the average medals won between the
    people provided

  *************************************** */

import java.util.*;

public class SAE5Proper {
    public static void InputValues() {
    Scanner in = new Scanner(System.in);
    double CountingTotalMedals = 0; //Cumulative Medal Counter
    List<String> ArrayOfOutput = new ArrayList<>(); //List for the Strings
    for (int i = 0; i < 5 ; i++) {
        System.out.print("Name Olympian/Paralympian " + (i+1) + "? ");
        String OlympianName = in.nextLine();
        System.out.print("How many medals did he/she win? ");
        int NumberOfMedals = in.nextInt();
        CountingTotalMedals = CountingTotalMedals + NumberOfMedals; //Incrementing TotalMedals by Current Number
        String NumberOfMedalsString = String.valueOf(NumberOfMedals);
        in.nextLine();
        System.out.print("What sport did he/she compete in? ");
        String SportName = in.nextLine();
        String finalOutputString = String.join(", ", SportName, OlympianName, NumberOfMedalsString); // Create string from the 3 value inputs
        ArrayOfOutput.add(finalOutputString); //Add String to List
        System.out.println("");
    }
    double AverageMedals = Math.round(CountingTotalMedals / 5.0); //Do maths on average medals
    int AverageMedalsInt = (int) AverageMedals; //Rounding
    System.out.println("Between them they won an average of " + AverageMedalsInt + " medals each.");
    for(int i=4;i>=0;i--) {
        System.out.println(ArrayOfOutput.get(i)); //Iterate through List Strings backwards therefore printing them in reverse order
    } 
}
    public static void main(String[] args) {
        InputValues();
    }
}
