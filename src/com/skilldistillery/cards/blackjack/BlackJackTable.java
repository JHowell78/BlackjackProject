package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackJackTable {
	Scanner kb = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();

	public void startHand() {
		System.out.println("There are " + dealer.getDeck().checkDeckSize() + " cards currently in the deck.");
		System.out.println();
		dealer.dealHand(player);
		isBlackJack();
		playHand();
	}

	public void playHand() {
//		System.out.println();
		player.playerHandInfo();
		System.out.println("Dealers Face Up Card: " + dealer.getHand().getCards().get(0));
		System.out.println();
		isBlackJack();
		player.hitOrStay(dealer.getDeck());
		isBust();
		player.playerHandInfo();
		dealer.dealerHandInfo();
		dealer.hitOrStay();
		isBlackJack();
		isBust();
		winningHand();
		System.out.println();
	}

	private void winningHand() {
		if (dealer.getHand().getHandValue() > 21 && player.getHand().getHandValue() < 21) {
			System.out.println("Player Wins!");
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();			
			playAgain();
		}
		if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println("Player Wins!");
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();
			playAgain();
		}
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("Dealer Wins!");
			System.out.println();
			dealer.dealerHandInfo();
			player.playerHandInfo();
			playAgain();
		}
		if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("Push");
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();
			playAgain();
		}
	}

	public boolean isBlackJack() {
		boolean blackjack = false;

		if (player.getHand().getHandValue() == 21 && dealer.getHand().getHandValue() == 21) {
			System.out.println("Push");
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();
			playAgain();
			blackjack = true;
			return blackjack;
		}
		if ((player.getHand().getHandValue() == 21)) {
			System.out.println("Black Jack!!!, Player wins");
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();
			blackjack = true;
			playAgain();
			return blackjack;
		}

		if (dealer.getHand().getHandValue() == 21) {
			System.out.println("Black Jack!!!, House wins");
			System.out.println();
			dealer.dealerHandInfo();
			player.playerHandInfo();
			blackjack = true;
			playAgain();
			return blackjack;
		}
		return blackjack;
	}

	public boolean isBust() {
		boolean bust = false;
		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("Dealer Bust! ");
			System.out.println();
			dealer.dealerHandInfo();
			player.playerHandInfo();
			playAgain();
			bust = true;
		}
		if (player.getHand().getHandValue() > 21) {
			System.out.println("Player Bust! House Wins!");
			System.out.println();
			dealer.dealerHandInfo();
			player.playerHandInfo();
			playAgain();
			bust = true;
		} else {
			bust = false;
		}
		return bust;
	}

	public void playAgain() {
		System.out.print("Do you want to play again? (Y/N)? ");
		String yesNo = kb.next();
		if ((yesNo.equals("Y")) || (yesNo.equals("y"))) {
			player.getHand().clearHand();
			dealer.hand.clearHand();
			startHand();
		}
		if ((yesNo.equals("N")) || (yesNo.equals("n"))) {
			System.out.println("Thank you for playing!");
			System.out.println("Exiting game...");
			return;
		} else {
			System.out.println("That is not a valid option");
			playAgain();
		}

	}
}
