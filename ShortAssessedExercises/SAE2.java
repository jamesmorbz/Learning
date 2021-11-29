package ShortAssessedExercises;
/* ***************************************
  Name : James Moreby
  Date : 18/10/2021
  Version: 1

    This program shows that you are able to define and
    take user inputs into a program and then use the
    user inputted data to perform calculations with the
    data and then correctly format outputs with the data
    with the correctly formula manipulation throughout.

  *************************************** */
import java.util.Scanner;

public class SAE2 {
      
    public static int length() {
        Scanner in = new Scanner(System.in); 
        System.out.print("Enter your length (in cm) here: ");
        int length = in.nextInt();
        System.out.println("The length of the room is " + length + " (in cm)");
        return length;
    }
  
    public static int width() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your width (in cm) here: ");
        int width = in.nextInt();
        System.out.println("The width of the room is " + width + " (in cm)");
        return width;
    }
  
    public static int height() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your height (in cm) here: ");
        int height = in.nextInt();
        System.out.println("The Height of the room is " + height + " (in cm)");
        return height;
    }
      
    public static double balloonVolume() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your balloon volume (in m^3) here: ");
        double balloonVolume = in.nextDouble();
        System.out.println("The volume of each balloon is " + balloonVolume + " (in m^3)");
        return balloonVolume;
    }
  
    public static double area() {
        int length = length();
        int width = width();
        int height = height();
        final Double conversion = 1000000.0;
        double area = (length) * (width) * (height) / conversion;
        System.out.println("The area of the room is " + area + " (in m^3)");
        return area;
    }

    public static void balloonsNeeded() {
        double area = area();
        double balloonVolume = balloonVolume();
        double balloonsNeeded = area / balloonVolume;
        int balloonsNeededInt = (int) balloonsNeeded;
        System.out.println("You need " + balloonsNeededInt + " balloons.");
    }
  
    public static void main(String[] args) {
        balloonsNeeded();
    }
}
  