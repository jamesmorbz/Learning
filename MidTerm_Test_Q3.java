import java.util.Scanner;

public class MidTerm_Test_Q3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i<= 700; i++){
            System.out.print("Student " + i + ": what subject are you studying? ");
            String subject = in.nextLine();
        if (subject.equals("Computer Science")){
                System.out.println("Your Lecture is at 2pm");
            }
        else if (subject.equals("Robotics")){
                System.out.println("Your Lecture is at 1pm");
            }
        else if (subject.equals("Electronic Engineering")){
                System.out.println("Your Lecture is at 3pm");
            }
        }        
    }
}
