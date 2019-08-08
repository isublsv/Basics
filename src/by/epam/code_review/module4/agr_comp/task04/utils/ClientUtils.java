package by.epam.code_review.module4.agr_comp.task04.utils;

import by.epam.code_review.module4.agr_comp.task04.entity.Account;
import by.epam.code_review.module4.agr_comp.task04.entity.Client;
import by.epam.code_review.module4.agr_comp.task04.entity.Type;

public class ClientUtils {

	private Client client;

	public ClientUtils(Client client) {
		this.client = client;
	}

	public void getAccountByType(Type type) {

		for (Account account : client.getAccounts()) {
			if (account.getType() == type) {
				System.out.println(account);
			}
		}
	}

	//shell sort
	public void sortAccountsByBalance() {

		int in, out;
		Account temp;
		int h = 1;

		//found initial step value
		while (h <= client.getAccounts().size() / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			for (out = h; out < client.getAccounts().size(); out++) {
				temp = client.getAccounts().get(out);
				in = out;
				while (in > h - 1 && client.getAccounts().get(in - h).getBalance() >= temp.getBalance()) {
					client.getAccounts().set(in, client.getAccounts().get(in - h));
					in -= h;
				}
				client.getAccounts().set(in, temp);
			}
			h = (h - 1) / 3;    //decrease h
		}
	}

	public void deposit(Type type, double deposit) {

		boolean isFound = false;
		for (Account account : client.getAccounts()) {

			if (account.getType() == type) {
				AccountUtils accountUtils = new AccountUtils(account);
				accountUtils.deposit(deposit);
				isFound = true;
			}
		}

		if (!isFound) {
			System.out.println("The account not found!");
		}
	}

	public void withdraw(Type type, double withdraw) {

		boolean isFound = false;
		for (Account account : client.getAccounts()) {

			if (account.getType() == type) {
				AccountUtils accountUtils = new AccountUtils(account);
				accountUtils.withdraw(withdraw);
				isFound = true;
			}
		}

		if (!isFound) {
			System.out.println("The account not found!");
		}
	}


	public double getTotalBalance() {

		double sum = 0;

		for (Account account : client.getAccounts()) {
			sum += account.getBalance();
		}

		return sum;
	}

	public double getOnlyPositiveBalances() {
		double sum = 0;

		for (Account account : client.getAccounts()) {
			if (account.getBalance() > 0) {
				sum += account.getBalance();
			}
		}

		return sum;
	}

	public double getOnlyNegativeBalances() {
		double sum = 0;

		for (Account account : client.getAccounts()) {
			if (account.getBalance() < 0) {
				sum += account.getBalance();
			}
		}

		return sum;
	}

	public void printAccounts() {

		for (Account account : client.getAccounts()) {
			System.out.println(account);
		}
	}
}
