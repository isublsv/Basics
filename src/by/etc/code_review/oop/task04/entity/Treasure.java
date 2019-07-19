package by.etc.code_review.oop.task04.entity;

import java.util.Random;

public abstract class Treasure implements Comparable<Treasure>{

	private static int genId = 1;
	private int id;
	private String name;
	private int value;
	private Random random;

	public Treasure() {
		this.id = genId++;
		random = new Random();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	protected Random getRandom() {
		return random;
	}

	public abstract void setRandomName();

	public abstract int setRandomParameter();

	public void setRandomValue() {
		this.value = random.nextInt(999) + 1;
	}

	@Override
	public int compareTo(Treasure o) {
		return this.value - o.value;
	}

	@Override
	public String toString() {
		return "#" + id + ", " + name + ", " + value + " gold.";
	}
}