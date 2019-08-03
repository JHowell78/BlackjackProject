package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Player extends AbstractBlackJackPlayer {
	private BlackJackHand hand = new BlackJackHand();
	Scanner kb = new Scanner(System.in);

	public boolean hitOrStay(Deck deck) {
		boolean hit = true;
		int cardIndex = 2;

		while (hit) {

			int choice = 0;
			while (choice == 0) {
				System.out.print("Press 1 to hit or 2 to stay: ");
				System.out.println();
				try {
					choice = kb.nextInt();
				} catch (Exception e) {
					kb.nextLine();
				}
			}
			if (choice == 1) {
				this.getHand().addCard(deck.dealCard());
//				System.out.println();
				System.out.println("Player New Card: " + this.getHand().getCards().get(cardIndex));
				System.out.println("Players New  " + this.getHand());
				System.out.println();
				System.out.println("Players New Hand Total: " + this.getHand().getHandValue());
				System.out.println();
				cardIndex++;
				hit = true;
			}
			if (this.getHand().getHandValue() == 21) {
//				System.out.println("Black Jack!!!, Player wins");
				break;
			}
			if (this.getHand().getHandValue() > 21) {
//				System.out.println("Over 21 Player Bust! ");
				break;
			}
			if (choice == 2) {
				hit = false;
			}
		}
		return hit;

	}

	public void playerHandInfo() {
		System.out.println("Player " + this.getHand());
		System.out.println("Player Hand: " + this.getHand().getHandValue());
		System.out.println();
	}

	@Override
	public boolean hitOrStay() {
		// TODO Auto-generated method stub
		return false;
	}

}
