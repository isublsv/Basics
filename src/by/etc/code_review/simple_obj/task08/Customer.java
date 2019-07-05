package by.etc.code_review.simple_obj.task08;

/**
 * 8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа Customer, c подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные в консоль.
 *
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * б) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
 */

public class Customer {

	private static int idAuto = 0;
	private  int id;
	private String lastname;
	private String name;
	private String patronymic;
	private String address;
	private long creditCardNumber;
	private long accountNumber;

	public Customer(String lastname, String name, String patronymic, String address,
	                long creditCardNumber, long accountNumber) {
		this.id = idAuto++;
		this.lastname = lastname;
		this.name = name;
		this.patronymic = patronymic;
		this.address = address;
		this.creditCardNumber = creditCardNumber;
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return String.format("id: %d\t lastname: %s\t name: %s\t patronymic: %s\t address: %s\t creditCardNumber: %d\t" +
				" accountNumber: %d", id, lastname, name, patronymic, address, creditCardNumber, accountNumber);
	}
}
