package by.etc.code_review.str_regexp.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 1. Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнить с текстом три различных
 * операции: отсортировать обзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства - по
 * алфавиту.
 */

public class Menu {

	private static Scanner scanner;

	public static void main(String[] args) {

		try {
			String testString = getString();

			scanner = new Scanner(System.in);

			while (true) {
				System.out.println("Please, choose an option:");
				System.out.println("1 - Sort paragraphs by the number of sentence.");
				System.out.println("2 - Sort words by length in the every sentence. ");
				System.out.println("3 - Sort tokens by number of given symbol or by the alphabet.");
				System.out.println("0 - Exit.");

				StringHandler stringHandler = new StringHandler();
				String s;

				int i = checkValue();
				if (i == 1) {

					s = stringHandler.sortParagraphsBySentenceNumber(testString);
					System.out.println("Result string:\n" + s);

				} else if (i == 2) {

					s = stringHandler.sortSentencesByWordLength(testString);
					System.out.println("Result string:\n" + s);

				} else if (i == 3) {

					System.out.println("Please, enter the symbol:");
					String c = getSymbol();
					s = stringHandler.sortTokens(testString, c);
					System.out.println("Result string:\n" + s);

				} else if (i == 0) {
					break;
				}
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static String getString() {

		String fileName = "D:/WORK/Dropbox/Java/Basics/src/by/etc/code_review/str_regexp/task01/random_text.txt";

		StringBuilder sb = new StringBuilder();
		try {
			scanner = new Scanner(new File(fileName));
			scanner.useDelimiter("\\Z");

			while (scanner.hasNext()) {
				sb.append((scanner.next()));
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return sb.toString();
	}

	private static String getSymbol() {
		return scanner.next();
	}

	private static int getValue() {

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextInt();
	}

	private static int checkValue() {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0 && value <= 3) {
				break;
			} else {
				System.out.println("Wrong value! Enter again: ");
			}
		}

		return value;
	}
}
