package by.etc.code_review.oop.task05.factory;

import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.wrap.*;

public class WrapFactory {

	public Wrap createWrap(Color color, String type) {
		WrapType sign = WrapType.valueOf(type);
		switch (sign) {
			case CLOTH:
				return new Cloth(color);
			case PAPER:
				return new Paper(color);
			case RIBBON:
				return new Ribbon(color);
			case MEMBRANE:
				return new Membrane(color);
			default:
				throw new EnumConstantNotPresentException(WrapType.class, sign.name());
		}
	}
}
