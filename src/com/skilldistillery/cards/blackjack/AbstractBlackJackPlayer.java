package com.skilldistillery.cards.blackjack;

public abstract class AbstractBlackJackPlayer {
	BlackJackHand hand = new BlackJackHand();

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

	public abstract boolean hitOrStay();
}
