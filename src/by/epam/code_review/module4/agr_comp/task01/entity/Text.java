package by.epam.code_review.module4.agr_comp.task01.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {

	private Sentence header;
	private List<Sentence> sentences;

	public Text(Sentence header) {
		this.header = header;
		this.sentences = new ArrayList<>();
	}

	public Sentence getHeader() {
		return header;
	}

	public void setHeader(Sentence header) {
		this.header = header;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	public boolean addSentence(Sentence sentence){
		return sentences.add(sentence);
	}

	public boolean removeSentence(Sentence sentence){
		return sentences.remove(sentence);
	}

	public void printText(){
		header.printSentence();
		System.out.println();

		for (Sentence sentence : sentences){
			sentence.printSentence();
		}
	}
}
