package com.skilldistillery.cards.blackjack;
import static java.lang.Thread.sleep;

import java.security.PublicKey;

import com.skilldistillery.cards.common.Deck;

public class Dealer extends AbstractBlackJackPlayer {

	private static final int DEALER_MIN_SCORE = 17;
	private int numCardsToDeal = 2;
	private Deck deck = new Deck();

	public void printDeck() {
		System.out.println(deck);
	}

	public void dealHand(Player player) {
		if (deck.checkDeckSize() < 26) {
			pause();
			System.out.println("***   SHUFFLING DECK   ***" + "\n");
			deck = new Deck();
		}
		for (int i = 0; i < numCardsToDeal; i++) {
			player.getHand().addCard(deck.dealCard());
			this.getHand().addCard(deck.dealCard());
		}
	}
	public void dealerUpCard() {
		System.out.println("Dealers Shows: " + this.getHand().getCards().get(0));
		System.out.println("Dealers Show Card Value: " +  this.getHand().getCards().get(0).getValue() + "\n");
	}
	@Override
	public boolean hitOrStay() {
		boolean hit = true;
		int cardDrawn = 2;
		while (hit) {
		while (this.getHand().getHandValue() < DEALER_MIN_SCORE) {
			pause();
			System.out.println("Dealer under 17, Must take another card: ");
			System.out.println();
			this.getHand().addCard(deck.dealCard());
			System.out.println("Dealer draws: " + this.getHand().getCards().get(cardDrawn));
			this.setHand(hand);
			System.out.println("Dealer " + this.getHand());
			System.out.println("Dealer Hand Total: " + this.getHand().getHandValue());
			System.out.println();
			cardDrawn++;
		}

		if (this.getHand().isBust()) {
			pause();
			System.out.println("BUST!");
			hit = false;
			break;
		} 
		  else {
            	System.out.println("Dealer Over 17, Must stay: ");
            	hit = false;
		}
	}
		return hit;
	}
	
	public void dealerHandInfo() {
		System.out.println("Dealer " + this.getHand());
		System.out.println("Dealers Hand: " + this.getHand().getHandValue()+"\n");
	}
	
	public void pause() {
		 try {
             sleep(2250);
         } catch (InterruptedException ex) {
         }
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public int getNumCardsToDeal() {
		return numCardsToDeal;
	}
	
	public void setNumCardsToDeal(int numCardsToDeal) {
		this.numCardsToDeal = numCardsToDeal;
	}
	
	public static int getDealerMinScore() {
		return DEALER_MIN_SCORE;
	}
}