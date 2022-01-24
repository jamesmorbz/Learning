package Learning.JHUB_Docs;

public record Records() {
    
    static class NobelWinner {
        String name;
        int year;
    
    }
    // Given a Nobel Prize winner record return the name stored in the record 
    //
    public static String getNobelWinnerName(NobelWinner nw) { 
        return nw.name;
    }

    // Given a Nobel Winner record return the year stored in the record 
    //
    public static int getNobelWinnerYear(NobelWinner nw)  { 
        return nw.year;
    }

    // Given a Nobel Winner record and a new name, store the name in the record 
    // Return the updated record value
    //
    public static NobelWinner setNobelWinnerName(NobelWinner nw, String nm) {
        nw.name = nm;
        
        return nw;
    }

    // Given a Nobel Winner record and a new year, store the year in the record 
    // Return the updated record value
    //
    public static NobelWinner setNobelWinnerYear(NobelWinner nw, int y) {
        nw.year = y;
        
        return nw;
    }


    // Set the name and award year for a Nobel prize winner
    //
    public static NobelWinner setNobelWinner(NobelWinner nw, String n, int y) {
        nw = setNobelWinnerName(nw, n);
        nw = setNobelWinnerYear(nw, y);
        return nw;
    }

    // Return a string suitsable for printing of the details of a nobel prize winner
    //
    public static String toStringNobelWinner(NobelWinner nw) {
        String s = getNobelWinnerName(nw) + ": " + getNobelWinnerYear(nw);
        return s;
    }


    // Print the stored details of some Nobel Prize winners for literature.
    //
    public static void nobel() {
        NobelWinner winner = new NobelWinner();

        winner = setNobelWinner(winner, "Svetlana Alexievich", 2015);
        System.out.println(toStringNobelWinner(winner));

        winner = setNobelWinner(winner, "Bob Dylan", 2016);
        System.out.println(toStringNobelWinner(winner));
            
        winner = setNobelWinner(winner, "Kazuo Ishiguro", 2017);
        System.out.println(toStringNobelWinner(winner));

        winner = setNobelWinner(winner, "Olga Tokarczuk", 2018);
        System.out.println(toStringNobelWinner(winner));

        return;
    }

public static void main(String[] args) {
    nobel();
}
    
}