package by.etc.code_review.agr_comp.task05.logic;

import by.etc.code_review.agr_comp.task05.entity.Agency;
import by.etc.code_review.agr_comp.task05.entity.tour.Tour;

import java.util.Collections;
import java.util.List;

public class TourHandler {

	public static void sortTourByPrice(Agency agency) {

		int i = 0;
		while (i < agency.getTours().size() - 1) {
			double max = agency.getTours().get(i).getPrice();
			double next = agency.getTours().get(i + 1).getPrice();

			if (max < next) {
				i++;
			} else {
				Collections.swap(agency.getTours(), i, i + 1);
				if (i > 1) {
					i--;
				} else {
					i = 0;
				}
			}
		}
	}

	public static void printTours(List<Tour> tours){

		for (Tour tour : tours){
			System.out.println(tour);
		}
	}
}
