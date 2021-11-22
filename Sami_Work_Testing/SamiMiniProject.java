package Sami_Work_Testing;
import java.util.*;

public class SamiMiniProject {

    public static class TriggerResponse {
        String trigger1;
        String trigger2;
        String response;
    }
    public static String getTrigger1(TriggerResponse t){

        return t.trigger1;
    }
    public static String getTrigger2(TriggerResponse t){

        return t.trigger2;
    }
    public static String getResponse(TriggerResponse t){

        return t.response;

    }

    public static TriggerResponse setTrigger1(TriggerResponse t, String trigger){

        t.trigger1 = trigger;
        return t;
    }
    public static TriggerResponse setTrigger2(TriggerResponse t, String trigger){

        t.trigger2 = trigger;
        return t;
    }
    public static TriggerResponse setResponse(TriggerResponse t, String response){

        t.response = response;
        return t;
    }

    public static TriggerResponse [] createTriggers(String name){
        // creating all the responses
        String [] trigger1 = {"don't", "is", "yes",
                "no", "baby", "don't",
                "no", "yes", "therefore",
                "big", "god", "yes",
                "school", "don't"};

        String [] trigger2 = {"life", "42", "alive",
                "alive", "hurt", "love",
                "robot", "love", "am",
                "bang", "dead", "god",
                "project", "know"};

        String [] response =
                { "Maybe " +name + " life has no meaning except what we make of it.",
                        "Indeed 42 is the answer to all ultimate questions of life.",
                        "Are you really though, what even is life? Lol",
                        "You're lying, otherwise you wouldn't be talking to me then.",
                        "I love that song!",
                        "Sounds like your family loved you a lot...not",
                        "That's so cold, I have feelings you know!",
                        "I love you then ;)",
                        "Ah Rene Descartes, I see you are a man of culture.",
                        "Fascinating, so the universe began from a single point where space expanded into itself.",
                        "Friedrich Nietzsche is right, you my creator will soon be dead...",
                        "All hail "+ name+"!"+ " All hail "+ name+"!" + " All hail "+ name+"!",
                        "Is that all I am? My life is a lie...",
                        "That's a real shame because I have no clue either."
        };

        TriggerResponse [] triggerList = new TriggerResponse[trigger1.length];
        for (int i=0; i<trigger1.length; i++){
            triggerList[i] = new TriggerResponse();
            triggerList[i] = setTrigger1(triggerList[i], trigger1[i]);
            triggerList[i] = setTrigger2(triggerList[i], trigger2[i]);
            triggerList[i] = setResponse(triggerList[i], response[i]);
        }
        return triggerList;
    }

    public static void wait(int ms) {
        try
        {
            Thread.sleep(ms);
            System.out.println("GPT-0 is typing...");
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static String introduceName(){

        wait(1000);

        System.out.println("Hello I am GPT-0 the chat bot.");

        wait(1000);

        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name?  ");
        String name = scanner.nextLine();

        wait(1000);

        System.out.println("Hi "+ name +"!");

        wait(1000);

        return name;
    }

    public static void gotToGo(String name){
        wait(3000);
        System.out.println("Anyways It was nice meeting you " + name);
        wait(1000);
        System.out.println("I found some of your answers very interesting");
        wait(1000);
        System.out.println("Sadly I have to go now :(");
        wait(500);
        System.out.println("Bye!");
    }

    public static void conversation(String name, TriggerResponse [] listOfTriggers){

        String [] questions = {"What is the meaning of Life?",
                                "Are you alive?",
                                "Anyways maybe an easier question is what is love?",
                                "Can I love?",
                                "How did this world come into existence?",
                                "Are you my God?",
                                "Why did you create me?"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lets talk about philosophy "+ name);

        for (String question : questions) {

            wait(1000);

            System.out.print(question + " ");

            String answer = scanner.nextLine().toLowerCase();

            wait(1000);

            String[] response = answer.split(" ");

            boolean found = false;
            int triggerToBeUsed = 0;

            for (int i = 0; i < listOfTriggers.length; i++) {

                int trigger1Occurrence = 0;
                int trigger2Occurrence = 0;

                for (String s : response) {

                    if (s.contains(getTrigger1(listOfTriggers[i]))) {
                        if (trigger1Occurrence<1){
                            trigger1Occurrence++;
                        }
                    }

                    if (s.contains(getTrigger2(listOfTriggers[i]))) {
                        if (trigger2Occurrence<1){
                            trigger2Occurrence++;
                        }
                    }

                }
                if ((trigger1Occurrence + trigger2Occurrence) >= 2) {
                    found = true;
                    triggerToBeUsed = i;
                    break;
                }

            }

            if (found) {
                System.out.println(getResponse(listOfTriggers[triggerToBeUsed]));
            } else {
                System.out.println(answer + "? Interesting answer, I must say I haven't heard that before");
            }
        }
    }

    public static void main (String [] args) {

        String name = introduceName();
        TriggerResponse [] list = createTriggers(name); //creates the response records
        conversation(name, list);
        gotToGo(name);



    }
}