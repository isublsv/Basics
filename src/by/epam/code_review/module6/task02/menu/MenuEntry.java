package by.epam.code_review.module6.task02.menu;

public abstract class MenuEntry {

	private String title;

	public MenuEntry(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract void run();
}
