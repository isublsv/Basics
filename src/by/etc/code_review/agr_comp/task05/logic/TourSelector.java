package by.etc.code_review.agr_comp.task05.logic;

import by.etc.code_review.agr_comp.task05.entity.Agency;
import by.etc.code_review.agr_comp.task05.entity.tour.Food;
import by.etc.code_review.agr_comp.task05.entity.tour.Purpose;
import by.etc.code_review.agr_comp.task05.entity.tour.Tour;
import by.etc.code_review.agr_comp.task05.entity.tour.Transport;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class TourSelector {

	public static List<Tour> selectToursByPurpose(Agency agency, Purpose purpose){

		List<Tour> tours = new ArrayList<>();

		for (Tour tour : agency.getTours()){
			if (tour.getPurpose() == purpose){
				tours.add(tour);
			}
		}

		return tours;
	}

	public static List<Tour> selectByOptions(Agency agency, Food food, Transport transport, int duration){

		List<Tour> tours = new ArrayList<>();

		for (Tour tour : agency.getTours()){
			if (tour.getFood() == food && tour.getTransport() == transport
					&& tour.getDuration().equals(Period.ofDays(duration))){
				tours.add(tour);
			}
		}

		return tours;
	}
}
