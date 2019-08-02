package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts", "/U2665"), SPADES("Spades", "/U2660"), CLUBS("Clubs", "/U2663"), DIAMONDS("Diamonds", "/U2666");
	private final String name;
	private String symbol;
	
	private Suit(String _name, String _symbol) {
		this.name = _name;
		this.symbol = _symbol;
	}
	
	@Override
	public String toString() {
		return this.name;
		
	}
	
//	public Suit[] getName() {
//		return Suit.values(); Hearts /U2665
//	}

}
