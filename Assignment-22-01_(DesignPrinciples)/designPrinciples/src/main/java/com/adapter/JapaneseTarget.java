package com.adapter;

// TARGET: a set Japanese words given by the client to the translator to be 
// translated to another language (Russian in this case) 
public interface JapaneseTarget {
	public String readWords(String words);
}
