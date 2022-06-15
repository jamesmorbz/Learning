public class Agent extends User {

    private static final int MAX_CLIENTS = 5;
    private int numClients;
    private Client[] listOfClients;

    public Agent(String name) {
        super(name);
        this.numClients = 0;
        this.listOfClients = new Client[MAX_CLIENTS];
    }

    public boolean addClient(String string) {
        if (this.numClients < MAX_CLIENTS) {
            this.listOfClients[this.numClients] = string;
            this.numClients = this.numClients + 1;
        } else {
            System.out.println("Too Many Clients Added.");
        }
    }

    public Object[] getClients() {
        return this.listOfClients;
    }

}
