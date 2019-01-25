package com.adapter;

// CLIENT: a Japanese person who needs to deliver a message to a Russian person.
public class JapanesePerson {
	public static void main(String args[]) {
		RussianPerson russianPerson = new RussianPerson();
		Translator translator = new Translator(russianPerson);
		String words = "These are some words in japanese : ";
		String russianWords = translator.translate(translator.readWords(words));
		russianPerson.readWords(russianWords);
	}
}
