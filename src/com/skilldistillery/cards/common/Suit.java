package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts", "/U2665"), SPADES("Spades", "/U2660"), CLUBS("Clubs", "/U2663"), DIAMONDS("Diamonds", "/U2666");
	private final String name;
	private String icon;

	private Suit(String _name, String _symbol) {
		this.name = _name;
	}

	@Override
	public String toString() {
		return this.name;

	}

}

//public enum Suit {
//
//    SPADES("\u2660\uFE0F"), HEARTS("\u2665\uFE0F"), DIAMONDS("\u2666\uFE0F"), CLUBS("\u2663\uFE0F");
//
//    private final String icon;
//
//    Suit(String icon) {
//        this.icon = icon;
//    }
//
//    public String toString() {
//        return this.icon;
//    }
//}