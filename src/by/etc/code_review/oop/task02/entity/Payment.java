package by.etc.code_review.oop.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class Payment {

	private static int genId = 1;
	private int id;
	private Client client;
	private Invoice invoice;

	public Payment(Client client) {
		this.id = genId++;
		this.client = client;
		this.invoice = new Invoice();
	}

	public Client getClient() {
		return client;
	}

	private class Invoice {

		private List<Product> products;

		private Invoice() {
			products = new ArrayList<>();
		}

		private List<Product> getProducts() {
			return products;
		}

		private double getTotalPrice(){
			double sum = 0;
			for (Product product : products){
				sum += product.getPrice();
			}
			return sum;
		}
	}

	public boolean addProduct(Product product){
		return invoice.getProducts().add(product);
	}

	public boolean removeProduct(Product product){
		return invoice.getProducts().remove(product);
	}

	public void makePayment(){
		if (!invoice.getProducts().isEmpty()){
			System.out.println("The payment #" + id + " in amount " + invoice.getTotalPrice() + " is successfully done!");
		}else {
			System.out.println("The invoice is empty!");
		}
	}
}
