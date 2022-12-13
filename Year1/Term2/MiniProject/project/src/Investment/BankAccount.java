package Investment;

import java.io.Serializable;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	private double balance;
	double min_balance;
	String investment_id;

	public BankAccount(String name, double balance, double min_balance) {
		this.name = name;
		this.balance = balance;
		this.min_balance = min_balance;
		investment_id = 10000 + (int) (Math.random() * 89999) + "";
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws MaxWithdraw, MaxBalance {
		if ((balance - amount) >= min_balance && amount < balance) {
			balance -= amount;

		}

		else {
			throw new MaxBalance("Insufficient Balance");
		}
	}

	public double getbalance() {
		return balance;
	}

	@Override
	public String toString() {
		String classType = this.getClass().toString();
		int classTypeLen = classType.split(".").length;
		if (classTypeLen > 0) {
		classType = classType.split(".")[classTypeLen - 1]; 
		return "Name: " + name + ", Id: " + investment_id + ", Balance: " + balance + "Type:" + classType;
		} else {
			return "Name: " + name + ", Id: " + investment_id + ", Balance: " + balance + "Type:" + this.getClass();
		}
	}
}
