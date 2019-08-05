package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackJackHand extends AbstractHand {

	private static final int BLACKJACK = 21;
	private boolean isBlackJack;
	private boolean isBust;

	public boolean isBlackJack() {
		if (this.getHandValue() == BLACKJACK) {
			isBlackJack = true;
		} else {
			isBlackJack = false;
		}
		return isBlackJack;
	}

	public boolean isBust() {
		if (this.getHandValue() > BLACKJACK) {
			isBust = true;
		} else {
			isBust = false;
		}
		return isBust;
	}

	public static int getBlackjack() {
		return BLACKJACK;
	}

	@Override
	public void clearHand() {
		// TODO Auto-generated method stub
		super.clearHand();
	}

	public BlackJackHand() {

	}

	public void Hit(Deck deck) {
		deck.dealCard();
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
		}
		return handValue;
	}
}
