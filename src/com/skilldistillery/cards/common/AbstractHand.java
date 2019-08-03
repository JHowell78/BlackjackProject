package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {
	protected List<Card> cards;

	public AbstractHand() {
		cards = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void clearHand() {
		cards.clear();
	}

	public abstract int getHandValue();

	public String toString() {
//		return cards.toString();
		return "Hand: " + cards + " ";
	}
	
}
