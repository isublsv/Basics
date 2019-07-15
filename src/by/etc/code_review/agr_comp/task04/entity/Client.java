package by.etc.code_review.agr_comp.task04.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

	private String name;
	private String lastname;
	private List<Account> accounts;

	public Client(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
		accounts = new ArrayList<>();
	}

	public boolean addAccount(Account account) {
		return accounts.add(account);
	}

	public boolean removeAccount(Account account) {
		return accounts.remove(account);
	}

	public void getAccountByType(Type type) {

		for (Account account : accounts) {
			if (account.getType() == type) {
				System.out.println(account);
			}
		}
	}

	//shell sort
	public void sortAccountsByBalance() {

		int i = 0;

		while (i < accounts.size() - 1) {
			double max = accounts.get(i).getBalance();
			double next = accounts.get(i + 1).getBalance();

			if (max > next) {
				i++;
			} else {
				Collections.swap(accounts, i, i + 1);
				if (i > 1) {
					i--;
				} else {
					i = 0;
				}
			}
		}
	}

	public void deposit(Type type, double deposit){

		boolean isFound = false;
		for (Account account : accounts){

			if (account.getType() == type){
				account.deposit(deposit);
				isFound = true;
			}
		}

		if(!isFound){
			System.out.println("The account not found!");
		}
	}

	public void withdraw(Type type, double withdraw){

		boolean isFound = false;
		for (Account account : accounts){

			if (account.getType() == type){
				account.withdraw(withdraw);
				isFound = true;
			}
		}

		if(!isFound){
			System.out.println("The account not found!");
		}
	}


	public double getTotalBalance() {

		double sum = 0;

		for (Account account : accounts) {
			sum += account.getBalance();
		}

		return sum;
	}

	public double getOnlyPositiveBalances() {
		double sum = 0;

		for (Account account : accounts) {
			if (account.getBalance() > 0) {
				sum += account.getBalance();
			}
		}

		return sum;
	}

	public double getOnlyNegativeBalances() {
		double sum = 0;

		for (Account account : accounts) {
			if (account.getBalance() < 0) {
				sum += account.getBalance();
			}
		}

		return sum;
	}

	public void printAccounts() {

		for (Account account : accounts) {
			System.out.println(account);
		}
	}

	@Override
	public String toString() {
		return String.format("Client %s, %s", lastname, name);
	}
}
