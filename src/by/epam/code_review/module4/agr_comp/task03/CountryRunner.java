package by.epam.code_review.module4.agr_comp.task03;

import by.epam.code_review.module4.agr_comp.task03.entity.City;
import by.epam.code_review.module4.agr_comp.task03.entity.Country;
import by.epam.code_review.module4.agr_comp.task03.entity.District;
import by.epam.code_review.module4.agr_comp.task03.entity.Region;

/**
 * 3. Создать объект класса Государство, используя Область, Район, Город. Методы: вывести на консоль столицу, количество
 * областей, площадь, областные центры.
 */

public class CountryRunner {

	public static void main(String[] args) {

		City capital = new City("Minsk", 2_000_000, 20.0);
		City city1 = new City("Polotsk", 100_000, 3.4);
		City city2 = new City("Slutsk", 50_000, 3.9);
		City city3 = new City("Slonim", 70_000, 2.4);
		City city4 = new City("Grodno", 600_000, 9.0);
		City city5 = new City("Vitebsk", 750_000, 10.0);

		District district1 = new District("Polotskii", city1, 500_000, 55.0);
		District district2 = new District("Slutskii", city2, 250_000, 25.0);
		District district3 = new District("Slonimskii", city3, 470_000, 51.0);


		Region region1 = new Region("Grodnenskii", city4);
		region1.addDistrict(district1);
		region1.addDistrict(district2);

		Region region2 = new Region("Vitebskii", city5);
		region2.addDistrict(district3);

		Country country = new Country("Belarus", capital);

		country.addRegion(region1);
		country.addRegion(region2);

		System.out.println("The capital: " + country.getCapital());

		System.out.println("The number of regions = " + country.getRegionNumber());

		System.out.println("The square = " + country.getSquare());


	}
}
