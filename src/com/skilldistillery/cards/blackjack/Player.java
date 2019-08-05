package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class Player extends AbstractBlackJackPlayer {
	private BlackJackHand hand = new BlackJackHand();

	public boolean hitOrStay(Deck deck, Scanner kb) {
		boolean hit = true;
		int cardDrawn = 2;

		while (hit) {
			int choice = 0;
			while (choice == 0) {
				System.out.print("Press 1 to hit or 2 to stay: " + "\n");
				try {
					choice = kb.nextInt();
				} catch (Exception e) {
					kb.nextLine();
				}
			}
			if (choice == 1) {
				this.getHand().addCard(deck.dealCard());
				System.out.println("Player Card Drawn: " + this.getHand().getCards().get(cardDrawn));
				System.out.println("Players Current " + this.getHand() + "\n" );
				System.out.println("Players Current Hand Total: " + this.getHand().getHandValue() + "\n");
				cardDrawn++;
				hit = true;
			}
			if (this.getHand().isBust()) {
				System.out.println("BUST!");
				System.out.println("House Wins!!!\n");
				hit = false;
			}
			if (choice == 2) {
				hit = false;
			}
		}
		return hit;
	}

	public void playerHandInfo() {
		System.out.println("Player " + this.getHand());
		System.out.println("Player Hand Value: " + this.getHand().getHandValue() + "\n");
	}
	@Override
	public boolean hitOrStay() {
		// TODO Auto-generated method stub
		return false;
	}
	public BlackJackHand getHand() {
		return hand;
	}
	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}
}