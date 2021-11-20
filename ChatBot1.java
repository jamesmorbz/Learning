/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Program: ChatBotv1
  Stage of Prod: Level 1
  
*************************************** */

import java.util.*;

public class ChatBot1 {
    public static void QuickChat() {
        Scanner in = new Scanner(System.in);
        System.out.println("Bot: Hi!");
        System.out.print("<Unknown User>: ");
        String firstUserInput = in.nextLine();
    }
    public static void GTG() {
        System.out.println("It's nice to meet you! I need to run though!");
    }
    public static void main(String[] args) {
        QuickChat();
        GTG();
    }
    
}
