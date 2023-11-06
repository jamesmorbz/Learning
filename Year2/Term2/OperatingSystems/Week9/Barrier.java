import javax.lang.model.SourceVersion;

public class Barrier {
    private int barrierSize;
    private int waitingThreads;
    private int currentId = 0;
    private int nextIdRun = 0;

    public Barrier(int barrierSize) {
        this.barrierSize = barrierSize;
        this.waitingThreads = 0;
        System.out.println("Barrier size = " + barrierSize);
    }

    public synchronized void joinBarrier(Process p) throws InterruptedException {
        long randSleepTime = (long)(Math.random() * 1000);
        Thread.sleep(randSleepTime);
        p.id = currentId;
        currentId++;
        System.out.println(currentId);
        waitingThreads++;
        while (waitingThreads <= barrierSize) {
            wait();
        }

        notifyAll();

        while (p.id > nextIdRun) {
            wait();
        }
        
        nextIdRun++;
        notifyAll();

        System.out.println(p.getName() + " passed the barrier");
    }

}

