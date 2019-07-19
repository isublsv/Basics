package by.etc.code_review.oop.task01.entity;

public class Text {

	private String content;

	public Text(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String addContent(String s) {
		content += " " + s;
		return content;
	}
}
