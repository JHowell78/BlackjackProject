package com.skilldistillery.cards.blackjack;

public class BlackJackApp {
	BlackJackTable table = new BlackJackTable();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	private void run() {
		table.playHand();
	}

}
