import java.util.*;

public class SAE5 {
    public static void InputValues() {
    Scanner in = new Scanner(System.in);
    double CountingTotalMedals = 0;
    List<String> ArrayOfOutput = new ArrayList<>();
    for (int i = 0; i < 5 ; i++) {
        System.out.print("Name Olympian/Paralympian " + (i+1) + "? ");
        String OlympianName = in.nextLine();
        System.out.print("How many medals did he/she win? ");
        int NumberOfMedals = in.nextInt();
        CountingTotalMedals = CountingTotalMedals + NumberOfMedals;
        String NumberOfMedalsString = String.valueOf(NumberOfMedals);
        in.nextLine();
        System.out.print("What sport did he/she compete in? ");
        String SportName = in.nextLine();
        String finalOutputString = String.join(", ", SportName, OlympianName, NumberOfMedalsString);
        ArrayOfOutput.add(finalOutputString);
        System.out.println("");
    }
    double AverageMedals = Math.round(CountingTotalMedals / 5.0);
    int AverageMedalsInt = (int) AverageMedals;
    System.out.println("Between them they won an average of " + AverageMedalsInt + " medals each.");
    for(int i=4;i>=0;i--) {
        System.out.println(ArrayOfOutput.get(i));
    } 
}
    public static void main(String[] args) {
        InputValues();
    }
}
