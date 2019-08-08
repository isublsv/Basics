package by.epam.code_review.module3.str_array.task01;

/**
 * 1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class Task {

	public static void main(String[] args) {

		String[] strings = {"toLowerCase", "camelCase", "toString", "ignoreCase", "compareTo", "thisIsAThing", "FINAL"};
		//String[] strings = {};

		String[] convertedStrings = convertToUnderScoreCase(strings);

		printArray(convertedStrings);
	}

	private static String[] convertToUnderScoreCase(String[] strings) {

		if (strings.length == 0){
			System.out.println("The given array is empty!");
			return new String[]{};
		}

		for (int i = 0; i < strings.length; i++) {
			char[] chars = strings[i].toCharArray();

			char[] resultWord = new char[chars.length + getNumberOfReplaces(strings[i])];

			for (int j = 0, k = 0; j < chars.length; j++) {
				char c = chars[j];

				if (isUpperCase(c)) {
					if (j != 0) {                           //if not the first letter
						resultWord[k] = '_';
						resultWord[k + 1] = toLowerCase(c);
						k = k + 2;
					} else if (isConst(strings[i])) {       //if constant than skip
						resultWord = chars;
						break;
					} else {
						resultWord[k] = c;
						k++;
					}
				} else {
					resultWord[k] = c;
					k++;
				}
			}
			strings[i] = new String(resultWord);
		}

		return strings;
	}

	private static int getNumberOfReplaces(String word){

		int counter = 0;
		char[] chars = word.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];

			if (isUpperCase(c)) {
				if (i != 0) {
					counter++;
				} else if (isConst(word)) {
					break;
				}
			}
		}

		return counter;
	}

	private static boolean isConst(String str) {        //define that the variable is not a constant

		int counter = 0;
		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			if (isUpperCase(chars[i])) {
				counter++;
			}
		}

		return counter == str.length();
	}

	private static boolean isUpperCase(char c) {

		char[] alphabet = {'A', 'B', 'C', 'D', 'D', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for (char upCaseChar : alphabet) {
			if (c == upCaseChar) {
				return true;
			}
		}
		return false;
	}

	private static char toLowerCase(char c) {

		return (char) (c ^ 0x20);
	}

	private static void printArray(String[] strings) {

		for (String s : strings) {
			System.out.print(s + " ");
		}

	}
}
