package com.adapter;

import java.util.stream.IntStream;

// ADAPTEE : a Russian person who receives words from translator.
public class RussianPerson {
	public void readWords(String russianWords) {
		System.out.println("Retrieving Japanese words from from Translator...");
		System.out.println(russianWords);
	}
}
