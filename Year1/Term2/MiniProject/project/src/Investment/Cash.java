package Investment;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class Cash extends BankAccount {

	private static final long serialVersionUID = 1L;
	int maxWithLimit;
	double rate = 0.05;
	
	public Cash(String currency, double value, double interest) {
		super(currency, value, interest);
		this.maxWithLimit = 0;
	}

	public double getNetBalance() {
		double NetBalance = getbalance() + (getbalance() * rate);
		return NetBalance;
	}

	public void withdraw(double amount) throws MaxWithdraw, MaxBalance {
		if (amount < maxWithLimit) {
			super.withdraw(amount);

		} else {
			throw new MaxWithdraw("Maximum Withdraw Limit Exceed");
		}

	}

}
