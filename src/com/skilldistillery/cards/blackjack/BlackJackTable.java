package com.skilldistillery.cards.blackjack;

import static java.lang.Thread.sleep;

import java.util.Scanner;

public class BlackJackTable {
	private Scanner kb = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public void playHand() {
//		System.out.println("There are " + dealer.getDeck().checkDeckSize() + " cards currently in the deck.\n"); //displays current count of the deck
		dealer.dealHand(player);
		player.playerHandInfo();
		dealer.pause();
		dealer.dealerUpCard();
		isBlackJackHand();
		if (player.getHand().isBlackJack()) {
			playAgain();
			return;
		}
		System.out.println();
		player.hitOrStay(dealer.getDeck(), kb);
		if (player.getHand().isBust()) {
			playAgain();
			return;
		}
		if (dealer.getHand().isBlackJack()) {
			playAgain();
			return;
		}
		player.playerHandInfo();
		dealer.dealerHandInfo();
		dealer.hitOrStay();
		winningHand();
		playAgain();
		return;
	}
	
	public void isBlackJackHand() {
		if (player.getHand().isBlackJack()) {
			System.out.println("BLACK JACK: PLAYER WINS!!!" + "\n");
			player.playerHandInfo();
			dealer.dealerHandInfo();
			playAgain();
			return;
		}
		if (dealer.getHand().isBlackJack()) {
			System.out.println("BLACK JACK: HOUSE WINS!!!" + "\n");
			dealer.dealerHandInfo();
			playAgain();
			return;
		}
		if (player.getHand().isBlackJack() && dealer.getHand().isBlackJack()) {
			System.out.println("Push" + "\n");
			dealer.dealerHandInfo();
			playAgain();
			return;
		}
	}
	private void winningHand() {
		if (dealer.getHand().isBust() && player.getHand().getHandValue() < 21) {
			System.out.println();
			System.out.println("Player Wins!");
			return;
		}
		if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();
			System.out.println("Player Wins!");
			return;
		}
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println();
			dealer.dealerHandInfo();
			player.playerHandInfo();
			System.out.println("Dealer Wins!");
			return;
		}
		if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println();
			player.playerHandInfo();
			dealer.dealerHandInfo();
			System.out.println("Push");
			return;
		}
	}

	public boolean playAgain() {
		dealer.pause();
		boolean play = true;
		while (play) {
			System.out.println();
			System.out.print("Do you want to play again? (Y/N)? " + "\n");
			String yesNo = kb.next();
			if (yesNo.equalsIgnoreCase("Y")) {
				player.getHand().clearHand();
				dealer.hand.clearHand();
				playHand();
				play = true;
				break;
			}
			if (yesNo.equalsIgnoreCase("N")) {
				System.out.println("Thank you for playing!");
				play = false;
				break;
			} else if ((!(yesNo.equalsIgnoreCase("Y") || (yesNo.equalsIgnoreCase("N"))))) {
				System.out.println("That is not a valid option");
				play = true;
			}
		}
		return false;
	}
}