package by.etc.code_review.agr_comp.task04.utils;

import by.etc.code_review.agr_comp.task04.entity.Account;

public class AccountUtils {

	private Account account;

	public AccountUtils(Account account) {
		this.account = account;
	}

	public void deposit(double deposit) {
		if (deposit < 0) {
			System.out.println("You cannot deposit negative amount of money!");

		} else {
			account.setBalance(account.getBalance() + deposit);
			if (account.getBalance() > 0) {
				account.setBlocked(false);
				System.out.println("Your account " + account.getType() + " was unblocked!");
			} else {
				account.setBlocked(true);
			}
		}
	}

	public void withdraw(double withdraw) {
		if (withdraw < 0) {
			System.out.println("You cannot withdraw negative amount of money!");

		} else if (!account.isBlocked()) {
			if (account.getBalance() < withdraw) {
				System.out.println("The withdraw number is higher than balance amount!");
			} else {
				account.setBalance(account.getBalance() - withdraw);
			}
		} else {
			System.out.println("The account " + account.getType() + " is blocked!");
		}
	}
}
