package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class Dealer extends AbstractBlackJackPlayer {

	private int numCardsToDeal = 2;
	private Deck deck = new Deck();

	public void dealHand(Player player) {
		if (deck.checkDeckSize() < 20) {
			System.out.println("Shuffling Deck");
			deck = new Deck();
		}
		for (int i = 0; i < numCardsToDeal; i++) {
			// deal one card each
			player.getHand().addCard(deck.dealCard());
			this.getHand().addCard(deck.dealCard());
		}
	}

	@Override
	public boolean hitOrStay() {
		boolean hit = true;
		int cardIndex = 2;
		while (hit) {
//			if (this.getHand().getHandValue() == 21) {
//				System.out.println("Black Jack!!!, House wins");
//				break;
//			}
			while (this.getHand().getHandValue() < 17) {
				System.out.println("Dealer under 17, Must take another card: ");
				System.out.println();
				this.getHand().addCard(deck.dealCard());
				System.out.println("Dealer new card: " + this.getHand().getCards().get(cardIndex));
				this.setHand(hand);
				System.out.println("Dealer New  " + this.getHand());
				System.out.println("Dealer New Hand Total: " + this.getHand().getHandValue());
				System.out.println();
				cardIndex++;
				
			}
			if (this.getHand().getHandValue() == 21) {
				System.out.println("Black Jack!!!, House wins");
				System.out.println();
				break;
			}
			if (this.getHand().getHandValue() > 21) {

				hit = false;

			} else {
				System.out.println("Dealer Over 17, Must stay: ");
				System.out.println();
				hit = false;
			}
		}
		return hit;
	}
	public void dealerHandInfo() {
		System.out.println("Dealer " + this.getHand());
		System.out.println("Dealers Hand: " + this.getHand().getHandValue());
		System.out.println();
	}
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
