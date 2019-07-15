package by.etc.code_review.agr_comp.task01;

import by.etc.code_review.agr_comp.task01.entity.Sentence;
import by.etc.code_review.agr_comp.task01.entity.Text;
import by.etc.code_review.agr_comp.task01.entity.Word;

/**
 * 1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль
 * текст, заголовок текста.
 */

public class TextRunner {

	public static void main(String[] args) {

		Word word1 = new Word("Hello");
		Word word2 = new Word("World!");

		Sentence header = new Sentence();

		header.addWord(word1);
		header.addWord(word2);

		Text text = new Text(header);

		Word word3 = new Word("This");
		Word word4 = new Word("is");
		Word word5 = new Word("a");
		Word word6 = new Word("simple");
		Word word7 = new Word("text!");

		Sentence sentence2 = new Sentence();

		sentence2.addWord(word3);
		sentence2.addWord(word4);
		sentence2.addWord(word5);
		sentence2.addWord(word6);
		sentence2.addWord(word7);

		text.addSentence(sentence2);

		text.printText();

		sentence2.removeWord(word6);

		text.printText();

		text.removeSentence(sentence2);

		text.printText();

		text.getHeader().printSentence();
	}
}
