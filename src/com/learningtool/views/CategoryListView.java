package com.learningtool.views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CategoryListView extends JPanel{
	private String[] categories;
	private JList<String> categoryList;
	
	public CategoryListView(String[] categories) {
		this.categories = categories;
		this.categoryList = new JList<>(categories);
		this.categoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.categoryList.setLayoutOrientation(JList.VERTICAL);
		
		this.add(new JScrollPane(this.categoryList));
		setVisible(true);
	}
}
