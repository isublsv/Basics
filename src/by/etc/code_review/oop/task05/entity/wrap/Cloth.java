package by.etc.code_review.oop.task05.entity.wrap;

import by.etc.code_review.oop.task05.entity.Color;

public class Cloth extends Wrap {

	private String texture;
	private Density density;

	public Cloth(Color color) {
		super(color);
		this.texture = "#######";
		this.density = Density.MIDDLE;
		type = WrapType.CLOTH;
	}

	public Cloth(Color color, String texture, Density density) {
		super(color);
		this.texture = texture;
		this.density = density;
		type = WrapType.CLOTH;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public Density getDensity() {
		return density;
	}

	public void setDensity(Density density) {
		this.density = density;
	}

	@Override
	public double getRandomPrice() {
		return random.nextInt(5) + 1;
	}

	@Override
	public String toString() {
		return super.toString() + " " + type.getName()
		                                    .toLowerCase() + ", with texture (" + texture + ") and density "
				+ density.getValue() + "g/m2, price = " + getPrice() + "$";
	}
}
