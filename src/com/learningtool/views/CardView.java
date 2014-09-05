package com.learningtool.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.learningtool.objects.Card;

public class CardView extends JPanel{

	private JTextArea notionTextArea;
	private JTextArea detailsTextArea;
	private Card card;
	
	public CardView(Card card) {
		this.card = card;
		this.notionTextArea = new JTextArea();
		this.notionTextArea.setText(card.getNotion());
		this.detailsTextArea = new JTextArea(5,12);
		this.detailsTextArea.setText(card.getDetails());
		JScrollPane auxScrollPane = new JScrollPane(this.detailsTextArea);
		auxScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		this.notionTextArea.setLineWrap(true);
		this.notionTextArea.setWrapStyleWord(true);
		this.notionTextArea.setEditable(false);
		this.notionTextArea.setToolTipText("Notion we're learning");
		this.notionTextArea.setBackground(new Color(99,184,255));

		this.detailsTextArea.setLineWrap(true);
		this.detailsTextArea.setWrapStyleWord(true);
		this.detailsTextArea.setEditable(false);
		this.detailsTextArea.setToolTipText("Details about the notion");
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		GridBagConstraints c1 = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		
		c1.fill = GridBagConstraints.BOTH;
		c1.gridx = 0;
		c1.gridy = 0;
		//c1.weighty = 0.3;
		c1.gridheight = 1;
		
		this.add(this.notionTextArea,c1);//

		c2.fill = GridBagConstraints.BOTH;
		c2.gridx = 0;
		c2.gridy = 1;
		//c2.weighty = 0.7;
		c2.gridheight = 5;

		this.add(auxScrollPane,c2); //
		
		setLayout(gbl);
		//setLayout(new GridLayout(2, 1));
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
