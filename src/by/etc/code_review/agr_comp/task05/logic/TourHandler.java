package by.etc.code_review.agr_comp.task05.logic;

import by.etc.code_review.agr_comp.task05.entity.Agency;
import by.etc.code_review.agr_comp.task05.entity.tour.Tour;

import java.util.List;

public class TourHandler {

	//shell sort
	public static void sortTourByPrice(Agency agency) {

		int in, out;
		Tour temp;
		int h = 1;

		//found initial step value
		while (h <= agency.getTours().size()) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			for (out = h; out < agency.getTours().size(); out++) {
				temp = agency.getTours().get(out);
				in = out;
				while (in > h - 1 && agency.getTours().get(in - h).getPrice() >= temp.getPrice()) {
					agency.getTours().set(in, agency.getTours().get(in - h));
					in -= h;
				}
				agency.getTours().set(in, temp);
			}
			h = (h - 1) / 3;    //decrease h
		}
	}

	public static void printTours(List<Tour> tours){

		for (Tour tour : tours){
			System.out.println(tour);
		}
	}
}
