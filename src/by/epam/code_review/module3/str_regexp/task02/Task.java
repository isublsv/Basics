package by.epam.code_review.module3.str_regexp.task02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 2. Дана строка, содержащая следующий текст (xml-документ):
 * <notes>
 * <note id="1">
 * <to>Вася</to>
 * <from>Света</from>
 * <heading>Напоминание</heading>
 * <body>Позвони мне завтра!</body>
 * </note>
 * <note id="2">
 * <to>Петя</to>
 * <from>Маша</from>
 * <heading>Важное напоминание</heading>
 * <body/>
 * </note>
 * </notes>
 * <p>
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип(открывающий тек,
 * закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
 * нельзя.
 */

public class Task {

	public static void main(String[] args) {

		String fileName = "D:/WORK/Dropbox/Java/Basics/src/by/epam/code_review/str_regexp/task02/document.xml";

		try {
			Scanner scanner = new Scanner(new File(fileName));
			scanner.useDelimiter("\\Z");

			StringBuilder sb = new StringBuilder();

			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine());
			}

			parseString(sb.toString());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void parseString(String string) {

		//Positive Lookahead (?=<) or Positive Lookbehind (?<=>)
		String node = "(?=<)|(?<=>)";

		String[] strings = Pattern.compile(node).split(string);

		for (String s : strings) {

			String current = s.trim();

			if (!current.isEmpty()) {

				if (s.startsWith("<") && !s.contains("/") ) {
					System.out.println(s + " - opening tag");

				} else if (s.startsWith("</") && s.endsWith(">")) {
					System.out.println(s + " - closing tag");

				} else if (s.endsWith("/>")) {
					System.out.println(s + " - tag without body");

				} else if (!s.contains("<")) {
					System.out.println(s + " - tag content");
				}

			}
		}
	}
}
