package by.etc.code_review.str_array.task05;

/**
 * 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы. Крайние
 * пробелы удалить.
 */

public class Task {

	public static void main(String[] args) {

		String testString = "   For example,    this is    a test   string!    \n Ha ha!      ";

		System.out.println("The given string:\n" + testString);

		System.out.println("The result string:");

		String s = trim(testString);

		System.out.println(removeAllExtraSpaces(s));
	}

	private static String removeAllExtraSpaces(String str) {

		if (str.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		int resultLength = getNewLength(str);
		char[] result = new char[resultLength];

		//index for the result array
		int idxRes = 0;

		char[] strChars = str.toCharArray();

		for (int i = 0; i < strChars.length; i++) {
			int next = i + 1;

			//if we found two adjacent spaces
			if (strChars[i] <= ' ' && strChars[next] <= ' ') {
				//move index i to the next position
				while (strChars[next] <= ' ') {
					next++;
				}
				//add one space to the result array
				result[idxRes++] = ' ';
				i = next - 1;
			} else {
				//add the current char to the result array
				result[idxRes++] = strChars[i];
			}
		}

		return new String(result);
	}

	private static int getNewLength(String str) {

		int resultLength = str.length();
		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			int next = i + 1;
			//reduce the length of the result array if there are two adjacent spaces
			if (chars[i] <= ' ' && chars[next] <= ' ') {
				resultLength--;
			}
		}

		return resultLength;
	}

	private static String trim(String s) {
		int length = s.length();
		int start = 0;
		char[] val = s.toCharArray();

		while ((start < length) && (val[start] <= ' ')) {
			start++;
		}
		while ((start < length) && (val[length - 1] <= ' ')) {
			length--;
		}

		char[] result;
		if ((start > 0) || (length < s.length())) {
			result = new char[length - start];
			for (int i = 0; i < result.length; i++) {
				result[i] = val[start++];
			}
		} else {
			result = val;
		}

		return new String(result);
	}
}
