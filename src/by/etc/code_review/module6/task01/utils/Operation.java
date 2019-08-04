package by.etc.code_review.module6.task01.utils;

public enum Operation {
	ADDED,
	REMOVED;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
