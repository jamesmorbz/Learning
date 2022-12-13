package Investment;

import java.io.Serializable;
import javax.swing.DefaultListModel;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class Investment implements Serializable {

	private static final long serialVersionUID = 1L;
	private BankAccount[] investments = new BankAccount[100];

	public int addInvestment(BankAccount investment) {
		int i = 0;
		for (i = 0; i < 100; i++) {
			if (getInvestments()[i] == null) {
				break;
			}
		}
		getInvestments()[i] = investment;
		return i;
	}

	public int addInvestment(String currency, double value, double interest) {
		Cash investment = new Cash(currency, value, interest);
		return this.addInvestment(investment);
	}

	public int addInvestment(String stockName, int quantity, double value) throws Exception {
		Stock investment = new Stock(stockName, quantity, value);
		return this.addInvestment(investment);
	}

	public int addInvestment(String material, double currentValue, int quantity) {
		Commodity investment = new Commodity(material, currentValue, quantity);
		return this.addInvestment(investment);
	}

	public BankAccount findAccount(String accountNum) {
		int i;
		for (i = 0; i < 100; i++) {
			if (getInvestments()[i] == null) {
				break;
			}
			if (getInvestments()[i].investment_id.equals(accountNum)) {
				return getInvestments()[i];
			}

		}
		return null;
	}

	public void deposit(String accountNum, double amount) throws InvalidAmount, AccNotFound

	{
		if (amount < 0) {
			throw new InvalidAmount("Invalid Deposit amount");
		}
		BankAccount temp = findAccount(accountNum);
		if (temp == null) {
			throw new AccNotFound("Account Not Found");
		}
		if (temp != null) {
			temp.deposit(amount);

		}

	}

	public void withdraw(String accountNum, double amount) throws MaxBalance, AccNotFound, MaxWithdraw, InvalidAmount {
		BankAccount temp = findAccount(accountNum);

		if (temp == null) {
			throw new AccNotFound("Account Not Found");
		}

		if (amount <= 0) {
			throw new InvalidAmount("Invalid Amount");
		}

		if (amount > temp.getbalance()) {
			throw new MaxBalance("Insufficient Balance");
		}
		if (temp != null) {
			temp.withdraw(amount);
		}
	}

	public DefaultListModel<String> display() {
		DefaultListModel<String> list = new DefaultListModel<String>();
		int i;

		for (i = 0; i < 100; i++) {
			if (getInvestments()[i] == null) {
				break;
			}

			list.addElement(getInvestments()[i].toString());

		}

		return list;
	}

	public BankAccount[] getInvestments() {
		return investments;
	}

	public void setAccounts(BankAccount[] investments) {
		this.investments = investments;
	}

}
