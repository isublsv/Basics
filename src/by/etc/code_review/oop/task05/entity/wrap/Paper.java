package by.etc.code_review.oop.task05.entity.wrap;

import by.etc.code_review.oop.task05.entity.Color;

public class Paper extends Wrap {

	private String texture;

	public Paper(Color color) {
		super(color);
		this.texture = "@@@@@@@";
		type = WrapType.PAPER;
	}

	public Paper(Color color, String texture) {
		super(color);
		this.texture = texture;
		type = WrapType.PAPER;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	@Override
	public double getRandomPrice() {
		return random.nextInt(4) + 1;
	}

	@Override
	public String toString() {
		return super.toString() + " " + type.getName()
		                                    .toLowerCase() + ", texture (" + texture + "), price = " + getPrice() + "$";
	}
}
