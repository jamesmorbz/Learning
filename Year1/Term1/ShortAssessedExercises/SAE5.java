package Learning.ShortAssessedExercises;
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

public class SAE5 {
    public static String[] InputValues(String[] ElementList,int loopCap) { //Takes Multiple Args
    double CountingTotalMedals = 0; //Cumulative Medal Counter
    for (int i = 0; i < ElementList.length; i++){ //loop through string
        String[] Elements = ElementList[i].split(", "); // split string 
        CountingTotalMedals = CountingTotalMedals + Integer.parseInt(Elements[2]); // extract medal value from string and use that to perform avg calc
    }
    double AverageMedals = Math.round(CountingTotalMedals / 5.0); // avg calc
    int AverageMedalsInt = (int) AverageMedals; // cast to round
    System.out.println("Between them they won an average of " + AverageMedalsInt + " medals each."); // output
    for(int j=loopCap-1;j>=0;j--) { //Loop Through List backwards so you get most recently added to first added , Index from zero hence loopcap - 1
        System.out.println(ElementList[j]); //Output In Reverse Order i != 0 + i--
    }
    return ElementList; // return it so it could be used further (not necessary though)
}
    public static String[] InputQuestion(String[] ElementList, int loopCap) {
    Scanner in = new Scanner(System.in);
    String[] AllInputs = new String[loopCap];

    for (int i = 0; i < loopCap ; i++) { //Issa Loop
        System.out.print("Name Olympian/Paralympian " + (i+1) + "? "); //Output
        String OlympianName = in.nextLine(); //Input
        System.out.print("How many medals did he/she win? "); //Output
        int NumberOfMedals = in.nextInt(); //Input
        String NumberOfMedalsString = String.valueOf(NumberOfMedals); //String for List
        in.nextLine(); //Input
        System.out.print("What sport did he/she compete in? "); //Output
        String SportName = in.nextLine(); //Input
        System.out.println(""); //Output
        ElementList[0] = SportName; //List Inside Loop
        ElementList[1] = OlympianName; //List Inside Loop
        ElementList[2] = NumberOfMedalsString; //List Inside Loop
        String finalOutputString = String.join(", ", ElementList[0], ElementList[1], ElementList[2]); // create concatenated output string of all the user's answers
        AllInputs[i] = finalOutputString; // Add Concatenated String to List 
    }
    return AllInputs; // Return List with all Concatenated Strings so it can be passed into the other method
    }
    public static void main(String[] args) {
        String[] ElementList = new String[3];
        final int loopCap = 5; // final variable used for specifying how many user inputs my function
        String[] AllInputs = InputQuestion(ElementList, loopCap);
        InputValues(AllInputs, loopCap);
    }
}
