package by.epam.code_review.module4.simple_obj.task10;

import java.time.LocalTime;

/**
 * 9. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
 * toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. Задать
 * критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * а) список рейсов для заданного пункта назначения;
 * б) список рейсов для заданного дня недели;
 * в) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class AirPort {

	private String name;
	private Airline[] airlines;

	public AirPort(String name, Airline[] airlines) {
		this.name = name;
		this.airlines = airlines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Airline[] getAirlines() {
		return airlines;
	}

	public void setAirlines(Airline[] airlines) {
		this.airlines = airlines;
	}

	public void getAirlinesByDestination(String dest){

		boolean isDest = false;

		for (Airline airline : airlines){
			if (airline.getDestination().equalsIgnoreCase(dest.trim())){
				System.out.println(airline);
				isDest = true;
			}
		}

		if (!isDest){
			System.out.println("There are no airlines to " + dest + " at the time.");
		}
	}

	public void getAirlinesByDayOfWeek(DayOfTheWeek day){

		boolean isDay = false;

		for (Airline airline : airlines){
			if (airline.getDayOfTheWeek().name().equalsIgnoreCase(day.name())){
				System.out.println(airline);
				isDay = true;
			}
		}

		if (!isDay){
			System.out.println("There are no airlines on " + day);
		}
	}

	public void getAirlinesByDayTime(DayOfTheWeek day, LocalTime time){

		boolean isTime = false;

		for (Airline airline : airlines){
			if (airline.getDayOfTheWeek().name().equalsIgnoreCase(day.name())){
				if (airline.getDeparture().compareTo(time) > 0){
					System.out.println(airline);
					isTime = true;
				}
			}
		}

		if (!isTime){
			System.out.println("There are no airlines on " + day + " after " + time);
		}
	}

	public void printAirlines(){

		for (Airline airline : airlines){
			System.out.println(airline);
		}
	}
}
