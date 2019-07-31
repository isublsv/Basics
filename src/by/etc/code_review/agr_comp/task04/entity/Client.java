package by.etc.code_review.agr_comp.task04.entity;

import java.util.ArrayList;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean addAccount(Account account) {
		return accounts.add(account);
	}

	public boolean removeAccount(Account account) {
		return accounts.remove(account);
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return String.format("Client %s, %s", lastname, name);
	}
}
