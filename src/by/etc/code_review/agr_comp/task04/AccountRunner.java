package by.etc.code_review.agr_comp.task04;

import by.etc.code_review.agr_comp.task04.entity.Account;
import by.etc.code_review.agr_comp.task04.entity.Client;
import by.etc.code_review.agr_comp.task04.entity.Type;
import by.etc.code_review.agr_comp.task04.utils.ClientUtils;

/**
 * 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим
 * положительный и отрицательный балансы отдельно.
 */

public class AccountRunner {

	public static void main(String[] args) {

		Client client = new Client("John", " Wayne");

		Account checking = new Account(123415L, Type.CHECKING, -1234.05d);
		Account savings = new Account(323541L, Type.SAVINGS, 6652.99d);
		Account current = new Account(123555L, Type.CURRENT, 52.88d);
		Account cd = new Account(665623L, Type.CD, -505d);
		Account mm = new Account(323871L, Type.MM, 12.50d);
		Account ira = new Account(354381L, Type.IRA, 555.55d);

		client.addAccount(checking);
		client.addAccount(savings);
		client.addAccount(current);
		client.addAccount(cd);
		client.addAccount(mm);
		client.addAccount(ira);

		ClientUtils utils = new ClientUtils(client);

		utils.printAccounts();

		System.out.println("Selected account:");
		utils.getAccountByType(Type.MM);

		utils.deposit(Type.CD, 1000);

		utils.withdraw(Type.MM, 20);

		System.out.println("Total balance from all accounts = " + utils.getTotalBalance());

		System.out.println("Total balance from accounts with only negative balances = " + utils.getOnlyNegativeBalances());

		System.out.println("Total balance from account with only positive balances = " + utils.getOnlyPositiveBalances());

		utils.sortAccountsByBalance();

		utils.printAccounts();
	}
}
