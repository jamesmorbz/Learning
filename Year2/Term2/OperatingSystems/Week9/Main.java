import java.util.Random;

public class Main {

    private static int threadCount = 10 ;
    private static final int barrierSize = 5 ;
    private static final int sleepTime = 500 ;

    public static void main(String[] args) {
        // Read the number of threads from the command line argument
        if (args.length > 0) {
            threadCount = Integer.parseInt(args[0]);
        }
    
        // Print out the number of threads
        System.out.println("Number of threads = " + threadCount);
    
        // Create the barrier
        Barrier barrier = new Barrier(barrierSize);
    
        // Create and start the process threads
        // There are threadCount threads
        Random r = new Random();
        for (int i = 1; i <= threadCount; i++) {
            Process p = new Process(barrier, i, r.nextInt(sleepTime));
            new Thread(p).start();
        }
    }
}