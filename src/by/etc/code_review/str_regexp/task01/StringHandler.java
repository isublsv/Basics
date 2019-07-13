package by.etc.code_review.str_regexp.task01;

import java.util.regex.Pattern;

public class StringHandler {

	public String sortTokens(String testString, String c) {

		if (testString.isEmpty()) {
			System.out.println("The String is empty!");
			return "";
		}

		String wordRegexp = "[\\W]+";

		String[] words = Pattern.compile(wordRegexp).split(testString);

		String[] result = sortByAlphabet(words);
		char symbol = c.charAt(0);

		int i = 0;
		while (i < result.length - 1) {
			int count = getNumberOfChars(result[i], symbol);
			int countNext = getNumberOfChars(result[i + 1], symbol);
			i = sortArr(result, i, count, countNext);
		}

		return printWords(words);
	}

	private int getNumberOfChars(String s, char symbol){
		int counter = 0;

		for (char c : s.toCharArray()){
			if (Character.toLowerCase(c) == Character.toLowerCase(symbol)){
				counter++;
			}
		}

		return counter;
	}

	public String sortSentencesByWordLength(String testString) {

		if (testString.isEmpty()) {
			System.out.println("The String is empty!");
			return "";
		}

		String sentencesRegexp = "(?<=[a-z\\d][?.!]\\s)";

		String[] sentences = Pattern.compile(sentencesRegexp, Pattern.MULTILINE).split(testString);

		for (int i = 0; i < sentences.length; i++) {
			String[] words = Pattern.compile("[\\W]+").split(sentences[i]);

			int j = 0;
			while (j < words.length - 1) {
				int max = words[j].length();
				int currentLength = words[j + 1].length();
				j = sortArr(words, j, max, currentLength);
			}
			sentences[i] = printWords(words);
		}

		return printWords(sentences);
	}


	public String sortParagraphsBySentenceNumber(String testString) {

		if (testString.isEmpty()) {
			System.out.println("The String is empty!");
			return "";
		}

		String paragraphRegexp = "(?=^\\s)";             //(?sm)^.*?[.!?]$ to find paragraphs
		String sentencesSplit = "\\s+[^\".!?]*[.!?]";            //\s+[^.!?]*[.!?] to find sentences

		String[] paragraphs = Pattern.compile(paragraphRegexp, Pattern.MULTILINE).split(testString);

		int i = 0;
		while (i < paragraphs.length - 1) {
			int count = Pattern.compile(sentencesSplit).split(paragraphs[i]).length;
			int countNext = Pattern.compile(sentencesSplit).split(paragraphs[i + 1]).length;
			i = sortArr(paragraphs, i, count, countNext);
		}

		return printParagraphs(paragraphs);
	}

	//insertion sort
	private String[] sortByAlphabet(String[] strings) {
		for (int i = 1; i < strings.length; i++) {
			String key = strings[i];
			int j = i;
			while (j > 0 && strings[j - 1].compareToIgnoreCase(key) >= 0){
				strings[j] = strings[j - 1];
				--j;
			}
			strings[j] = key;
		}

		return strings;
	}

	//Shell sort
	private int sortArr(String[] arr, int i, int max, int current) {
		if (current >= max) {
			i++;
		} else {
			String temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;

			if (i > 1) {
				i--;
			} else {
				i = 0;
			}
		}
		return i;
	}

	private String printWords(String[] strings) {
		StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(s).append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}


	private String printParagraphs(String[] strings) {
		StringBuilder sb = new StringBuilder();
		for (String p : strings) {
			sb.append(p.trim()).append("\n");
		}

		return sb.toString();
	}
}
