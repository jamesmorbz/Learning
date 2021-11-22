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
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;
import java.util.ArrayList;

import java.util.*;
import java.util.concurrent.TimeUnit;

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
        /* ******************************
        
        Asks the user to enter how many movies they watched
        Takes their input and searches through the string until it finds a number
        Takes this number and asks the user to enter movies they watched


        ******************************* */
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: How many movies have you watched in the last month?");
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
        } else if (value == 0) {
            System.out.println("Bot: You didn't watch any movies?? I love watching movies!");
            System.out.println("Bot: What did you do instead?");
            System.out.print(name + ": ");
            String alternativeActivity = in.nextLine();
            System.out.println("I've never done " + alternativeActivity + " before, I must try it!");
        } else {
        System.out.println("Bot: You watched " + value + " movies! That's awesome! I'm really interested to find out more about the movies you watched!");
        for (int i = 0; i<value; i++) {
            int min = 1;
            int max = 2;
            int randomNum = (int) Math.floor(Math.random()*(max-min+1)+min);
            System.out.println("Bot: Name one of the movies!");
            System.out.print(name +": ");
            String movieName = in.nextLine();
            if (randomNum == 1) {
                System.out.println("Bot: " + movieName + " sounds like an really good movie");
            } else {
                System.out.println("Bot: " + movieName + " doesn't sound very interesting");
                System.out.println("Bot: What genre is " + movieName );
                System.out.print(name + ": ");
                String movieDescription = in.nextLine();
                if (movieDescription.contains("Horror")) {
                    System.out.println("Bot: AHHHHH! That's Scary!!!!");
                    System.out.println("Bot: Did you enjoy it?!");
                    System.out.print(name + ": ");
                    String horrorEnjoy = in.nextLine();
                    if (horrorEnjoy.toLowerCase().contains("yes")) {
                        System.out.println("Bot: You're crazy!");
                    } else {
                        System.out.println("Bot: I'm gonna take that as a no!");
                    }
                        
                } else {
                    System.out.println("Bot: I might quite like that actually");
                }
            }
        }
    }
}
    public record Records() {
    
        static class userChosenSubjectDetails {
            String userChosenSubject;
            String userFactAboutTopic;
            String userHowLongForTopic;
        }
        public static String getUserChosenSubject(userChosenSubjectDetails nw) { 
            return nw.userChosenSubject;
        }

        public static String getUserFactAboutTopic(userChosenSubjectDetails nw)  { 
            return nw.userFactAboutTopic;
        }
        public static String getuserHowLongForTopic(userChosenSubjectDetails nw)  { 
            return nw.userHowLongForTopic;
        }
        public static userChosenSubjectDetails setUserChosenSubject(userChosenSubjectDetails nw, String userChosenSubject) {
            nw.userChosenSubject = userChosenSubject;
            return nw;
        }
        public static userChosenSubjectDetails setUserFactAboutTopic(userChosenSubjectDetails nw, String userFactAboutTopic) {
            nw.userFactAboutTopic = userFactAboutTopic;
            return nw;
        }
        public static userChosenSubjectDetails userHowLongForTopic(userChosenSubjectDetails nw, String userHowLongForTopic) {
            nw.userHowLongForTopic = userHowLongForTopic;
            return nw;
        }

        public static userChosenSubjectDetails setUserChosenSubjectDetails(userChosenSubjectDetails nw, String n, String y, String l) {
            nw = setUserChosenSubject(nw, n);
            nw = setUserFactAboutTopic(nw, y);
            nw = userHowLongForTopic(nw, l);
            return nw;
        }
        public static String toStringSubjectDetails(userChosenSubjectDetails nw) {
            String s = getUserChosenSubject(nw) + ", " + getUserFactAboutTopic(nw) + ", " + getuserHowLongForTopic(nw);
            return s;
        }
        public static void createUserChosenSubject(String name) {
            ArrayList<String> details = ChatBot2.userPicksTopic(name);
            userChosenSubjectDetails subjectDetails = new userChosenSubjectDetails();
            subjectDetails = setUserChosenSubjectDetails(subjectDetails, details.get(0), details.get(1), details.get(2));
            System.out.println(toStringSubjectDetails(subjectDetails));
            return;
        }
    }

    public static ArrayList<String> userPicksTopic(String name) {
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: I don't want to bore you with movie chatter. What would you like to talk about?");
        System.out.print(name + ": ");
        String userChosenSubject = in.nextLine();
        System.out.println("Bot: Ok! Let's talk about " + userChosenSubject);
        System.out.println("Bot: Tell me something about it!");
        System.out.print(name + ": ");
        String userFactAboutTopic = in.nextLine();
        System.out.println("Bot: I really never knew " + userFactAboutTopic);
        System.out.println("Bot: Is " + userChosenSubject + " something you've been known about for a while?");
        System.out.print(name + ": ");
        String userHowLongForTopic = in.nextLine();
        System.out.println("Bot: You've been doing " + userChosenSubject + " for " + userHowLongForTopic);
        ArrayList<String> listOfTopicDetails = new ArrayList<String>();
        listOfTopicDetails.add(userChosenSubject);
        listOfTopicDetails.add(userFactAboutTopic);
        listOfTopicDetails.add(userHowLongForTopic);
        return listOfTopicDetails;
    }
    public static void fileRead() {

    }

    public static ArrayList<String> createReview(String name) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: I'm gonna ask some questions about how you thought I did today:");
        System.out.println("Bot: Please enter how well you think I was able to talk to you (Rated 1-100, Higher being better).");
        System.out.print(name + ": ");
        String rating = in.nextLine();
        System.out.println("Bot: You rated me " + rating + "/100");
        System.out.println("Please give me a verbal comment review.");
        System.out.print(name + ": ");
        String verbalComment = in.nextLine();
        System.out.println("Please give me potential improvements to the program");
        System.out.print(name + ": ");
        String improvementsComment = in.nextLine();
        list.add(name);
        list.add(rating);
        list.add(verbalComment);
        list.add(improvementsComment);
        return list;
    }

    public static void outputReview(String name) {
        ArrayList<String> list = createReview(name);
        try {
            FileWriter myWriter = new FileWriter("ChatBotLogs.txt");
            myWriter.write("User: " + name + "\n");
            myWriter.write("The rating for your bot is: " + list.get(1) + "/100" + "\n");
            myWriter.write("The comment about your bot is: " + list.get(2) + "\n");
            myWriter.write("The improvement for your bot is: " + list.get(3)+ "\n");
            myWriter.close();
            System.out.println("Bot: Your review is being processed.");
            System.out.println("Bot: 10% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 20% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 30% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 40% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 50% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 60% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 70% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 80% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: 90% Done...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: Completed!");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Bot: Your review has been submitted.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Bot: Program Closing...Goodbye " + list.get(0) + "!");
            System.exit(1);
          } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred while compiling your review.");
            e.printStackTrace();
          }
    }

    public static void main(String[] args) {
        String name = quickChat();
        //hobbiesChat(name);
        //moviesChat(name);
        //userPicksTopic(name);
        //outputReview(name);
        Records.createUserChosenSubject(name);
    }
    
}