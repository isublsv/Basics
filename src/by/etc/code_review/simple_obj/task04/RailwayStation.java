package by.etc.code_review.simple_obj.task04;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * 4. Создайте класс Train, содержаший поля: название пункта назначения, номер поезда, время отправления. Создайте
 * массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам поездов. Добавьте
 * возможность вывода информации о поезде, номер которого введен пользователем. Добавьте возможность сортировки массива
 * по пункту назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class RailwayStation {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Train[] trains = {
				new Train("Minsk", 10, LocalTime.of(22, 0)),
				new Train("Moscow", 3, LocalTime.of(22, 30)),
				new Train("Murmansk", 2, LocalTime.of(21, 35)),
				new Train("Irkutsk", 1, LocalTime.of(20, 0)),
				new Train("Minsk", 5, LocalTime.of(20, 45)),
				new Train("Minsk", 4, LocalTime.of(18, 15)),
				new Train("Brest", 8, LocalTime.of(15, 30)),
		};

		sortTrainsByNumber(trains);

		System.out.println("Sort trains by number: ");
		printTrainList(trains);

		sortTrainsByDestination(trains);

		System.out.println("Sort trains by destination: ");
		printTrainList(trains);

		try {
			System.out.println("Please, enter the number of a train:");

			int number = checkValue(trains);

			getTrainByNumber(trains, number);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void sortTrainsByNumber(Train[] trains) {            //selection sort

		for (int i = 0; i < trains.length - 1; i++) {
			int minNumber = i;
			for (int j = i + 1; j < trains.length; j++) {
				if (trains[j].getNumber() < trains[minNumber].getNumber()) {
					minNumber = j;
				}
			}

			Train temp = trains[minNumber];
			trains[minNumber] = trains[i];
			trains[i] = temp;
		}
	}

	private static void sortTrainsByDestination(Train[] trains) {       //selection sort

		for (int i = 0; i < trains.length - 1; i++) {
			int minDest = i;
			for (int j = i + 1; j < trains.length; j++) {

				if (trains[j].getDestination().compareToIgnoreCase(trains[minDest].getDestination()) < 0) {
					minDest = j;

				} else if (trains[j].getDestination().compareToIgnoreCase(trains[minDest].getDestination()) == 0) {

					if (trains[j].getDepartureTime().compareTo(trains[minDest].getDepartureTime()) < 0) {
						Train temp = trains[minDest];
						trains[minDest] = trains[j];
						trains[j] = temp;

					}
				}
			}

			Train temp = trains[minDest];
			trains[minDest] = trains[i];
			trains[i] = temp;
		}
	}

	private static void printTrainList(Train[] trains) {

		for (Train train : trains) {
			System.out.println(train);
		}
	}

	private static void getTrainByNumber(Train[] trains, int number) {

		boolean isExist = false;

		for (Train train : trains) {
			if (train.getNumber() == number) {
				System.out.println(train);
				isExist = true;
				break;
			}
		}

		if (!isExist) {
			System.out.println("The train with the number " + number + " doesn't exist!");
		}
	}

	private static int getValue() {

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextInt();
	}

	private static int checkValue(Train[] trains) {

		int value;

		while (true) {
			value = getValue();

			if (value > 0 && value <= trains.length) {
				break;
			} else {
				System.out.println("Wrong number! Enter again: ");
			}
		}

		return value;
	}
}
