public class Counter {
    public int counter = 0;

    public Counter() {
        counter++;
    }
    public static void main(String[] args) {
        new Counter();
        new Counter();
        Counter c = new Counter();
        System.out.println(c.counter);
    }
}
