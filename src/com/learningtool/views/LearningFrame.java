package com.learningtool.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.learningtool.objects.Card;

public class LearningFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton deleteCard;
	private JButton editCard;
	private JButton prev;
	private JButton next;
	private CategoryListView categoriesView;
	private JPanel cardPanel; // panel for card view
	private JPanel learningPanel; // panel for all screen
	private CardView cardView; // the card that is viewable in card view space
	private int crtSelectedCard; // index of first card displayed from category

	public void makeUpdatesToCardScreen(int updatedIndexOfCategoryList) {
		// update selected index in CategoryListView and visible list of cards
		// according to new selected category
		this.categoriesView
				.updateSelectedCategoryIndex(updatedIndexOfCategoryList);
		this.categoriesView.updateSelectedCardList();

		this.cardView.setCard(categoriesView.getSelectedCardList().get(0));
		this.crtSelectedCard = 0;
		this.cardPanel.updateUI();
	}

	public void updateCrtCardViewToNext() {
		int nextSelectedCard;
		if (this.crtSelectedCard + 1 == categoriesView.getSelectedCardList()
				.size()) {
			nextSelectedCard = 0;
		} else {
			nextSelectedCard = this.crtSelectedCard + 1;
		}
		this.crtSelectedCard = nextSelectedCard;
		this.cardView.setCard(categoriesView.getSelectedCardList().get(
				nextSelectedCard));
		this.cardPanel.updateUI();
	}

	public void updateCrtCardViewToPrev() {
		int nextSelectedCard;
		if (this.crtSelectedCard == 0) {
			nextSelectedCard = categoriesView.getSelectedCardList().size() - 1;
		} else {
			nextSelectedCard = this.crtSelectedCard - 1;
		}
		this.crtSelectedCard = nextSelectedCard;
		this.cardView.setCard(categoriesView.getSelectedCardList().get(
				nextSelectedCard));
		this.cardPanel.updateUI();
	}

	public LearningFrame(Hashtable<String, ArrayList<Card>> categoriesTable,
			int indexSelectedCategory, int crtSelectedCard) {
		this.crtSelectedCard = crtSelectedCard;
		// JList
		this.categoriesView = new CategoryListView(categoriesTable,
				indexSelectedCategory);
		JList<String> categoryList = categoriesView.getCategoryList();
		categoryList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				JList<String> triggeringObject = (JList<String>) e.getSource();
				// getting new index
				int newIndex = triggeringObject.getSelectedIndex();

				makeUpdatesToCardScreen(newIndex);
			}
		});

		// panel for delete and edit buttons
		JPanel cardSettingsPanel = new JPanel();
		deleteCard = new JButton("DELETE");
		editCard = new JButton("EDIT");
		cardSettingsPanel.add(editCard);
		cardSettingsPanel.add(deleteCard);

		// panel for Card and all the buttons
		cardPanel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(5);
		borderLayout.setVgap(5);
		cardPanel.setLayout(borderLayout);

		// prev button added
		prev = new JButton("PREV");
		cardPanel.add(prev, BorderLayout.LINE_START);
		prev.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				updateCrtCardViewToPrev();
			}
		});

		// card space added
		cardView = new CardView(categoriesView.getSelectedCardList().get(this.crtSelectedCard));
		cardPanel.add(cardView, BorderLayout.CENTER);

		// next button added
		next = new JButton("NEXT");
		cardPanel.add(next, BorderLayout.LINE_END);
		next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				updateCrtCardViewToNext();
			}
		});

		// settings panel added
		cardPanel.add(cardSettingsPanel, BorderLayout.PAGE_END);

		// panel for all screen
		learningPanel = new JPanel();
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				categoriesView, cardPanel);

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
		value.add(new Card(
				"green",
				"cold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o pcold color a b c c d e f g h j k l m n o p",
				"color"));
		value.add(new Card("yellow", "warm color", "color"));
		value.add(new Card("red", "warm color", "color"));
		categoriesTable.put("pets", new ArrayList<Card>());
		value = categoriesTable.get("pets");
		value.add(new Card("dog", "has 4 legs", "pets"));
		value.add(new Card("cat", "has 4 legs", "pets"));
		value.add(new Card("parot", "has 2 legs", "pets"));

		Enumeration<String> e = categoriesTable.keys();
		while (e.hasMoreElements()) {
			String stuff = e.nextElement();
			System.out.println(stuff);

		}
		LearningFrame lf = new LearningFrame(categoriesTable, 0, 0);
		lf.setVisible(true);
	}
}
