package Investment;

public class Stock extends BankAccount {

	private static final long serialVersionUID = 1L;

	public Stock(String stockName, int quantity, double value) throws Exception {
		super(stockName, quantity, value);
	}
}