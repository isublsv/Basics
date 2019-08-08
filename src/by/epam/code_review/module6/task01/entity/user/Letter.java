package by.epam.code_review.module6.task01.entity.user;

import by.epam.code_review.module6.task01.entity.Content;

public class Letter {

	private Email from;
	private Email to;
	private String subject;
	private String text;
	private Content attachment;

	public Letter(Email from, Email to, String subject, String text, Content attachment) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.attachment = attachment;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Content getAttachment() {
		return attachment;
	}

	public void setAttachment(Content attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return String.format("The letter from %s, to %s, subject: %s\n \"%s\"", from, to, subject, text);
	}
}
