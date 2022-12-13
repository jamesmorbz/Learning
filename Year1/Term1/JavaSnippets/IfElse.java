package Learning.Snippets;

public class IfElse {
     
    public static void If() {
        boolean condition = false;

        if (condition) {
            System.out.println("This will not be printed since it's false.");
        }

        if (!condition) {
            System.out.println("This will printed since it's got a NOT gate.");
        }
    }
    public static void Elif() {
        int number = 20;
  
        // condition 1
        if (number < 10) {
            System.out.println("number is less than 10\n");
  
        // condition 2
        } else if (number > 15) {
            System.out.println("number is more than 15\n");
  
        // condition 3
        } else if (number > 20) {
            System.out.println("number is more than 20\n");
        }
    }
    public static void main(String[] args) {
        If();
        Elif();
    }
}