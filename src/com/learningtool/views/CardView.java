package com.learningtool.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.learningtool.objects.Card;

public class CardView extends JPanel{

	private JTextArea notionTextArea;
	private JTextArea detailsTextArea;
	private Card card;
	
	public CardView(Card card) {
		this.card = card;
		this.notionTextArea = new JTextArea();
		this.notionTextArea.setText(card.getNotion());
		this.detailsTextArea = new JTextArea();
		this.detailsTextArea.setText(card.getDetails());

		this.notionTextArea.setLineWrap(true);
		this.notionTextArea.setWrapStyleWord(true);
		this.notionTextArea.setEditable(false);
		this.notionTextArea.setToolTipText("Notion we're learning");
		this.notionTextArea.setBackground(new Color(99,184,255));

		this.detailsTextArea.setLineWrap(true);
		this.detailsTextArea.setWrapStyleWord(true);
		this.detailsTextArea.setEditable(false);
		this.detailsTextArea.setToolTipText("Details about the notion");
		
		this.add(this.notionTextArea);
		this.add(this.detailsTextArea);
		setLayout(new GridLayout(2, 1));
		setVisible(true);
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
		this.notionTextArea.setText(card.getNotion());
		this.detailsTextArea.setText(card.getDetails());
	}
}
