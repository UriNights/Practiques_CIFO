package com.example.demo.utilities;

public class IOTools {

	public static int wordsInSentence(String sentence) {
		
		String[] words = sentence.split(" ");
		return words.length;		
	}
}
