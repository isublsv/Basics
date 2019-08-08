package by.epam.code_review.module4.simple_obj.task10;

import java.time.LocalTime;

public class Task {

	public static void main(String[] args) {


		Airline[] airlines = {
				new Airline("Moscow", "RU 1234", "Airbus 319",
						LocalTime.of(18, 30), DayOfTheWeek.MONDEY),
				new Airline("Minsk", "BY 2255", "Airbus 320",
						LocalTime.of(22, 15), DayOfTheWeek.THURSDAY),
				new Airline("London", "GB 6354", "Boing 747",
						LocalTime.of(12, 0), DayOfTheWeek.MONDEY),
				new Airline("Paris", "FR 9952", "Airbus 321",
						LocalTime.of(21, 45), DayOfTheWeek.FRIDAY),
				new Airline("New-York", "US 7711", "Airbus 319",
						LocalTime.of(18, 0), DayOfTheWeek.SATURDAY),
				new Airline("Moscow", "RU 4321", "Boing 740",
						LocalTime.of(20, 25), DayOfTheWeek.MONDEY),
				new Airline("Minsk", "BY 6633", "Airbus 320",
						LocalTime.of(9, 30), DayOfTheWeek.WEDNESDAY),
				new Airline("New-York", "US 7536", "Boing 747",
						LocalTime.of(2, 30), DayOfTheWeek.MONDEY),
		};

		AirPort airPort = new AirPort("Minsk - 1", airlines);

		airPort.printAirlines();

		System.out.println();

		airPort.getAirlinesByDestination("Moscow");

		System.out.println();

		airPort.getAirlinesByDayOfWeek(DayOfTheWeek.MONDEY);

		System.out.println();

		airPort.getAirlinesByDayTime(DayOfTheWeek.MONDEY, LocalTime.of(12, 0));
	}
}
