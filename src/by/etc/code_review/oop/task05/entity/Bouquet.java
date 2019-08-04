package by.etc.code_review.oop.task05.entity;

import by.etc.code_review.oop.task05.entity.flower.Flower;
import by.etc.code_review.oop.task05.entity.wrap.Wrap;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

	private static int getId = 1;
	private int id;
	private String name;
	private List<Flower> flowers;
	private List<Wrap> wraps;

	public Bouquet() {
		this.id = getId++;
		this.name = "Wedding bouquet";
		flowers = new ArrayList<>();
		wraps = new ArrayList<>();
	}

	public Bouquet(String name) {
		this();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public List<Wrap> getWraps() {
		return wraps;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addFlower(Flower flower) {
		return flowers.add(flower);
	}

	public boolean removeFlower(Flower flower) {
		return flowers.remove(flower);
	}

	public boolean addWrap(Wrap wrap) {
		return wraps.add(wrap);
	}

	public boolean removeWrap(Wrap wrap) {
		return wraps.remove(wrap);
	}
}
