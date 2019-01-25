package com.adapter;

// ADAPTER : takes Japanese message from client and convert it to Russian.
public class Translator implements JapaneseTarget {
	private RussianPerson russianPerson;

	public Translator(RussianPerson russianPerson) {
		this.russianPerson = russianPerson;
	}


	String translate(String japaneseWords) {
		System.out.println("Translating Japanese Words.........");
		japaneseWords = japaneseWords + "  arigatho gosaymas";
		System.out.println(japaneseWords);
		return japaneseWords;
	}

	@Override
	public String readWords(String words) {
		System.out.println("Reading Japanese Words.........");
		System.out.println(words);
		return words;
	}
}
