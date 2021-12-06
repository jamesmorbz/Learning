package QMULMiniProject;

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

        // Stack ADT
    // Push(): adding an element in the stack.
    // Pop(): accessing or removing an element from the stack.
    // Peek(): return the topmost element of the stack without removing it.
    // IsFull(): check if stack is full.
    // IsEmpty(): check if stack is empty.
    // count(): counts the total number of elements in the stack.

    public static class Stack {
        private String arr[];
        private int top;
        private int capacity;
        Stack(int size) {
          arr = new String[size];
          capacity = size;
          top = -1;
        }
    
        public void push(String x) {
          if (isFull()) {
            System.out.println("OverFlow");
            System.exit(1);
        }
          arr[++top] = x;
        }
      
        public String pop() {
          if (isEmpty()) {
            System.exit(1);
          }
          return arr[top--];
        }
      
        public int size() {
          return top + 1;
        }
      
        public Boolean isEmpty() {
          return top == -1;
        }
      
        public Boolean isFull() {
          return top == capacity - 1;
        }
      
        public void DisplayStack() {
          for (int i = 0; i <= top; i++) {
            System.out.print(arr[i]);
          }
        }
      }
    
    public static void partyTrick(String name, int StackCap) {
        Stack stack = new Stack(100000);
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: You didn't really think I'd leave you like that did you?");
        System.out.println("Bot: Let me put on a show!");
        System.out.println("Bot: This is my party trick. I'm going to ask you to name playing cards and I'm going to remember them and then read them back to you. Magic!");
        System.out.println("Bot: How many items do you want to give me?");
        System.out.print(name + ": ");
        int NumberOfTricks = in.nextInt();
        in.nextLine();
        for (int i = 0; i < NumberOfTricks; i++) {
            System.out.println("Bot: Give me a card number!");
            System.out.print(name + ": ");
            String cardNum = in.nextLine();
            System.out.println("Bot: Give me a card suit! (Diamonds, Hearts, Clubs, Spades => D,H,C,S)");
            System.out.print(name + ": ");
            String cardSuit = in.nextLine();

            stack.push(cardNum);
            stack.push(cardSuit);
            System.out.println("Bot: I'm gonns commit this to my memory...");
            stack.DisplayStack(); 
        }

        System.out.println("Bot: This is what I remember: ");
        for (int i = 0; i <= stack.size()+2; i++) {
           String Suit = stack.pop();
           String Num = stack.pop();
           if (Suit.toLowerCase().contains("d")) {
               Suit = "Diamonds";
           } else if (Suit.toLowerCase().contains("h")) {
               Suit = "Hearts";
           } else if (Suit.toLowerCase().contains("c")) {
               Suit = "Clubs";
           } else if (Suit.toLowerCase().contains("s")) {
               Suit = "Spades";
           } else {
               System.out.println("You're messing around. I tried really hard to make this work. Goodbye.");
               System.exit(1);
           }
           
           System.out.println("Card " + ((int)i+1) + ": " + Num + " of " + Suit);
        }
    }

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
            ;
        } else if (response.toLowerCase().contains("no")) {
            System.out.println("Bot: Aww...You should try it out!");
            System.out.println("Bot: " + Fact + "!");
            ;
        } else {
            System.out.println("Bot: I didn't quite catch that. I'm silly sometimes! Do you like " + Interest + "? Try \"yes\" or \"no\"");
            ;
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
            System.out.println("Bot: I've never done " + alternativeActivity + " before, I must try it!");
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
                if (movieDescription.contains("Horror") || movieDescription.contains("Gore") || movieDescription.contains("Murder Mystery")) {
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
        System.out.println("Bot: You've been doing " + userChosenSubject + " for " + userHowLongForTopic + " that's really interesting");
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

    public static void sportSorting(String name) throws InterruptedException {
        String regex = "[^a-zA-Z]+";
        System.out.println("Bot: I'm glad you're here actually, I need something. Wait here.");
        String[] stringOfSports = fileRead();
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: I am hoping that you can help me human. I need to know which sport humans enjoy most. I struggle playing most sports myself.");
        System.out.println("Bot: I am going to list some sports. Can you rank them on a scale of 1-10?");
        System.out.print(name + ": ");
        String beingHelpful = in.nextLine();
        if (beingHelpful.toLowerCase().contains("yes")) {
            System.out.println("Bot: Thanks, I won't keep you for too long!");
        } else {
            System.out.println("Bot: You want to help me deep down, So before you run off here we go.");
        }
        System.out.println("Bot: Here are the sports: " + Arrays.toString(stringOfSports));
        System.out.println("Bot: Ready?");
        System.out.print(name + ": ");
        String readyornot = in.nextLine();
        if (readyornot.toLowerCase().contains("yes")) {
            System.out.println("Bot: Lets go! I'm gonna run through them 1 by 1");
        } else if (readyornot.toLowerCase().contains("no")) {
            System.out.println("Bot: I'm running out of time, We'll be quick! I'm gonna run through them 1 by 1");
        } else {
            System.out.println("Bot: Give it to me straight doc!");
        }
        Dictionary<String, Integer> Dictionary = new Hashtable<String, Integer>();
        for (int i = 0; i < stringOfSports.length; i++) {
            System.out.print("Bot: Rate " + stringOfSports[i] + " on a scale of 1-10");
            System.out.print(name + ": ");
            int ratingOfSport = in.nextInt();
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
                if (line.isEmpty()) {
                    TimeUnit.SECONDS.sleep(3);
                }
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
            myWriter.write("\n");
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
          } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred while compiling your review.");
            e.printStackTrace();
          }
    }

    public static int[] CreatingRandomIntsForSorting(String name) {
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: I don't just sort like that, I'm like Cat in the Hat. I have many tricks!");
        System.out.println("Bot: Tell me how many numbers you want me to generate and sort. Numbers have always been my strongpoint but I'm better at 0s and 1s :)");
        System.out.print(name + ": ");
        int NumberOfRandNums = in.nextInt();
        int[] RandNumsList = new int[NumberOfRandNums];
        for (int i=0; i < NumberOfRandNums; i++) {
        final int min = 1;
        final int max = 1000;
        int randomNum = (int) Math.floor(Math.random()*(max-min+1)+min);
        RandNumsList[i] = randomNum;
        }
        return RandNumsList;
    }

    public static void SortingInts(String name) {
        int[] RandNumsList = CreatingRandomIntsForSorting(name);
        System.out.println("Bot: Here is the list before sorting!");
        System.out.println(Arrays.toString(RandNumsList));
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < RandNumsList.length - 1; i++) {
                if (RandNumsList[i] > RandNumsList[i+1]) {
                    temp = RandNumsList[i];
                    RandNumsList[i] = RandNumsList[i+1];
                    RandNumsList[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Bot: Here is the list after I've sorted it!");
        System.out.println(Arrays.toString(RandNumsList));
    }

    public static void main(String[] args) throws InterruptedException {
        final String name = quickChat(); // stores the name of the user so that it can be used
        final int StackCap = 100000; // final variable
        hobbiesChat(name);
        moviesChat(name);
        createUserChosenSubject(name);
        sportSorting(name);
        SortingInts(name);
        loadCurrentReviews();
        outputReview(name);
        partyTrick(name, StackCap);
        
    }
    
}