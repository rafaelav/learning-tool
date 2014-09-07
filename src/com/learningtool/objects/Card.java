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

	@Override
	public int hashCode() {
		//final int prime = 31;
		//int result = 1;
		//result = prime * result + ((notion == null) ? 0 : notion.hashCode());
		return notion.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (notion == null) {
			if (other.notion != null)
				return false;
		} else if (!notion.equals(other.notion))
			return false;
		return true;
	}	
}
