package by.epam.code_review.module5.oop.task05.utils;

import by.epam.code_review.module5.oop.task05.entity.Bouquet;
import by.epam.code_review.module5.oop.task05.entity.flower.Flower;
import by.epam.code_review.module5.oop.task05.entity.wrap.Wrap;

public class BouquetBuilder {

	private Bouquet bouquet;
	private WrapGenerator wrapGenerator;
	private FlowerGenerator flowerGenerator;
	private int numberOfFlowers;
	private int numberOfWrap;

	public BouquetBuilder() {
		bouquet = new Bouquet();
		flowerGenerator = new FlowerGenerator("Holland");
		wrapGenerator = new WrapGenerator();
		this.numberOfFlowers = 10;
		this.numberOfWrap = 5;
	}

	public int getNumberOfFlowers() {
		return numberOfFlowers;
	}

	public int getNumberOfWrap() {
		return numberOfWrap;
	}

	public BouquetBuilder withName(String name) {
		bouquet.setName(name);
		return this;
	}

	public BouquetBuilder setNumberOfFlowers(int numberOfFlowers) {
		this.numberOfFlowers = numberOfFlowers;
		return this;
	}

	public BouquetBuilder setNumberOfWrap(int numberOfWrap) {
		this.numberOfWrap = numberOfWrap;
		return this;
	}

	public BouquetBuilder setProducer(String producer) {
		flowerGenerator = new FlowerGenerator(producer);
		return this;
	}

	public Bouquet buildBouquet() {
		getFlowers();
		makeWrap();
		return bouquet;
	}

	private void makeWrap() {
		for (int i = 0; i < numberOfWrap; i++) {
			Wrap wrap = wrapGenerator.next();
			if (!bouquet.getWraps().contains(wrap)) {
				bouquet.addWrap(wrap);
			}
		}
	}

	private void getFlowers() {
		for (int i = 0; i < numberOfFlowers; i++) {
			Flower flower = flowerGenerator.next();
			if (!bouquet.getFlowers().contains(flower)) {
				bouquet.addFlower(flower);
			}
		}
	}

}
