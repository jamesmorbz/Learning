/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Program: ChatBotv2
  Stage of Prod: Level 4
  Usage: Program will have a short conversation with you
        Once you give the program your name it will use
        your name whenever it talks to you. It will then ask
        you if you like it's favourite sport.

*************************************** */

import java.util.*;

public class ChatBot2 {
    public static String quickChat() {
        /* ******************************
        
        Asks user for name
        Uses the inputted name in output
        Allows User to Know that input is expected
        Returns a String

        ******************************* */
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: Hi! What's your name?");
        System.out.print("<Unknown User>: ");
        String name = in.nextLine();
        System.out.println("Bot: It's nice to meet you " + name + " I think we're going to be friends!");
        return name;
    }
    public static void hobbiesChat(String name) {
        /* ******************************
        
        Defines Local Variables which are used in print statements
        Asks the user questions
        Uses If/Elif/Else Control Flow to enhance user experience
        Lets the user know you expect input by starting each line with <name>:

        ******************************* */
        String Interest = "Tennis";
        String Fact = "It is really good for your fitness";
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: Do you like " + Interest + "?");
        System.out.print(name +": ");
        String response = in.nextLine();
        if (response.toLowerCase().contains("yes")) {
            System.out.println("Bot: Me too!");
            System.out.println("Bot: " + Fact + "!");
        } else if (response.toLowerCase().contains("no")) {
            System.out.println("Bot: Aww...You should try it out!");
            System.out.println("Bot: " + Fact + "!");
        } else {
            System.out.println("Bot: I didn't quite catch that. I'm silly sometimes! Do you like " + Interest + "? Try \"yes\" or \"no\"");
            hobbiesChat(name);
        }

    }
    public static void moviesChat(String name) {
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: How many movies have you watched in the last week?");
        System.out.print(name + ": ");
        String stringNumberOfMovies = in.nextLine();
        char[] characters = stringNumberOfMovies.toCharArray();
        Integer value = null;
        boolean isPrevDigit = false;
        for(int i=0; i<characters.length; i++) {
            if(isPrevDigit == false) {
                if(Character.isDigit(characters[i])) {
                    isPrevDigit = true;
                    value = Character.getNumericValue(characters[i]);
                }
            } else {
                if (Character.isDigit(characters[i])) {   
                    value = (value*10)+ Character.getNumericValue(characters[i]);
                } else {
                    break;
                }
            }
        }
        if (value == null) {
            System.out.println("Bot: Your input didn't answer my question. Make sure you have digits in your answer!");
            moviesChat(name);
        }
        System.out.println("That's awesome!");
        System.out.println("Bot: Tell me which movies!");
        for (int i = 0; i<value; i++) {
            System.out.println("Bot: Name one of the movies!");
            System.out.print(name +": ");
            String movieName = in.nextLine();
            System.out.println(movieName + " sounds like an really good movie");
    }
    System.out.println("Bot: All those movies were awesome, I'm gonna have watch them!");
}
            

    public static void main(String[] args) {
        String name = quickChat();
        hobbiesChat(name);
        moviesChat(name);
    }

}
