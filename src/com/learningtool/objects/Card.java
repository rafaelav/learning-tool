package com.learningtool.objects;

public class Card {
	private String notion;
	private String details;
	private String category;

	public Card(String notation, String details, String category) {
		this.notion = notation;
		this.details = details;
		this.category = category;
	}

	public String getNotion() {
		return notion;
	}

	public void setNotion(String notion) {
		this.notion = notion;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
