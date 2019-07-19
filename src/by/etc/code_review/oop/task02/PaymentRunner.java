package by.etc.code_review.oop.task02;

import by.etc.code_review.oop.task02.entity.Client;
import by.etc.code_review.oop.task02.entity.Payment;
import by.etc.code_review.oop.task02.entity.Product;
import by.etc.code_review.oop.task02.entity.Shop;

/**
 * 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких
 * товаров.
 */

public class PaymentRunner {

	public static void main(String[] args) {

		Shop shop = new Shop("Shop #1");

		Client client = new Client("John", "Wayne");

		Product product1 = new Product("Bicycle", "Transport", 999.99);
		Product product2 = new Product("Bed", "Furniture", 549.89);
		Product product3 = new Product("Toy", "For kids", 19.89);
		Product product4 = new Product("Hook", "Sport", 44.89);
		Product product5 = new Product("Drill", "Instrument", 99.89);

		shop.addClient(client);

		shop.addProduct(product1);
		shop.addProduct(product2);
		shop.addProduct(product3);
		shop.addProduct(product4);
		shop.addProduct(product5);

		Payment payment = new Payment(client);

		payment.addProduct(product1);
		payment.addProduct(product2);

		payment.makePayment();
	}

}
