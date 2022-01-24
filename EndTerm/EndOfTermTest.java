package Learning.EndTerm;
import java.lang.System; //imports
import java.util.*; //imports
import java.util.Scanner; //imports

public class EndOfTermTest { //start of class

    public static int TargetScore() {
        Scanner in = new Scanner(System.in); // init scanner so user can input target score
        System.out.print("Target Score?  "); // output
        int TargetScore = in.nextInt(); // user inputs next int
        return TargetScore; // return int target score so it can be used in other methods
    }

    public static void DrawCard() {
        Scanner in = new Scanner(System.in); // init scanner so user can input h or l
        final int MaxRandomValue = 10; // final variable used for random number gen
        int Sum = 0; // cumulative sum counter
        int Count = TargetScore();
        int GoodGuess = 0; // cumulative good gues counter
        int BadGuess = 0; // cumulative sbad guess counter
        int PrevRandomNum = -1; //holds value of previous random num so that the code can compare and check if your guess was good or not
        for (int i = 1; i <= Count; i++) { // for loop that iterates through as long as you don't pass round: Target Score
        int CurrrandomNum = randomInt(MaxRandomValue); // gets random num
        System.out.println("I drew a " + CurrrandomNum );
        Sum += CurrrandomNum; // adds random num to sum
        if (Sum > Count) {
            if (GoodGuess < BadGuess) {
                System.out.println("Nice try, You scored " + GoodGuess); // if lose
                System.exit(1);
            } else if (GoodGuess > BadGuess) {
                System.out.println("You Win!"); // if win
                System.exit(1);
            } else {
                System.out.println("It's a draw!"); // if good guesses = bad guesses therefore draw
                System.exit(1);
            }
        } 

        System.out.print("Round " + i + ": Higher or lower? (h/l)  ");
        String response = in.nextLine();
        if (response.toLowerCase().contains("h")) { // compares input and looks for "h" - small error handling allows capital letters as valid
            if (PrevRandomNum > CurrrandomNum) {
                GoodGuess += 1; // increments good guess by one each time they make good guess
                PrevRandomNum = CurrrandomNum; // stores current random number as previous random number for next loop
            } else {
                BadGuess += 1; // increments bad guess by one each time they make bad guess
                PrevRandomNum = CurrrandomNum; // stores current random number as previous random number for next loop
            }
        } else if (response.toLowerCase().contains("l")) { // compares input and looks for "l" - small error handling allows capital letters as valid
            if (PrevRandomNum < CurrrandomNum) {
                GoodGuess += 1; // increments good guess by one each time they make good guess
                PrevRandomNum = CurrrandomNum; // stores current random number as previous random number for next loop
            } else {
                BadGuess += 1; // increments bad guess by one each time they make bad guess
                PrevRandomNum = CurrrandomNum; // stores current random number as previous random number for next loop
            }
        }
    }
        System.out.println("You reached finished Round: " + Count ); 
        }

    public static int randomInt(int bound) {
        Random r = new Random(); // random number gen object
        return r.nextInt(bound); // random number gen
        }
    public static void main(String[] args) {
        DrawCard();
    }
}