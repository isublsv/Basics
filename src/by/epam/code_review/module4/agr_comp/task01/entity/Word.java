package by.epam.code_review.module4.agr_comp.task01.entity;

public class Word {

	private String content;

	public Word(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return content;
	}
}
