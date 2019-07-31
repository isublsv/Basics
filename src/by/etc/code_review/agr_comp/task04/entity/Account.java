package by.etc.code_review.agr_comp.task04.entity;

public class Account {

	private long id;
	private Type type;
	private double balance;

	private boolean isBlocked = false;

	public Account(long id, Type type, double balance) {
		this.id = id;
		this.type = type;
		if (balance <= 0){
			isBlocked = true;
		}
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean blocked) {
		isBlocked = blocked;
	}

	@Override
	public String toString() {
		return String.format("id: %d\t type: %8s\t balance: %.2f\t is blocked: %b\t", id, type, balance, isBlocked);
	}
}
