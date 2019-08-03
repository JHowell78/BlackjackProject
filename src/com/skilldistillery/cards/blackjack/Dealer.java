package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class Dealer extends AbstractBlackJackPlayer {

	int numCardsToDeal = 2;
	Deck deck = new Deck();

	public void dealHand(Player player) {
		deck.shuffle();
		for (int i = 0; i < numCardsToDeal; i++) {
			// deal one card each
			player.getHand().addCard(deck.dealCard());
			this.getHand().addCard(deck.dealCard());
		}
	}
	@Override
	public boolean hitOrStay() {
		boolean hit = true;
		int cardIndex =2;
		while (hit) {
			if (this.getHand().getHandValue() ==21) {
				System.out.println("Black Jack!!!, House wins");
				
				hit=false;
			}
			while (this.getHand().getHandValue() < 17) {
				System.out.println("Dealer under 17, Must take another card: ");
				this.getHand().addCard(deck.dealCard());
				System.out.println("Dealer new card: " +this.getHand().getCards().get(cardIndex));
				this.setHand(hand);
				System.out.println("Dealer New  " + this.getHand());
				System.out.println("Dealer New Hand Total: " + this.getHand().getHandValue());
				cardIndex++;
			}
			if (this.getHand().getHandValue() > 21) {
//				System.out.println("Over 21 Dealer Bust! ");
				
				hit = false;

			} else {
				System.out.println("Dealer over 17, Must stay: ");
				hit = false;
			}
		}
		return hit;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
