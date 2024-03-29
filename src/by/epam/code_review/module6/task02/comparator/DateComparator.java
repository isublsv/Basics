package by.epam.code_review.module6.task02.comparator;

import by.epam.code_review.module6.task02.entity.Note;

import java.util.Comparator;

public class DateComparator implements Comparator<Note> {

	@Override
	public int compare(Note o1, Note o2) {
		return o1.getDateOfCreation().compareTo(o2.getDateOfCreation());
	}
}
