package by.etc.code_review.simple_obj.task08;

/**
 * Class aggregator for the Customer class.
 */
public class CustomerService {

	private String serviceName;
	private Customer[] customers;

	public CustomerService(String name, Customer[] customers) {
		this.serviceName = name;
		this.customers = customers;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public Customer[] sortByLastname() {

		for (int i = 0; i < customers.length - 1; i++) {
			int currentLastname = i;
			for (int j = i + 1; j < customers.length; j++) {

				if (customers[j].getLastname().compareToIgnoreCase(customers[currentLastname].getLastname()) < 0) {
					currentLastname = j;
				}
			}

			Customer temp = customers[currentLastname];
			customers[currentLastname] = customers[i];
			customers[i] = temp;
		}

		return customers;
	}

	public void getCustomerByCreditCardRange(long min, long max){

		if (min > max || min < 0){
			throw new RuntimeException("Wrong range values!");
		}


		for (Customer customer : customers){
			if (customer.getCreditCardNumber() >= min &&
					customer.getCreditCardNumber() <= max){
				System.out.println(customer);
			}
		}
	}

	public void printCustomers(){

		for (Customer customer : customers){
			System.out.println(customer);
		}
	}
}
