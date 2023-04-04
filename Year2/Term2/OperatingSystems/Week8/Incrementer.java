public class Incrementer extends Thread implements Runnable{

    private int numIncrements;
    private String name;
    private Counter counter;

    public Incrementer(int numIncrements, int index, Counter counter) {
        this.name = "Thread " + index;
        this.numIncrements = numIncrements;
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < numIncrements; i++) {
        	counter.increase(name);
        	try {
		Thread.sleep(10);
		}
		catch (Exception e) {
			System.out.print(e);
		}
        }
    }
}
