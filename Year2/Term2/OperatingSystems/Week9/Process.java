import java.util.Random;

public class Process implements Runnable {

    private Barrier barrier;
    private String name;
    private int sleepTime;
    public int id;

    public Process(Barrier b, int n, int s) {
        barrier = b;
        name = "Thread " + n;
        sleepTime = s;
    }
     

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
            System.out.println(name + " should be joining the barrier from here!!!");
            barrier.joinBarrier(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}