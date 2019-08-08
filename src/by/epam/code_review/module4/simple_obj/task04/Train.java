package by.epam.code_review.module4.simple_obj.task04;

import java.time.LocalTime;

/**
 * 4. Создайте класс Train, содержаший поля: название пункта назначения, номер поезда, время отправления. Создайте
 * массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам поездов. Добавьте
 * возможность вывода информации о поезде, номер которого введен пользователем. Добавьте возможность сортировки массива
 * по пункту назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class Train {

	private String destination;
	private int number;
	private LocalTime departureTime;

	public Train(String destination, int number, LocalTime departureTime) {
		this.destination = destination;
		this.number = number;
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Train{" + "destination='" + destination + '\'' + ", number=" + number
				+ ", departureTime=" + departureTime + '}';
	}
}
