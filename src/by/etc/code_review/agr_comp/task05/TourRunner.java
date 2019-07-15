package by.etc.code_review.agr_comp.task05;

import by.etc.code_review.agr_comp.task05.entity.Agency;
import by.etc.code_review.agr_comp.task05.entity.Client;
import by.etc.code_review.agr_comp.task05.entity.Order;
import by.etc.code_review.agr_comp.task05.entity.tour.Food;
import by.etc.code_review.agr_comp.task05.entity.tour.Purpose;
import by.etc.code_review.agr_comp.task05.entity.tour.Tour;
import by.etc.code_review.agr_comp.task05.entity.tour.Transport;
import by.etc.code_review.agr_comp.task05.logic.TourHandler;
import by.etc.code_review.agr_comp.task05.logic.TourSelector;

import java.time.Period;
import java.util.List;

/**
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки различного типа
 * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать возможность выбора транспорта,
 * питания и числа дней. Реализовать выбор и сортировку путевок.
 */

public class TourRunner {

	public static void main(String[] args) {

		Agency agency = new Agency("TES Tour");

		Client client = new Client("John", "Wayne");

		agency.addClient(client);

		Tour thai = new Tour("Thailand", "Hot tour", Purpose.RECREATION,
				Transport.PLANE, Food.BREAKFAST, Period.ofDays(14), 799);
		Tour egypt = new Tour("Egypt", "Hot tour", Purpose.EXCURSION,
				Transport.PLANE, Food.ALL_INCLUSIVE, Period.ofDays(11), 599);
		Tour india = new Tour("India", "Hot tour", Purpose.TREATMENT,
				Transport.PLANE, Food.ALL_INCLUSIVE, Period.ofDays(7), 699);
		Tour italy = new Tour("Italy", "Hot tour", Purpose.SHOPPING,
				Transport.TRAIN, Food.NONE, Period.ofDays(3), 199);
		Tour world = new Tour("OVER THE WORLD", "BEST CRUISE", Purpose.CRUISE,
				Transport.SHIP, Food.ALL_INCLUSIVE, Period.ofDays(30), 1899);
		Tour brazil = new Tour("Brazil", "Carnaval", Purpose.RECREATION,
				Transport.PLANE, Food.BREAKFAST, Period.ofDays(9), 1299);

		agency.addTour(thai);
		agency.addTour(egypt);
		agency.addTour(india);
		agency.addTour(italy);
		agency.addTour(world);
		agency.addTour(brazil);

		TourHandler.sortTourByPrice(agency);

		System.out.println("Sort tours by price: ");
		TourHandler.printTours(agency.getTours());

		List<Tour> selectByOptions = TourSelector.selectByOptions(agency, Food.ALL_INCLUSIVE, Transport.PLANE, 7);

		System.out.println("List tours by food, transport and duration options: ");
		TourHandler.printTours(selectByOptions);

		List<Tour> toursByPurpose = TourSelector.selectToursByPurpose(agency, Purpose.RECREATION);

		System.out.println("List tours by purposes: ");
		TourHandler.printTours(toursByPurpose);

		agency.addOrder(new Order(client, india));

	}
}
