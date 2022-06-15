package Learning.ShortAssessedExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SAE8 {

    public static int compare(ArrayList<String> expression, int i){

        if (expression.get(i).matches("\\d+") || expression.get(i).equals("A") || expression.get(i).equals("B") // REGEX for letters + Numbers
                || expression.get(i).equals("C")){
            if(i< expression.size()-1 && expression.get(i+1).equals("T") ){ // Looking for T
                return 0;
            }
            else{return 1;}
        }

        else if (expression.get(i).equals("T")){ // Looking for T
            return 1;
        }
        else { // this is important such that it does not confuse 1T and T1
            return 0;
        }
    }

    public static int checkForCalculation(ArrayList<String> expression, int startingPosition){
        int value = 0;
        value += compare(expression,startingPosition);  //values are two integers or a T followed by an integer
        value += compare(expression,startingPosition+1); //values are two integers or a T followed by an integer
        return value;
    }

    public static int firstAppearance(ArrayList<String> expression, int i, boolean foundValue){

        if (!foundValue){ //until there are two integers next to each other
            int checkValue = checkForCalculation(expression, i);
            if (checkValue ==2) { //or a T followed by an integer returning the index
                return firstAppearance(expression, i, true); //position of the T or integer.
            }
            else {
                i++;
                return firstAppearance(expression, i, false);
            }
        }
        else{
            return i;
        }
 
    }

    public static int convertingLetters(int firstValue, ArrayList<String> expression){

        return switch (expression.get(firstValue)) {
            case "A" -> 10; // if value = A value actually equals 10
            case "B" -> 11; // if value = B value actually equals 11
            case "C" -> 12; // if value = C value actually equals 12
            default -> Integer.parseInt(expression.get(firstValue));
        };
    }

    public static void performSingularCalculation(ArrayList<String> expression){
        int firstValue = firstAppearance(expression, 0, false);
        if (expression.get(firstValue).equals("T")){
            int additionValue = convertingLetters(firstValue+1, expression);
            String calculation = Integer.toString((additionValue + additionValue+1 + additionValue+2));
            expression.remove(firstValue+1);
            expression.set(firstValue,calculation);
        }
        else {
            int multiplicationValue = convertingLetters(firstValue, expression);
            int secondMultiplicationValue = convertingLetters(firstValue+1, expression);
            String calculation = Integer.toString((multiplicationValue*secondMultiplicationValue));
            expression.remove(firstValue+1);
            expression.remove(firstValue);
            expression.set(firstValue-1, calculation);
        }
    }

    public static void performAllCalculations(ArrayList<String> expression){
        if (expression.size()!=1){  // keeps going until only one left
            performSingularCalculation(expression);
            performAllCalculations(expression);
        }
        else{ // keeps going until only one left
            String onlyValue = Integer.toString(convertingLetters(0,expression));
            expression.set(0, onlyValue);

        }
    }

    public static void recursiveInput(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please input the expression  ");
            String StringExpression = scanner.nextLine();

            ArrayList<String> expression = new ArrayList<>(List.of(StringExpression.split("(?!^)"))); // splits string into every single part
            performAllCalculations(expression);
            System.out.println("The answer is " + expression.get(0));
        }
        catch (IndexOutOfBoundsException e) { // If it slips out of bounds we know that REGEX probably didn't match, if an invalid expression is, entered an index out of bound error always occurs
            System.out.println("Invalid expression entered");
            recursiveInput();
        }
    }

    public static void main(String[] args) {

        recursiveInput(); // recursive call

    }

}