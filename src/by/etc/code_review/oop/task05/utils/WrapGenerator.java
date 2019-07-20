package by.etc.code_review.oop.task05.utils;

import by.etc.code_review.oop.task05.entity.wrap.Wrap;
import by.etc.code_review.oop.task05.entity.wrap.WrapType;
import by.etc.code_review.oop.task05.factory.WrapFactory;

public class WrapGenerator implements Generator<Wrap> {

	private WrapFactory wrapFactory = new WrapFactory();

	@Override
	public Wrap next() {
		return wrapFactory.createWrap(Generator.getRandomColor(), getRandomType());
	}

	@Override
	public String getRandomType(){
		WrapType type = WrapType.values()[random.nextInt(WrapType.values().length)];
		return type.name();
	}
}
