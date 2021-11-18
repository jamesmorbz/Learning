import java.util.*;

public class SAE7 {
    
    public static void Relay() {
        Scanner in = new Scanner(System.in);
        System.out.print("What is the classification (maximum points) of this relay event? ");
        String MaximumPoints = in.nextLine();
        System.out.print("What country is the team representing?");
        String Country = in.nextLine();
        for (int i = 1; i <=4; i++) {
            System.out.print("What is the disability class for leg " + i + "? ");
            String disabilityClass = in.nextLine();
            String name = ("Leg" + i);
            System.out.println(disabilityClass);
            System.out.println(name);
            Record record = new Record(name,disabilityClass);
            System.out.println(record.name);
        }
        System.out.println("The Team is " + Country);
 
    }

    public static void main(String[] args) {
        Relay();
    }
}

public class Record{
    String name;
    String disabilityClass;
    
    public Record(String name, String disabilityClass){
        name = name;
        disabilityClass = disabilityClass;
    }
}
