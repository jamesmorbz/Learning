public class Main{
    /**
     * This program should create a number of Incrementer threads
     * at the same time.  All Incrementer threads should be modifying the same
     * shared Counter object. Because they are all running at the
     * same time, we should see some thread interference (race conditions) 
     * as they try to modify the same Counter.
     **/
    public static void main(String args[]) throws InterruptedException {
        int numAdds = 1000;
        int numThreads = Integer.parseInt(args[0]);
        Counter counter = new Counter();
        int achievedCounter = numAdds*numThreads;
        
        while(numThreads>0) {
        	Incrementer incrementer = new Incrementer(numAdds, numThreads, counter);
        	Thread thread = new Thread(incrementer);
        	thread.start();
        	numThreads--;
      }
      Thread.sleep(15000);
      
	if(counter.getCount()!=achievedCounter) {
		System.out.println(counter.getCount());
		System.out.println("Race conditions observed");
	}
    }
}

