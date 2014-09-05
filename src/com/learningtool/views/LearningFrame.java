package com.learningtool.views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.learningtool.objects.Card;

public class LearningFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public LearningFrame() {
		//setBounds(200, 100, 1000, 500);
		// dummy data
		ArrayList<Card> cardList = new ArrayList<>();
		cardList.add(new Card("blue", "cold color", "color"));
		cardList.add(new Card("green", "cold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o p", "color"));
		cardList.add(new Card("yellow", "warm color", "color"));
		cardList.add(new Card("red", "warm color", "color"));

		String[] categories = new String[10];
		categories[0] = "colors";
		categories[1] = "pets";
		categories[2] = "flowers";
		categories[3] = "names";
		categories[4] = "wines";
		categories[5] = "beers";
		categories[6] = "sodas";
		categories[7] = "clothes";
		categories[8] = "danish";
		categories[9] = "stuff";
		
		// panel for delete and edit buttons
		JPanel cardSettingsPanel = new JPanel();
		JButton deleteCard = new JButton("DELETE");
		JButton editCard = new JButton("EDIT");
		cardSettingsPanel.add(editCard);
		cardSettingsPanel.add(deleteCard);

		// panel for Card and all the buttons
		JPanel cardPanel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(5);
		borderLayout.setVgap(5);
		cardPanel.setLayout(borderLayout);
		
		// prev button added
		JButton prev = new JButton("PREV");
		cardPanel.add(prev, BorderLayout.LINE_START);
		
		// card space added
		CardView cardView = new CardView(cardList.get(1));
		cardPanel.add(cardView, BorderLayout.CENTER);
		
		// next button added
		JButton next = new JButton("NEXT");
		cardPanel.add(next, BorderLayout.LINE_END);	
		
		// setting panel added
		cardPanel.add(cardSettingsPanel, BorderLayout.PAGE_END);
		

		// panel for all screen
		JPanel learningPanel = new JPanel();
		
		CategoryListView categoriesView = new CategoryListView(categories);		
		JSplitPane pane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, categoriesView, cardPanel);
		
		learningPanel.add(pane);
		
		
//		// setBounds(200, 100, 1000, 500);
//		//setSize(800, 500);
//
//		GridBagLayout gbl = new GridBagLayout();
//		
//		// categories list view
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.BOTH;
//		c.gridx = 0;
//		c.gridy = 0;
//		c.weightx = 1;
//		c.gridwidth = 5;
//		c.gridheight = 10;
//		CategoryListView categoriesListView = new CategoryListView(categories);
//		categoriesListView.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//		panel.add(categoriesListView, c);
//
//		// card view
//		c = new GridBagConstraints();
//		c.fill = GridBagConstraints.BOTH;
//		c.gridx = 6;
//		c.weightx = 1;
//		c.gridy = 0;
//		c.gridwidth = 10;
//		c.gridheight = 10;
//
//		CardView cardView = new CardView(cardList.get(1));
//		cardView.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//		panel.add(cardView, c);
//		panel.setLayout(gbl);
//		JSplitPane pane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, categoriesListView, cardView);	
//		panel.add(pane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(learningPanel);
		//add(panel);
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
