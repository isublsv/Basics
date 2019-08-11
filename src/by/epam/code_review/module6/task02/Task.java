package by.epam.code_review.module6.task02;

import by.epam.code_review.module6.task02.entity.Note;
import by.epam.code_review.module6.task02.logic.NotepadHandler;
import by.epam.code_review.module6.task02.logic.NotepadPrinter;
import by.epam.code_review.module6.task02.menu.Menu;
import by.epam.code_review.module6.task02.menu.MenuEntry;

import java.util.List;

/**
 * Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками в Блокноте. Каждая заметка это:
 * Заметка(тема, дата создания, email, сообщение).
 * <p>
 * Общие пояснения к практическому заданию.
 * 1. В начале работы приложения данные должны считаться из файла, в конце работы - сохраняться в файл.
 * 2. У пользователя должна быть возможность найти запись по любому параметру или группе параметров (группу параметров
 * можно определить самостоятельно), получить требуемые записи в отсортированном виде, найти записи, текстовое поле
 * которой содержит определенное слово, а также добавить новую запись.
 * 3. Особое условие: поиск, сравнение и валидацию вводимой информации осуществлять с использованием регулярных
 * выражений.
 * 4. Особое условие: проверку введенной информации на валидность должен осуществлять код, непосредственно добавляющий
 * информацию.
 */
public class Task {

	public static void main(String[] args) {

		NotepadHandler notepad = NotepadHandler.getInstance();

		Menu mainMenu = new Menu();

		mainMenu.addEntry(new MenuEntry("Add note.") {
			@Override
			public void run() {
				notepad.addNote();
			}
		});

		mainMenu.addEntry(new MenuEntry("Sort notes by email.") {
			@Override
			public void run() {
				notepad.sortNotesByEmail();
			}
		});

		mainMenu.addEntry(new MenuEntry("Sort notes by date.") {
			@Override
			public void run() {
				notepad.sortNotesByDate();
			}
		});

		mainMenu.addEntry(new MenuEntry("Get notes by email (xxxxx@xxx.xx).") {
			@Override
			public void run() {
				List<Note> notesByEmail = notepad.getNotesByEmail();
				NotepadPrinter.printNotes(notesByEmail);
			}
		});

		mainMenu.addEntry(new MenuEntry("Get notes after date (dd/MM/yy)") {
			@Override
			public void run() {
				List<Note> notesAfterDate = notepad.getNotesAfterDate();
				NotepadPrinter.printNotes(notesAfterDate);
			}
		});

		mainMenu.addEntry(new MenuEntry("Find note by word in the message.") {
			@Override
			public void run() {
				List<Note> notesByMessageWord = notepad.findNotesByMessageWord();
				NotepadPrinter.printNotes(notesByMessageWord);
			}
		});

		mainMenu.addEntry(new MenuEntry("Print all notes.") {
			@Override
			public void run() {
				NotepadPrinter.printNotes(notepad.getNotes());
			}
		});

		mainMenu.addEntry(new MenuEntry("Exit.") {
			@Override
			public void run() {
				mainMenu.setExit(true);
				notepad.saveNotepad();
			}
		});

		mainMenu.run();
	}
}
