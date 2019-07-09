package by.etc.code_review.str_builder.task03;

import java.util.Scanner;

/**
 * 3. Проверить, является ли заданное слово палиндромом.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the word:");
/*			String word = "refer";
			String word1 = "reddit";
			String word2 = "raceCar";
			String word3 = "abbat";*/

			String word = scanner.nextLine();

/*			System.out.println(word);
			System.out.println(word1);
			System.out.println(word2);
			System.out.println(word3);*/

			System.out.println("Is the word " + word + " palindrome: " + isPalindrome(word));
/*			System.out.println("Is the word " + word1 + " palindrome: " + isPalindrome(word1));
			System.out.println("Is the word " + word2 + " palindrome: " + isPalindrome(word2));
			System.out.println("Is the word " + word3 + " palindrome: " + isPalindrome(word3));*/
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static boolean isPalindrome(String word) {

		if (word.length() == 0){
			System.out.println("The given string is empty!");
			return false;
		}

		return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
	}
}
