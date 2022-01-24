package Learning.FinalExam;

import java.util.*;

public class vote {

    public static void main(String[] args){

        final int numOfPeople = 10;
        VoterDatabase v = createVoterDatabase(numOfPeople);
        askForVotes(v, numOfPeople);
        gotMostVotes(v, numOfPeople); // prints out voters with most votes


    }

    // method adds voters into our database and increments the voting field based on user input
    public static void askForVotes(VoterDatabase v, int numOfPeople){

        for(int i=0; i<numOfPeople; i++){ // asking user for names
            String name = inputString("Name "+ (i+1) + "? ");
            addVoterToDatabase(v, name);
        }

        System.out.print("Voting: "); // printing out who to vote for
        for (int i=0; i<numOfPeople; i++){
            System.out.print((i+1)+"="+GetVoterName(v,i) + " ");
        }
        System.out.println();
        for (int i=0; i<numOfPeople; i++){ // voters voting
            int index = intInput(GetVoterName(v,i) + " who do you vote for? ", numOfPeople);
            incrementDatabaseVotes(v, index-1); // increments votes field of voter stored at userinput -1
            // since embedded array is indexed at 0 we minus 1
        }

    }

    // method looks through our database and returns a list of people with the most votes and prints this out
    public static void gotMostVotes(VoterDatabase d, int numOfPeople){

        int mostVotes = 0;
        ArrayList<String> winners = new ArrayList<String>();
        for (int i = 0; i<numOfPeople; i++){ // finds the value of the most votes
            Voter v = d.voters[i];
            if (getVotes(v) > mostVotes){
                mostVotes = getVotes(v);
            }
        }
        for (int i =0; i<numOfPeople; i++){ // adds voters with the same number of votes as the most votes to a list
            Voter v = d.voters[i];
            if (getVotes(v) == mostVotes){
                winners.add(getName(v));
            }
        }

        System.out.print("Winner(s): ");
        for (int i=0; i<winners.size();i++){ // printing out the winners stored in our list
            System.out.print(winners.get(i)+" ");
        }
    }


    /* *****************
       Create a new record type called Voter that records voter data
       A voter has a name and votes.
    */
    public static class Voter {
    String name; // The voters name
    int votes; // The voters number of votes
}

    /* *****************
     ** Methods defining a Voter ADT
     ** Theses are the only ways we should access a voter
     ** Create a voter record
     ** Get a voter name
     ** Get a voter number of votes
     ** Increment the number of votes by 1
     **/

    public static Voter createVoter (String name) {
        Voter v = new Voter();
        v.name = name;
        v.votes = 0;
        return v;
    }
    public static String getName (Voter v)
    {
        return v.name;
    }
    public static int getVotes (Voter v)
    {
        return v.votes;
    }
    public static void incrementVotes(Voter v){
        v.votes = v.votes + 1;
    }

    /* *****************
       Create a new record type called VoterDatabase that records voter data
       A database is an array and the next free index in the array
    */
    public static class VoterDatabase {
        Voter[] voters; // The database data
        int nextIndex; // keeps track of next free index
    }

    /* *****************
     ** Methods defining a Voter Database ADT
     ** These are the only ways we should access a Voter Database
     ** Create a new empty Database
     ** Add a new voter record
     ** Increment the votes of a voter based on index
     ** Get voters name based on index
     ** return list votes with the most votes
     **/

    public static VoterDatabase createVoterDatabase (int SIZE) {
        VoterDatabase d = new VoterDatabase();
        Voter[] a  = new Voter[SIZE];
        d.voters = a;
        d.nextIndex = 0;
        return d;
    }

    public static void addVoterToDatabase (VoterDatabase d, String name) {

        int index = d.nextIndex;
        Voter v = createVoter(name);

        Voter [] voters =  d.voters;

        voters[index] = v;
        d.nextIndex = d.nextIndex + 1;

        return;

    }

    public static void incrementDatabaseVotes(VoterDatabase d, int index ) {

        Voter v = d.voters[index];
        incrementVotes(v);
        return;
    }

    public static String GetVoterName(VoterDatabase d, int index ) {

        Voter v = d.voters[index];
        return getName(v);

    }


    // input validation
    public static String inputString(String message){ // standard string input

        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();

    }

    public static int intInput(String message, int numOfPeople){ // int input making sure <=10 and >0
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int number = Integer.parseInt(scanner.nextLine());
        if (number>numOfPeople || number<1){
            System.out.println("vote invalid, enter a number between 1 and 10");
            return intInput(message, numOfPeople);
        }
        else{
            return number;
        }

    }

}