package Learning.Snippets;

public class WhileLoop {

    public static void WhileLoop() {
        // initialization expression
        int i = 1;
        final int loopcount = 5; // Final Variable can't be changed
        // test expression
        while (i <= loopcount) { // while loop + condition
            System.out.println("Hello World"); // output of loop
            i++; // increments i each iteration through the loop
        }
        System.out.println("Stopped Performing While since condition no longer satisfied");
    }
    public static void main(String[] args) {
        WhileLoop();
    }
}