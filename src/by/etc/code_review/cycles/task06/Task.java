package by.etc.code_review.cycles.task06;


import java.util.Scanner;

/**
 * 6. Вывести на экран соответствия между символами и их численными обозначениями в памяти компьютера.
 */
public class Task {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)){

			System.out.println("Please, enter the string:");

			getCharValues(scanner.nextLine());
		}
	}

	private static void getCharValues(String s){

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);       //current character
			System.out.println(c + " = " + (int) c);
		}
	}
}
