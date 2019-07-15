package by.etc.code_review.agr_comp.task03.entity;

public class District {

	private String name;
	private City center;
	private long population;
	private double square;

	public District(String name, City center, long population, double square) {
		this.name = name;
		this.center = center;
		this.population = population;
		this.square = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCenter() {
		return center;
	}

	public void setCenter(City center) {
		this.center = center;
	}

	public long getPopulation() {
		return population + center.getPopulation();
	}

	public double getSquare() {
		return square + center.getSquare();
	}

	@Override
	public String toString() {
		return "District{" + "name='" + name + '\'' + ", center=" + center + '}';
	}
}
