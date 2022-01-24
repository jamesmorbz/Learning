package Learning.FinalExam;

import java.util.*;

public class Question1 {

    public static int testMultiplication(int numberOfQuestions, int yMax, int xMin, int xMax) {
        Scanner in = new Scanner(System.in);
        int numberOfCorrectAnswers = 0; // counter for correct answers
        Random r = new Random();
        for (int i = 0; i<numberOfQuestions; i++) {
            int randomX = r.nextInt(xMax-xMin+1)+xMin; 
            int randomY = r.nextInt(yMax)+1; 
            int correctAnswer = randomX * randomY;
            System.out.printf("What is %d * %d ? ", randomX , randomY);
            int userAnswer = in.nextInt();
            if (correctAnswer == userAnswer){
                System.out.println("Correct."); 
                numberOfCorrectAnswers ++; // increments the counter by 1
            }
            else{
                System.out.println("Incorrect.");
            }
        }
        return numberOfCorrectAnswers;
    }

    public static int calculatePercentage(int correctAnswers, int numberOfQuestions) {
        return Math.round(((float)correctAnswers / (float)numberOfQuestions) * 100); // calculating percentage casting to ints to mantain accuracy
    }

    public static char getGrade(int percentage) {
        if (percentage>=70) { // if else statments are the boundaries for the grades specified in the question
            return 'A';
        } else if (percentage>=60) {
            return 'B';
        } else if (percentage>=50) {
            return 'C';
        } else if (percentage>=40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static int getStartInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Minimum X Value: ");
        int xMin = in.nextInt();
        if (xMin < 1) {
            System.out.println("Min X value must be greater than 0");
            return getStartInput();
        }
        return xMin;
    }

    public static int getEndInput(int xMin) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Maximum X Value: ");
        int xMax = in.nextInt();
        if (xMax < xMin) {
            System.out.println("Max X value must be greater or equal to Min X value");
            return getEndInput(xMin);
        }
        return xMax;
    }

    public static void printSummary(int numberOfCorrectAnswers, int numberOfQuestions, int percentage, char grade) {
        System.out.printf("You scored %d/%d (%d%c) %c grade.", numberOfCorrectAnswers, numberOfQuestions, percentage, '%', grade);
    }
    public static void main(String[] args) {
        
        final int numberOfQuestions = 12; // final variable for number of questions that will be asked
        final int yMax = 12; // maximum times tables 
        final int xMin = getStartInput(); // user min val input
        final int xMax = getEndInput(xMin); // user max val input, checks against min to make sure max>=min

        int numberOfCorrectAnswers = testMultiplication(numberOfQuestions, yMax, xMin, xMax);
        int percentage = calculatePercentage(numberOfCorrectAnswers, numberOfQuestions); // calculating quiz percentage
        char grade = getGrade(percentage); // grading the quiz

        printSummary(numberOfCorrectAnswers, numberOfQuestions, percentage, grade); // printing summmary of quiz result
        
    }
}

