package by.etc.code_review.module6.task01.entity.user;

public class Letter {

	private Email from;
	private Email to;
	private String subject;
	private String content;

	public Letter(Email from, Email to, String subject, String content) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public Email getFrom() {
		return from;
	}

	public void setFrom(Email from) {
		this.from = from;
	}

	public Email getTo() {
		return to;
	}

	public void setTo(Email to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("The letter from %s, to %s, subject: %s\n \"%s\"", from, to, subject, content);
	}
}
