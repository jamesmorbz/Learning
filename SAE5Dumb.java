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

public class SAE5Dumb {
    public static String[] InputValues(String[] ReallyStupid,int loopCap) { //Takes Multiple Args
    Scanner in = new Scanner(System.in); // scanner init
    double CountingTotalMedals = 0; //Cumulative Medal Counter
    List<String> ArrayOfOutput = new ArrayList<>(); //ArrayList
    for (int i = 0; i <= loopCap ; i++) { //Issa Loop
        System.out.print("Name Olympian/Paralympian " + (i+1) + "? "); //Output
        String OlympianName = in.nextLine(); //Input
        System.out.print("How many medals did he/she win? "); //Output
        int NumberOfMedals = in.nextInt(); //Input
        CountingTotalMedals = CountingTotalMedals + NumberOfMedals; //Increment
        String NumberOfMedalsString = String.valueOf(NumberOfMedals); //String for Array
        in.nextLine(); //Input
        System.out.print("What sport did he/she compete in? "); //Output
        String SportName = in.nextLine(); //Input
        ReallyStupid[0] = SportName; //Array Inside Loop
        ReallyStupid[1] = OlympianName; //Array Inside Loop
        ReallyStupid[2] = NumberOfMedalsString; //Array Inside Loop
        String finalOutputString = String.join(", ", ReallyStupid[0], ReallyStupid[1], ReallyStupid[2]); 
        ArrayOfOutput.add(finalOutputString); 
        System.out.println(""); //Output
    }
    double AverageMedals = Math.round(CountingTotalMedals / 5.0); 
    int AverageMedalsInt = (int) AverageMedals; 
    System.out.println("Between them they won an average of " + AverageMedalsInt + " medals each."); //Output
    for(int i=loopCap;i>=0;i--) { //Issa Loop
        System.out.println(ArrayOfOutput.get(i)); //Output In Reverse Order i != 0 + i--
    } 
    return ReallyStupid;
}
    public static void main(String[] args) {
        String[] ReallyStupid = new String[3];
        final int loopCap = 4; // final variable
        InputValues(ReallyStupid, loopCap);
    }
}
