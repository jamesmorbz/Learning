import java.util.*;

public class SAE8 {
    
    private static long getPolishSum(String[] input) {
        Stack<String> stackOfChars = new Stack<String>();
        for (int i =input.length-1; i > -1; i--) {
            if (input[i].equals("A")) {
                input[i] = "10";
            }
            if (input[i].equals("B")) {
                input[i] = "11";
            }
            if (input[i].equals("C")) {
                input[i] = "12";
            }
            if (input[i].equals("*")) {
                long firstValue = Long.valueOf(stackOfChars.pop());
                System.out.println(firstValue);
                long secondValue = Long.valueOf(stackOfChars.pop());
                System.out.println(secondValue);
                long holdingValue = 0;
                if (input[i].equals("*")) {
                holdingValue = firstValue * secondValue;
                System.out.println(holdingValue);
                stackOfChars.push(String.valueOf(holdingValue));
                }
            }
            else stackOfChars.push(input[i]);
        }
        return Long.valueOf(stackOfChars.pop());
    }
    public static void main(String[] args)
    {   
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter the Expression: ");
        String input = in.nextLine();
        String[] list = input.split("");
        System.out.println(Arrays.toString(list));      
        System.out.println(getPolishSum(list));
    }                                                       
}