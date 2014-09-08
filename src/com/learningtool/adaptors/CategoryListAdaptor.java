package com.learningtool.adaptors;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import javax.swing.AbstractListModel;

import com.learningtool.objects.Card;

public class CategoryListAdaptor extends AbstractListModel<String> {
	private Logger log = Logger.getLogger(this.getClass().getName());
	private Hashtable<String, ArrayList<Card>> categoriesTable;
	private String selectedCategory;

	public CategoryListAdaptor(
			Hashtable<String, ArrayList<Card>> categoriesTable) {
		super();
		this.categoriesTable = categoriesTable;
	}

	@Override
	public String getElementAt(int index) {
		Set<String> categoriesSet = categoriesTable.keySet();
		String[] categoriesStrings = new String[categoriesSet.size()];
		Iterator<String> itr = categoriesSet.iterator();
		int crt = 0;
		while (itr.hasNext()) {
			categoriesStrings[crt++] = itr.next();
		}

		log.finest("Strings before sorting ");
		for (int i = 0; i < categoriesStrings.length; i++)
			log.finest(categoriesStrings[i]);
		// sorting the array of strings to keep order
		for (int i = 0; i < categoriesStrings.length - 1; i++) {
			for (int j = i + 1; j < categoriesStrings.length; j++) {
				if (categoriesStrings[j].compareTo(categoriesStrings[i]) < 0) {
					String temp = categoriesStrings[i];
					categoriesStrings[i] = categoriesStrings[j];
					categoriesStrings[j] = temp;
				}
			}
		}
		log.finest("Strings after sorting ");
		for (int i = 0; i < categoriesStrings.length; i++)
			log.finest(categoriesStrings[i]);
		return categoriesStrings[index];
	}

	@Override
	public int getSize() {
		Set<String> categoriesSet = categoriesTable.keySet();
		return categoriesSet.size();
	}

	/*
	 * Returns the list of cards associated to the category at
	 * indexSelectedCategory in JList
	 */
	public ArrayList<Card> getSelectedList(int indexSelectedCategory) {
		return categoriesTable.get(getElementAt(indexSelectedCategory));
	}

}
