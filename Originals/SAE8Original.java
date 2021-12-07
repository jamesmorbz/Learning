package Originals;
/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Version: 1

    This program is simply a Polish Notation calculator. 
    The only difference is that this calculator can take Input
    of "A", "B", "C", and "T". These values are not usually supported by
    calculators but in this case are part of the question an perform certain
    functions.

  *************************************** */

import java.util.*;

public class SAE8Original {
    
    public static long getPolishSum(String[] input) {
        Stack<String> stackOfChars = new Stack<String>();
        for (int i=input.length-1; i > -1; i--) {
            if (!(input[i].equals("1") ||input[i].equals("2")||input[i].equals("3") ||input[i].equals("4")||input[i].equals("5")
            ||input[i].equals("6")||input[i].equals("7")||input[i].equals("8")||input[i].equals("9")
            ||input[i].equals("A")||input[i].equals("B")||input[i].equals("C")
            ||input[i].equals("T")||input[i].equals("*"))) {
                System.out.println("Input contained invalid characters...Program Closing");
                System.exit(1);
            }
            if (input[i].equals("A")) {
                input[i] = "10";
            }
            if (input[i].equals("B")) {
                input[i] = "11";
            }
            if (input[i].equals("C")) {
                input[i] = "12";
            }
            if (input[i].equals("T")) {
                long firstValue = Long.valueOf(stackOfChars.pop());
                Long T = firstValue + firstValue+1 + firstValue+2;
                input[i] = Long.toString(T);
            }
            if (input[i].equals("*")) {
                long firstValue = Long.valueOf(stackOfChars.pop());
                long secondValue = Long.valueOf(stackOfChars.pop());
                long newValueAfterCalc = 0;
                newValueAfterCalc = firstValue * secondValue;
                stackOfChars.push(String.valueOf(newValueAfterCalc));
            }
            else stackOfChars.push(input[i]);
        }
        return Long.valueOf(stackOfChars.pop());
    }
    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter the Expression: ");
        String input = in.nextLine();
        String[] list = input.split("");
        Long answer = getPolishSum(list);
        System.out.println("The answer is " + answer);
    }                                                       
}