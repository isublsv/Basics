package by.etc.code_review.simple_obj.task08;

public class Task {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService("The Private Customer's DB", new Customer[]{
				new Customer("Fedorov", "Petr", "Andreevich", "Moscow",
						1234456778911234L, 234413),
				new Customer("Sidorova", "Alena", "Sergeevna", "Minsk",
						1234456720178795L, 321354),
				new Customer("Rak", "Semen", "Petrovich", "Brest",
						6546856765484321L, 985133),
				new Customer("Orlov", "Sergei", "Olegovich", "Omsk",
						3214751335786549L, 231354),
				new Customer("Kovalenko", "Irina", "Vadimovna", "Kiev",
						6942426894736842L, 985656),
				new Customer("Smak", "Ilya", "Mihailovich", "Smolensk",
						1456987351268469L, 584365),
				new Customer("Petrov", "Anton", "Vasilievich", "London",
						6587321456563334L, 749766),
				new Customer("Nikiforova", "Olga", "Maksimovna", "Paris",
						3146468766993212L, 976533),
		});

		customerService.printCustomers();

		System.out.println("Sort customers list by lastname: ");

		customerService.sortByLastname();

		customerService.printCustomers();

		System.out.println("Customer with credit cards numbers in the range: ");

		customerService.getCustomerByCreditCardRange(1000000000000000L, 5000000000000000L);

		System.out.println();

		//customerService.getCustomerByCreditCardRange(-1, 0);
	}
}
