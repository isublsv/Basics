package by.epam.code_review.module3.str_array.task04;

/**
 * 4. В строке найти количество чисел.
 */

public class Task {


	public static void main(String[] args) {

		//String testString = "For example, 3.14 = 03.14 = 003.14. 22 123.23";
		String testString = "";

		int number = getNumberOfNumbers(testString);

		System.out.println("The number of digits in the string = " + number);
	}

	private static int getNumberOfNumbers(String testString) {

		int counter = 0;

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return counter;
		}

		boolean isNumber = false;       //signals that the number is found

		char[] chars = testString.toCharArray();

		for (int i = 0; i < chars.length - 1; i++) {
			//if current char is digit and the next char is '.' or digit
			if (isDigit(chars[i]) && isDigit(chars[i + 1])) {
				if (!isNumber) {
					counter++;
					isNumber = true;
				}
			} else {
				isNumber = false;
			}
		}

		return counter;
	}

	private static boolean isDigit(char c) {
		for (int i = '0'; i < '9'; i++) {
			//'.' is for the decimal numbers
			if (c == i || c == '.') {
				return true;
			}
		}
		return false;
	}
}
