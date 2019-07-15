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

	public double getBalance() {
		return balance;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean blocked) {
		isBlocked = blocked;
	}

	public void deposit(double deposit) {
		if (deposit < 0) {
			System.out.println("You cannot deposit negative amount of money!");

		} else {
			balance += deposit;
			if (balance > 0) {
				isBlocked = false;
				System.out.println("Your account " + type + " was unblocked!");
			} else {
				isBlocked = true;
			}
		}
	}

	public void withdraw(double withdraw) {
		if (withdraw < 0) {
			System.out.println("You cannot withdraw negative amount of money!");

		} else if (!isBlocked) {
			if (balance < withdraw) {
				System.out.println("The withdraw number is higher than balance amount!");
			} else {
				balance -= withdraw;
			}
		} else {
			System.out.println("The account " + type + " is blocked!");
		}
	}

	@Override
	public String toString() {
		return String.format("id: %d\t type: %8s\t balance: %.2f\t is blocked: %b\t", id, type, balance, isBlocked);
	}
}
