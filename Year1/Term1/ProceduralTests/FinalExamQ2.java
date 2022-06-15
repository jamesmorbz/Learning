package Learning.FinalExam;

import java.util.*;

public class Question2 {

    static class Voter {
        String name;
        int votes;
    }

    public static Voter createVoter(String name) {
        Voter nw = new Voter();
        nw.name = name;
        nw.votes = 0;
        return nw;
    }

    public static String getVoterName(Voter nw) {
        return nw.name;
    }

    public static int getNumVotes(Voter nw) {
        return nw.votes;
    }

    public static void incrementVotes(Voter nw) {
        nw.votes = nw.votes + 1;
    }

    public static String[] getParticipants(int numberOfParticipants) {
        Scanner in = new Scanner(System.in);
        int j = 0;
        String[] participants = new String[10];
        for (int i = 1; i <= numberOfParticipants; i++) {
            System.out.printf("Name %d? ", i);
            String name = in.nextLine();
            participants[i - 1] = name;
            createVoter(name);
        }
        System.out.print("Voting: ");
        while (j < numberOfParticipants) {
            System.out.printf("%d=%s ", j + 1, participants[j]);
            j++;
        }
        System.out.println();
        return participants;
    }

    public static int[] voteCounter(String[] participants) {
        Scanner in = new Scanner(System.in);
        int[] VotesCounted = new int[10];
        for (int i = 0; i < participants.length; i++) {
            System.out.printf("%s who do you vote for? ", participants[i]);
            int VotedFor = in.nextInt();
            if ((VotedFor < 1) || (VotedFor > 10)) {
                System.out.println("Invalid Voting Number");
                i--;
            } else {
                VotesCounted[i] = VotedFor;
            }
        }
        return VotesCounted;
    }

    public static int findMostPopular(int[] votes) {
        Arrays.sort(votes);

        int previous = votes[0];
        int popular = votes[0];
        int currentCount = 1;
        int highestCount = 1;

        for (int i = 1; i < votes.length; i++) {
            if (votes[i] == previous)
                currentCount++;
            else {
                if (currentCount > highestCount) {
                    popular = votes[i - 1];
                    highestCount = currentCount;
                }
                previous = votes[i];
                currentCount = 1;
            }
        }

        return currentCount > highestCount ? votes[votes.length - 1] : popular;

    }

    public static void main(String[] args) {
        final int numberOfParticipants = 10;
        String[] participants = getParticipants(numberOfParticipants);
        int[] votes = voteCounter(participants);
        int mostPopular = findMostPopular(votes);
        System.out.printf("Winner(s): %s", participants[mostPopular-1]);
    }
}