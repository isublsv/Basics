package by.epam.code_review.module3.str_array.task02;

/**
 * 2. Замените в строке все вхождения 'word' на 'letter'.
 */
public class Task {

	public static void main(String[] args) {

		String testString = "This word is not a word because people in the world don't worry of this word.";
		//String testString = "word word wordword.";

		//Output (ignore case):
		//This letter is not a letter because people in the world don't worry of this letter.

		System.out.println("Given string:\n" + testString);

		String what = "word";
		String to = "letter";


		String resultString = swapSequenceTo(testString, what, to);

		System.out.println("Result string after replacement:\n" + resultString);
	}

	private static String swapSequenceTo(String testString, String what, String to) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		char[] testStringChars = testString.toCharArray();
		char[] fromChars = what.toCharArray();
		char[] toChars = to.toCharArray();

		//the counter gives the number of replaces in the string
		int numberOfReplaces = getNumberOfReplaces(testStringChars, fromChars);

		//array for result string with new length
		int diff = toChars.length - fromChars.length;
		char[] result = new char[testString.length() + numberOfReplaces * diff];

		//index for the result array
		int resIndex = 0;

		for (int i = 0; i < testStringChars.length; i++) {
			//if the first and the last letters of the word what we want to replace are equals the current
			//and i + (fromChars.length - 1)) letters of the test string
			int last = i + (fromChars.length - 1);
			if (testStringChars[i] == fromChars[0] &&
					testStringChars[last] == fromChars[fromChars.length - 1]) {
				//if it's a full coincidence
				if (isSequenceFound(testStringChars, i, fromChars)) {
					//add the new word what we want to get to the result array and get a new start position
					resIndex = replaceSequence(result, resIndex, toChars);
					//change current position in the given test string
					i += fromChars.length - 1;
				} else {
					//add a current letter to the new result array
					result[resIndex++] = testStringChars[i];
				}
			}else {
				//same
				result[resIndex++] = testStringChars[i];
			}
		}

		//save the result array of chars to the string
		return new String(result);
	}

	private static int getNumberOfReplaces(char[] testStringChars, char[] fromChars) {

		int numberOfReplaces = 0;

		for (int i = 0; i < testStringChars.length; i++) {
			if (testStringChars[i] == fromChars[0]){
				if (isSequenceFound(testStringChars, i, fromChars)){
					numberOfReplaces++;
				}
			}
		}

		return numberOfReplaces;
	}

	private static int replaceSequence(char[] result,int startPos, char[] toChars) {

		int i = startPos;
		for (int j = 0; j < toChars.length; j++) {
			result[i++] = toChars[j];
		}

		return i;
	}

	private static boolean isSequenceFound(char[] givenChars, int startPos, char[] fromChars) {

		for (int i = 0; i < fromChars.length; i++) {
			if (fromChars[i] != givenChars[startPos++]) {
				return false;
			}
		}
		return true;
	}
}
