package by.epam.code_review.module3.str_builder.task04;

/**
 * 4. С помощью функции копирования и операции конкатенации составить из частей слова "информатика" слово "торт".
 */

public class Task {

	public static void main(String[] args) {
		String testWord = "информатика";

		String newWord = makeNewWord(testWord);

		System.out.println("The word " + testWord + " becomes " + newWord);
	}

	private static String makeNewWord(String testWord) {

		if (testWord.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		char[] newStr = new char[4];

		testWord.getChars(7, 8, newStr, 0);
		testWord.getChars(3, 5, newStr, 1);
		testWord.getChars(7, 8, newStr, 3);

		StringBuilder resultStr = new StringBuilder();

		for (char c: newStr){
			resultStr.append(c);
		}

		return resultStr.toString();
	}
}
