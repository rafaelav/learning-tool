package com.learningtool.objects;

public class Card {
	private StringBuffer notion;
	private StringBuffer details;
	private String category;

	public Card(StringBuffer notation, StringBuffer details, String category) {
		this.notion = notation;
		this.details = details;
	}

	public StringBuffer getNotion() {
		return notion;
	}

	public void setNotion(StringBuffer notion) {
		this.notion = notion;
	}

	public StringBuffer getDetails() {
		return details;
	}

	public void setDetails(StringBuffer details) {
		this.details = details;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
