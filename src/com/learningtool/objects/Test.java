package com.learningtool.objects;

import java.util.HashSet;

public class Test {
	private int noOfElements;
	private String category;
	private HashSet<Card> testCards;
	
	public Test(int noOfElements, String category) {
		this.noOfElements = noOfElements;
		this.category = category;
		
		// generating test cards based on category and number of cards
		generateTestCards();
	}
	
	private void generateTestCards() {
		
	}
}

