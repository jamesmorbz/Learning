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
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChatBot3 {

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
        System.out.println("");
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
        System.out.println("");
        System.out.print(name +": ");
        String response = in.nextLine();
        System.out.println("");
        if (response.toLowerCase().contains("yes")) {
            System.out.println("Bot: Me too!");
            System.out.println("Bot: " + Fact + "!");
            System.out.println("");
        } else if (response.toLowerCase().contains("no")) {
            System.out.println("Bot: Aww...You should try it out!");
            System.out.println("Bot: " + Fact + "!");
            System.out.println("");
        } else {
            System.out.println("Bot: I didn't quite catch that. I'm silly sometimes! Do you like " + Interest + "? Try \"yes\" or \"no\"");
            System.out.println("");
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
        System.out.println("");
        System.out.print(name + ": ");
        String stringNumberOfMovies = in.nextLine();
        System.out.println("");
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
            System.out.println("");
            moviesChat(name);
        } else if (value == 0) {
            System.out.println("Bot: You didn't watch any movies?? I love watching movies!");
            System.out.println("Bot: What did you do instead?");
            System.out.println("");
            System.out.print(name + ": ");
            String alternativeActivity = in.nextLine();
            System.out.println("");
            System.out.println("Bot: I've never done " + alternativeActivity + " before, I must try it!");
            System.out.println("");
        } else {
        System.out.println("Bot: You watched " + value + " movies! That's awesome! I'm really interested to find out more about the movies you watched!");
        for (int i = 0; i<value; i++) {
            int min = 1;
            int max = 2;
            int randomNum = (int) Math.floor(Math.random()*(max-min+1)+min);
            System.out.println("Bot: Name one of the movies!");
            System.out.println("");
            System.out.print(name +": ");
            String movieName = in.nextLine();
            System.out.println("");
            if (randomNum == 1) {
                System.out.println("Bot: " + movieName + " sounds like an really good movie");
            } else {
                System.out.println("Bot: " + movieName + " doesn't sound very interesting");
                System.out.println("Bot: What genre is " + movieName );
                System.out.println("");
                System.out.print(name + ": ");
                String movieDescription = in.nextLine();
                System.out.println("");
                if (movieDescription.contains("Horror") || movieDescription.contains("Gore") || movieDescription.contains("Murder Mystery")) {
                    System.out.println("Bot: Did you enjoy it?!");
                    System.out.print(name + ": ");
                    String horrorEnjoy = in.nextLine();
                    System.out.println("");
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
        ArrayList<String> details = userPicksTopic(name);
        userChosenSubjectDetails subjectDetails = new userChosenSubjectDetails();

        subjectDetails = setUserChosenSubjectDetails(subjectDetails, details.get(0), details.get(1), details.get(2));
        System.out.println("Bot: Your last 3 answers were: " + toStringSubjectDetails(subjectDetails) + " They have puzzled me, I must move on.");
        return;
    }

    public static ArrayList<String> userPicksTopic(String name) {
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: I don't want to bore you with movie chatter. What would you like to talk about?");
        System.out.println("");
        System.out.print(name + ": ");
        String userChosenSubject = in.nextLine();
        System.out.println("");
        System.out.println("Bot: Ok! Let's talk about " + userChosenSubject);
        System.out.println("Bot: Tell me something about it!");
        System.out.println("");
        System.out.print(name + ": ");
        String userFactAboutTopic = in.nextLine();
        System.out.println("");
        System.out.println("Bot: I really never knew " + userFactAboutTopic);
        System.out.println("Bot: Is " + userChosenSubject + " something you've been known about for a while?");
        System.out.print(name + ": ");
        String userHowLongForTopic = in.nextLine();
        System.out.println("");
        System.out.println("Bot: You've been doing " + userChosenSubject + " for " + userHowLongForTopic + " that's really interesting");
        System.out.println("");
        ArrayList<String> listOfTopicDetails = new ArrayList<String>();
        listOfTopicDetails.add(userChosenSubject);
        listOfTopicDetails.add(userFactAboutTopic);
        listOfTopicDetails.add(userHowLongForTopic);
        return listOfTopicDetails;
    }
    
    public static String[] fileRead() throws InterruptedException {
        System.out.println("Loading Data...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Success: Data Loaded!");
        try {
            File inputData = new File("SportForSorting.txt");
            Scanner myReader = new Scanner(inputData);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] InputDataSeperated = data.split(",");
              return InputDataSeperated;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return fileRead();
    }
        return null;
}

    public static ArrayList<String> createReview(String name) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Bot: I'm gonna ask some questions about how you thought I did today:");
        System.out.println("Bot: Please enter how well you think I was able to talk to you (Rated 1-100, Higher being better).");
        System.out.println("");
        System.out.print(name + ": ");
        String rating = in.nextLine();
        System.out.println("");
        System.out.println("Bot: You rated me " + rating + "/100");
        System.out.println("Please give me a verbal comment review.");
        System.out.println("");
        System.out.print(name + ": ");
        String verbalComment = in.nextLine();
        System.out.println("");
        System.out.println("Please give me potential improvements to the program");
        System.out.println("");
        System.out.print(name + ": ");
        String improvementsComment = in.nextLine();
        System.out.println("");
        list.add(name);
        list.add(rating);
        list.add(verbalComment);
        list.add(improvementsComment);
        return list;
    }

    public static void sportSorting(String name) throws InterruptedException {
        System.out.println("Bot: I'm glad you're here actually, I need something. Wait here.");
        String[] stringOfSports = fileRead();
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: I am hoping that you can help me human. I need to know which sport humans enjoy most. I struggle playing most sports myself.");
        System.out.println("Bot: I am going to list some sports. Can you rank them on a scale of 1-10?");
        System.out.println("");
        System.out.print(name + ": ");
        System.out.println("");
        String beingHelpful = in.nextLine();
        System.out.println("");
        if (beingHelpful.toLowerCase().contains("yes")) {
            System.out.println("Bot: Thanks, I won't keep you for too long!");
        } else {
            System.out.println("Bot: You want to help me deep down, So before you run off here we go.");
        }
        System.out.println("Bot: Here are the sports: " + Arrays.toString(stringOfSports));
        System.out.println("Bot: Ready?");
        System.out.println("");
        System.out.print(name + ": ");
        String readyornot = in.nextLine();
        System.out.println("");
        if (readyornot.toLowerCase().contains("yes")) {
            System.out.println("Bot: Lets go! I'm gonna run through them 1 by 1");
        } else if (readyornot.toLowerCase().contains("no")) {
            System.out.println("Bot: I'm running out of time, We'll be quick! I'm gonna run through them 1 by 1");
        } else {
            System.out.println("Bot: Give it to me straight doc!");
        }
        Dictionary<String, Integer> Dictionary = new Hashtable<String, Integer>();
        for (int i = 0; i < stringOfSports.length; i++) {
            System.out.println("Bot: Rate " + stringOfSports[i] + " on a scale of 1-10");
            System.out.println("");
            System.out.print(name + ": ");
            int ratingOfSport = in.nextInt();
            System.out.println("");
            Dictionary.put(stringOfSports[i], ratingOfSport);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(((Hashtable<String, Integer>) Dictionary).entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
            return entry1.getValue().compareTo( entry2.getValue() );
            }
        } );
 
        Map<String, Integer> mapSortedByValues = new LinkedHashMap<String, Integer>();
        for( Map.Entry<String, Integer> entry : list ) { 
            mapSortedByValues.put(entry.getKey(), entry.getValue());
        }
        String sortedMap = mapSortedByValues.toString();
        String regex = "[^a-zA-Z]+";
        sortedMap = sortedMap.replaceAll(regex, ",");
        System.out.println("Bot: I've taken what you've said into consideration and sorted a list for you!");
        System.out.println("Bot: It's ordered Least to Most Favourite: " + sortedMap);
    }  
    
    public static void loadCurrentReviews() throws InterruptedException {
        System.out.println("Bot: Before you go I'd like to show you current reviews for me. I'm always looking to better myself as a bot!");
        System.out.println("Bot: Then you will have a chance to submit your review!");
        System.out.println("Loading Data...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Success: Data Loaded!");
        try {
            File inputData = new File("ChatBotReviews.txt");
            Scanner myReader = new Scanner(inputData);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
                //if (line == "") {
                //    TimeUnit.SECONDS.sleep(2);
                //   System.out.flush();
                //}
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }
}

    public static void outputReview(String name) {
        ArrayList<String> list = createReview(name);
        try {
            FileWriter myWriter = new FileWriter("ChatBotReviews.txt", true);
            myWriter.write("\n");
            myWriter.write("User: " + name + "\n");
            myWriter.write("Bot Rating is: " + list.get(1) + "/100" + "\n");
            myWriter.write("Comment about Bot: " + list.get(2) + "\n");
            myWriter.write("Possible Bot Improvements: " + list.get(3));
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
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: Your review has been submitted.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bot: Program Closing...Goodbye " + list.get(0) + "!");
            System.exit(1);
          } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred while compiling your review.");
            e.printStackTrace();
          }
    }

    public static void main(String[] args) throws InterruptedException {
        String name = quickChat();
        hobbiesChat(name);
        moviesChat(name);
        createUserChosenSubject(name);
        sportSorting(name);
        loadCurrentReviews();
        outputReview(name);
        
    }
    
}