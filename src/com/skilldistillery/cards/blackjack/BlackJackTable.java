package com.skilldistillery.cards.blackjack;


import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackJackTable {
Scanner kb = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();
	Deck deck = new Deck();

	public void startHand() {
		deck.shuffle();
		dealer.dealHand(player);
		isBlackJack();
		playHand();

	}

	public void playHand() {
		System.out.println(("Player " + player.getHand()));
		System.out.println("Player hand value: " + player.getHand().getHandValue());
		System.out.println();
		System.out.println("Dealers Hand: " + dealer.getHand().getCards().get(0));
		System.out.println();
		isBlackJack();
		player.hitOrStay(deck);
		isBust();
		System.out.println("Player hand value: " + player.getHand().getHandValue());
		System.out.println();
		System.out.println("Dealer " + dealer.getHand());
		System.out.println("Dealers Hand: " + dealer.getHand().getHandValue());
		dealer.hitOrStay();
		isBlackJack();
		isBust();
		winningHand();
		System.out.println();

	}

	private void winningHand() {
		if (dealer.getHand().getHandValue()> 21 && player.getHand().getHandValue()<21) {
			System.out.println("Player Wins!");
			playAgain();
		}
		if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println("Player Wins!");
			playAgain();
		}
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("Dealer Wins!");
			playAgain();
		}
		if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("Push");
			playAgain();
		}
	}

	public boolean isBlackJack() {
		boolean blackjack = false;

			if (player.getHand().getHandValue() == 21 && dealer.getHand().getHandValue() == 21) {
				System.out.println("Push");
				playAgain();
				blackjack = true;
								return blackjack;
			}
			if ((player.getHand().getHandValue() == 21)) {
				System.out.println("Black Jack!!!, Player wins");
				blackjack = true;
				playAgain();
				return blackjack;
				}
			
			if (dealer.getHand().getHandValue() == 21) {
				System.out.println("Black Jack!!!, House wins");
				blackjack = true;
				playAgain();
				return blackjack;
			}
			return blackjack;
		}
	

	public boolean isBust() {
		boolean bust = false;
		if (dealer.getHand().getHandValue() > 21 ) {
			System.out.println("Dealer Bust! ");
			playAgain();
			bust = true;
		} 
		if (player.getHand().getHandValue() > 21) {
			System.out.println("Player Bust!");
			playAgain();
			bust = true;
		}
		else {
			bust = false;
		}
		return bust;
	}
	public void playAgain() {
		System.out.println("Do you want to play again? (Y/N");
		String yesNo = kb.next();
		if ((yesNo.equals("Y")) || (yesNo.equals("y"))) {
			player.getHand().clearHand();
			dealer.hand.clearHand();
			startHand();
		} else if ((yesNo.equals("N")) || (yesNo.equals("n"))) {
			System.out.println("Thank you for playing!");
			System.out.println("Exiting game...");
		} else {
			System.out.println("That is not a valid option");
			playAgain();
		}
	}

}
