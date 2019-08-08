package by.epam.code_review.module5.oop.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	private String name;
	private List<Client> clients;
	private List<Product> products;
	private List<Payment> payments;

	public Shop(String name) {
		this.name = name;
		clients = new ArrayList<>();
		products = new ArrayList<>();
		payments = new ArrayList<>();
	}

	public boolean addClient(Client client){
		return clients.add(client);
	}

	public boolean removeClient(Client client){
		return clients.remove(client);
	}

	public boolean addProduct(Product product){
		return products.add(product);
	}

	public boolean removeProduct(Product product){
		return products.remove(product);
	}

	public boolean addPayment(Payment payment){
		return payments.add(payment);
	}

	public boolean removePayment(Payment payment){
		return payments.remove(payment);
	}
}
