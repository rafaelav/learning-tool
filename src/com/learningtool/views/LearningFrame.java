package com.learningtool.views;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.learningtool.objects.Card;

public class LearningFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton deleteCard;
	private JButton editCard;
	private JButton prev;
	private JButton next;

	public LearningFrame(Hashtable<String, ArrayList<Card>> categoriesTable, int indexSelectedCategory) {
		// panel for delete and edit buttons
		JPanel cardSettingsPanel = new JPanel();
		deleteCard = new JButton("DELETE");
		editCard = new JButton("EDIT");
		cardSettingsPanel.add(editCard);
		cardSettingsPanel.add(deleteCard);

		// panel for Card and all the buttons
		JPanel cardPanel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(5);
		borderLayout.setVgap(5);
		cardPanel.setLayout(borderLayout);
		
		// prev button added
		prev = new JButton("PREV");
		cardPanel.add(prev, BorderLayout.LINE_START);
		
		// card space added
		CardView cardView = new CardView(categoriesTable.get("colors").get(0));
		cardPanel.add(cardView, BorderLayout.CENTER);
		
		// next button added
		next = new JButton("NEXT");
		cardPanel.add(next, BorderLayout.LINE_END);	
		
		// settings panel added
		cardPanel.add(cardSettingsPanel, BorderLayout.PAGE_END);
		

		// panel for all screen
		JPanel learningPanel = new JPanel();

		CategoryListView categoriesView = new CategoryListView(categoriesTable, indexSelectedCategory);		
		JSplitPane pane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, categoriesView, cardPanel);
		
		learningPanel.add(pane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(learningPanel);
		setVisible(true); // display this frame
		pack();


		setTitle("Training");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		// dummy data		
	
		Hashtable<String, ArrayList<Card>> categoriesTable = new Hashtable<>();
		categoriesTable.put("colors", new ArrayList<Card>());
		ArrayList<Card> value = categoriesTable.get("colors");
		value.add(new Card("blue", "cold color", "color"));
		value.add(new Card("green", "cold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o p", "color"));
		value.add(new Card("yellow", "warm color", "color"));
		value.add(new Card("red", "warm color", "color"));
		categoriesTable.put("pets", new ArrayList<Card>());
		value = categoriesTable.get("pets");
		value.add(new Card("dog", "has 4 legs", "pets"));
		value.add(new Card("cat", "has 4 legs", "pets"));
		value.add(new Card("parot", "has 2 legs", "pets"));	
		
		Enumeration<String> e = categoriesTable.keys();
		while(e.hasMoreElements()) {
			String stuff = e.nextElement();
			System.out.println(stuff);
			
		}
		LearningFrame lf = new LearningFrame(categoriesTable, 1);
		lf.setVisible(true);
	}
}
