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
            String DisabilityClass = in.nextLine();
            String LegName = ("Leg" + i);
            System.out.println(LegName);
        }
        System.out.println("The Team is " + Country);



    
}
    public static void main(String[] args) {
        Relay();
    }
}
