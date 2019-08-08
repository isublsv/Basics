package by.epam.code_review.module5.oop.task01.entity;

import java.time.LocalDateTime;

public abstract class File {

	private String name;
	private boolean isReadable = false;
	private boolean isWritable = false;
	private int size;
	private LocalDateTime created;
	private LocalDateTime modified;
	private LocalDateTime opened;

	public File(String name) {
		this.name = name;
		this.isReadable = true;
		this.isWritable = true;
		this.size = 0;
		this.created = LocalDateTime.now();
	}

	public String getName() {
		return name;
	}

	public boolean isReadable() {
		return isReadable;
	}

	public boolean isWritable() {
		return isWritable;
	}

	public LocalDateTime getCreated() {
		System.out.print("Created: ");
		return created;
	}

	public LocalDateTime getModified() {
		System.out.print("Modified: ");
		return modified;
	}

	public LocalDateTime getOpened() {
		System.out.print("Opened: ");
		return opened;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReadable(boolean readable) {
		isReadable = readable;
	}

	public void setWritable(boolean writable) {
		isWritable = writable;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public void setOpened(LocalDateTime opened) {
		this.opened = opened;
	}

	public abstract void read();

	public abstract void printContent();

	public abstract int getSize();

	public abstract void addContent(String content);

	@Override
	public String toString() {
		return name;
	}
}
