public class PremiumClient extends Client {

    private static final double BONUS_RATE = 0.001;
    private double bonus;

    public PremiumClient(String name) {
        super(name);
        this.bonus = 0;
    }

    public double getEarnedBonus() {
        return this.bonus;
    }

    public void deposit(int amount) {
        this.account.deposit(amount);
        this.bonus = bonus + amount * BONUS_RATE;
    }
    
}
