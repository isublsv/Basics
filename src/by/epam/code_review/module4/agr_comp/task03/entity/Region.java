package by.epam.code_review.module4.agr_comp.task03.entity;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private String name;
	private City center;
	private List<District> districts;

	public Region(String name, City center) {
		this.name = name;
		this.center = center;
		this.districts = new ArrayList<>();
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

	public boolean addDistrict(District district){
		return districts.add(district);
	}

	public boolean removeDistrict(District district){
		return districts.remove(district);
	}

	public long getPopulation() {
		long sum = 0;

		for (District district: districts){
			sum += district.getPopulation();
		}

		return sum + center.getPopulation();
	}

	public double getSquare(){
		double total = 0;

		for (District district : districts){
			total += district.getSquare();
		}

		return total + center.getSquare();
	}

	@Override
	public String toString() {
		return "Region{" + "name='" + name + '\'' + ", center=" + center + '}';
	}
}
