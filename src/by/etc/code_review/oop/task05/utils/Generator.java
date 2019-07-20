package by.etc.code_review.oop.task05.utils;

import by.etc.code_review.oop.task05.entity.Color;

import java.util.Random;

public interface Generator<T> {

	Random random = new Random();

	T next();

	String getRandomType();

	static Color getRandomColor(){
		return Color.values()[random.nextInt(Color.values().length)];
	}
}
