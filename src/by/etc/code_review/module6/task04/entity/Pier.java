package by.etc.code_review.module6.task04.entity;

public class Pier {

	private static int genID = 1;
	private int id;

	public Pier() {
		id = genID++;
	}

	@Override
	public String toString() {
		return "Pier #" + id;
	}
}
