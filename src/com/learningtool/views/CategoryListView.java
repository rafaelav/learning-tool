package com.learningtool.views;

import java.util.Iterator;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CategoryListView extends JPanel {
	private Set<String> categories;
	private JList<String> categoryList;

	public CategoryListView(Set<String> categoriesSet, int indexSelectedCategory) {
		this.categories = categoriesSet;
		String [] categoriesStrings = new String[categories.size()];
		Iterator<String> itr = categoriesSet.iterator();
		int crt = 0;
		while(itr.hasNext()){
			categoriesStrings[crt++] = itr.next();
		}
		this.categoryList = new JList<>(categoriesStrings);
		this.categoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.categoryList.setLayoutOrientation(JList.VERTICAL);
		this.categoryList.setSelectedIndex(indexSelectedCategory);
		
		this.add(new JScrollPane(this.categoryList));
		setVisible(true);
	}
}
