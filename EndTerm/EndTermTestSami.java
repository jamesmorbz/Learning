package EndTerm;
import java.util.Random;
import java.util.Scanner;

public class EndTermTestSami {

    // generates random number
    public	static	int	randomInt(int	bound)	{
        Random r	=	new	Random();
        return	r.nextInt(bound)+1; // random number between 1-10
    }

    // standard input messages
    public static String inputString(String message)
    {
        Scanner keyboard = new Scanner(System.in);
        String textinput;

        System.out.println(message);
        textinput = keyboard.nextLine();

        return textinput;
    }
    public static int inputInt(String message)
    {
        String answer = inputString(message);

        return Integer.parseInt(answer);
    }

    public static String inputCorrectInt(String message)
    {
        String  answer = inputString(message);
        while (!(answer.matches("\\d+")) && Integer.parseInt(answer) > 40){
            System.out.println("Invalid value entered enter a number between 1-40");
            answer = inputString(message);
        }
        return answer;
    }

    // ADT for single card record
    // Operations:
    // - create a card
    // - get the card number
    // - get the card Type
    // Records cannot be changed once set
    //************************************************************************************
    public static class Card{

        int number;
        String type;
    }
    public static Card createCard(int number, String type){
        Card c = new Card();
        c.number = number;
        c.type = type;
        return c;
    }
    public static int getCardNumber(Card c){
        return c.number;
    }
    public static String getCardType(Card c){
        return c.type;
    }
    public static String createType(int randomType){

        String [] Type = {"Clubs", "Diamonds", "Hearts", "Spades"};
        return Type[randomType];


    }
    public static Card [] createDeck(Card[] cards, int MaxRandomValue){

        for(int i=0; i<cards.length; i++){

            cards[i] = createCard(randomInt(MaxRandomValue), createType(randomInt(3)));
        }
        return cards;
    }

    public static void playGame(Card [] cards){

        int targetScore = Integer.parseInt(inputCorrectInt("Target score?"));
        int score = 0;
        boolean guessCorrect = true;
        int i = 0;

        int firstCard = getCardNumber(cards[i]);
        System.out.println("I drew a "+firstCard);
        String value = inputString("Round "+(i+1)+ "Higher or lower (h/l");
        int nextCard = getCardNumber(cards[i]);
        System.out.println("I drew a "+nextCard);

        if ((value.equals("l") & firstCard<nextCard) | (value.equals("h") & firstCard>nextCard)){
            System.out.println("Nice try you scored "+ score);
            guessCorrect = false;
        }
        else{
            i=i+1;
        }


        while (score != targetScore && guessCorrect && i<cards.length) {

            value = inputString("Round "+(i+1)+ "Higher or lower (h/l");
            int firstNextCard = getCardNumber(cards[i-1]);
            int NewNextCard = getCardNumber(cards[i]);
            System.out.println("I drew a "+NewNextCard);
            if ((value.equals("l") & firstCard<nextCard) | (value.equals("h") & firstCard>nextCard)){
                System.out.println("Nice try you scored "+ score);
                guessCorrect = false;
            }
            else{
                score = score+1;
                i = i+1;
            }

        }
        if (guessCorrect){
            System.out.println("You win!");

        }
    }

    public static void main(String[] args){

        final int MaxRandomValue = 10;
        final int MaxNumOfCards = 40;
        Card [] cards = new Card[MaxNumOfCards];
        cards = createDeck(cards, MaxRandomValue);
        playGame(cards);
    }

}
