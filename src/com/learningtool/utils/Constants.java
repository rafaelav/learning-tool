package com.learningtool.utils;

import java.util.HashSet;

public class Constants {
	private static Constants instance = null;
	private HashSet<String> categories;

	protected Constants() {
		// defeat instantiation
	}

	public static Constants getInstance() {
		if (instance == null) {
			instance = new Constants();
		}
		return instance;
	}
	
	public void addCategory(String category){
		categories.add(category);
	}
	
	public void removeCategory(String category){
		categories.remove(category);
	}
}
