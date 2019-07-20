package by.etc.code_review.oop.task05.utils;

import by.etc.code_review.oop.task05.entity.Bouquet;
import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.flower.Flower;
import by.etc.code_review.oop.task05.entity.flower.FlowerType;
import by.etc.code_review.oop.task05.entity.wrap.Wrap;
import by.etc.code_review.oop.task05.factory.BelarusFlowerFactory;
import by.etc.code_review.oop.task05.factory.FlowerAbstractFactory;
import by.etc.code_review.oop.task05.factory.HollandFlowerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BouquetUtils {

	private Bouquet bouquet;
	private WrapGenerator wrapGenerator = new WrapGenerator();
	private FlowerGenerator flowerGenerator;
	private int numberOfFlowers;
	private int numberOfWrap;

	public BouquetUtils(String name, String producer, int numberOfFlowers, int numberOfWrap) {
		bouquet = new Bouquet(name);
		flowerGenerator = new FlowerGenerator(producer);
		getFlowers(numberOfFlowers);
		makeWrap(numberOfWrap);
	}

	public int getNumberOfFlowers() {
		return numberOfFlowers;
	}

	public void setNumberOfFlowers(int numberOfFlowers) {
		this.numberOfFlowers = numberOfFlowers;
	}

	public void setNumberOfWrap(int numberOfWrap){
		this.numberOfWrap = numberOfWrap;
	}

	public int getNumberOfWrap() {
		return numberOfWrap;
	}

	private void makeWrap(int numberOfWrap){
		for (int i = 0; i < numberOfWrap; i++) {
			bouquet.addWrap(wrapGenerator.next());
		}
	}

	private void getFlowers(int numberOfFlowers){
		for (int i = 0; i < numberOfFlowers; i++) {
			bouquet.addFlower(flowerGenerator.next());
		}
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

	public void printBouquet(){
		System.out.println("Flowers: ");
		for (Flower flower : bouquet.getFlowers()){
			System.out.println(flower);
		}

		System.out.println("Wrap contains from: ");
		for (Wrap wrap : bouquet.getWraps()){
			System.out.println(wrap);
		}
	}

	public void findFlowersByColor(String color){
		if (bouquet.getWraps().isEmpty()) {
			System.out.println("The bouquet doesn't exist!");
			return;
		}

		for (Flower flower : bouquet.getFlowers()){
			if (flower.getColor() == Color.valueOf(color)){
				System.out.println(flower);
			}
		}

	}
}
