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

	public CategoryListView(Hashtable<String, ArrayList<Card>> categoriesTable, int indexSelectedCategory) {
		this.categoriesTable = categoriesTable;
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
		
		this.add(new JScrollPane(this.categoryList));
		setVisible(true);
	}
}
