package by.epam.code_review.module5.oop.task05.utils;

import by.epam.code_review.module5.oop.task05.entity.Color;

import java.util.Random;

public interface Generator<T> {

	Random random = new Random();

	T next();

	String getRandomType();

	static Color getRandomColor(){
		return Color.values()[random.nextInt(Color.values().length)];
	}
}
