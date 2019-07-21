package by.etc.code_review.oop.task05.utils;

import by.etc.code_review.oop.task05.entity.Bouquet;
import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.flower.Flower;
import by.etc.code_review.oop.task05.entity.wrap.Wrap;

public class BouquetUtils {

	private Bouquet bouquet;

	public BouquetUtils(Bouquet bouquet) {
		this.bouquet = bouquet;
	}

	private double getTotalFlowersPrice() {
		double s = 0;

		if (bouquet.getFlowers().isEmpty()) {
			System.out.println("The bouquet doesn't exist!");
			return s;
		}

		for (Flower flower : bouquet.getFlowers()) {
			s += flower.getPrice();
		}

		return s;
	}

	private double getTotalWrapsPrice() {
		double s = 0;

		if (bouquet.getWraps().isEmpty()) {
			System.out.println("The bouquet doesn't exist!");
			return s;
		}

		for (Wrap wrap : bouquet.getWraps()) {
			s += wrap.getPrice();
		}

		return s;
	}

	public double getTotalBouquetPrice() {
		return getTotalFlowersPrice() + getTotalWrapsPrice();
	}

	public void printBouquet() {
		System.out.println("The bouquet " + bouquet.getName() + ":");
		for (Flower flower : bouquet.getFlowers()) {
			System.out.println(flower);
		}

		System.out.println("The wrap contains from: ");
		for (Wrap wrap : bouquet.getWraps()) {
			System.out.println(wrap);
		}
	}

	public void findFlowersByColor(String color) {
		if (bouquet.getWraps().isEmpty()) {
			System.out.println("The bouquet doesn't exist!");
			return;
		}

		for (Flower flower : bouquet.getFlowers()) {
			if (flower.getColor() == Color.valueOf(color)) {
				System.out.println(flower);
			}
		}
	}
}
