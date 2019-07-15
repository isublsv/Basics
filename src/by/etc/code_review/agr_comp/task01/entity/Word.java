package by.etc.code_review.agr_comp.task01.entity;

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
