package com.learningtool.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.learningtool.objects.Card;

public class LearningFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public LearningFrame() {
		panel = new JPanel();
		// setBounds(200, 100, 1000, 500);
		//setSize(800, 500);

		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);

		// stuff
		// dummy data
		ArrayList<Card> cardList = new ArrayList<>();
		cardList.add(new Card("blue", "cold color", "color"));
		cardList.add(new Card("green", "cold color", "color"));
		cardList.add(new Card("yellow", "warm color", "color"));
		cardList.add(new Card("red", "warm color", "color"));

		String[] categories = new String[2];
		categories[0] = "colors";
		categories[1] = "pets";

		// categories list view
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.BOTH;
//		c.gridx = 0;
//		c.gridy = 0;
//		c.weightx = 1;
//		c.gridwidth = 5;
//		c.gridheight = 10;
		CategoryListView categoriesListView = new CategoryListView(categories);
		categoriesListView.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//		panel.add(categoriesListView, c);

		// card view
//		c = new GridBagConstraints();
//		c.fill = GridBagConstraints.BOTH;
//		c.gridx = 6;
//		c.weightx = 1;
//		c.gridy = 0;
//		c.gridwidth = 10;
//		c.gridheight = 10;

		CardView cardView = new CardView(cardList.get(1));
		cardView.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//		panel.add(cardView, c);
		JSplitPane pane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, categoriesListView, cardView);	
		panel.add(pane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(panel);
		setVisible(true); // display this frame
		pack();


		setTitle("Training");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		LearningFrame lf = new LearningFrame();
		lf.setVisible(true);
	}
}
