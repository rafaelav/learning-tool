package com.learningtool.views;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.learningtool.adaptors.CategoryListAdaptor;
import com.learningtool.objects.Card;

public class CategoryListView extends JPanel {
	private Hashtable<String, ArrayList<Card>> categoriesTable;
	//private JList<String> categoryList;
	private CategoryListAdaptor categoryAdaptor;
	private JList<String> categoryList;
	private ArrayList<Card> selectedCardList;
	private int indexSelectedCategory;

	public CategoryListView(Hashtable<String, ArrayList<Card>> categoriesTable, int indexSelectedCategory) {
		this.categoriesTable = categoriesTable;
		this.indexSelectedCategory = indexSelectedCategory;
		this.categoryAdaptor = new CategoryListAdaptor(categoriesTable);
//		String [] categoriesStrings = new String[categories.size()];
//		Iterator<String> itr = categoriesSet.iterator();
//		int crt = 0;
//		while(itr.hasNext()){
//			categoriesStrings[crt++] = itr.next();
//		}
//		this.categoryList = new JList<>(categoriesStrings);
		this.categoryList = new JList<>(categoryAdaptor);
		this.categoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.categoryList.setLayoutOrientation(JList.VERTICAL);
		this.categoryList.setSelectedIndex(indexSelectedCategory);
		this.selectedCardList = categoryAdaptor.getSelectedList(indexSelectedCategory);
		
		this.add(new JScrollPane(this.categoryList));
		setVisible(true);
	}

	/*
	 * Returns the list of cards attributed to the selected category
	 */
	public ArrayList<Card> getSelectedCardList() {
		return selectedCardList;
	}
	
	/* 
	 * Updates the index of the selected element in JList
	 */
	public void updateSelectedCategoryIndex(int newIndex) {
		this.indexSelectedCategory = newIndex;
	}
	/*
	 * Updates the list of cards attributed to the selected category
	 */
	public void updateSelectedCardList() {
		this.selectedCardList = categoryAdaptor.getSelectedList(indexSelectedCategory);
	}

	/*
	 * Returns the JList with categories
	 */
	public JList<String> getCategoryList() {
		return categoryList;
	}
	
}
