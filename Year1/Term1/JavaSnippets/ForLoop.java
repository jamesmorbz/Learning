package Learning.Snippets;

public class ForLoop {

    public static void LoopForVar() {
        int variable = 5;
        // This loop will loop until "i" is no longer less than "variable". "i" is incremented every iteration through the program.
        for (int i = 0; i < variable; i++) {
            System.out.println("Loop " + i);
        }
        System.out.println();
    }
    
    public static void LoopForList() {
        String[] list = {"Alice", "Bob", "Carol", "Dan"};
        // This loop will loop until "i" is no longer less than len(list). "i" is incremented every iteration through the program.
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        System.out.println();
    }

    public static void EnhancedLoop() {
        // create an array
    int[] numbers = {3, 9, 5, -5};
    int sum = 0;
    // for each loop 
    for (int number: numbers) {
      System.out.println(number);
      sum += number;
    }
        System.out.println("Sum of Array = " + sum);
        System.out.println();
    }
    public static void main(String[] args) {
        LoopForVar();
        LoopForList();
        EnhancedLoop();
    }
}