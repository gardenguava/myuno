package com.gardenguava.myuno.logic.type;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public enum Rank {
	ZERO(0, CardType.RANK), 
	ONE(1, CardType.RANK), 
	TWO(2, CardType.RANK), 
	THREE(3, CardType.RANK), 
	FOUR(4, CardType.RANK), 
	FIVE(5, CardType.RANK), 
	SIX(6, CardType.RANK), 
	SEVEN(7, CardType.RANK), 
	EIGHT(8, CardType.RANK), 
	NINE(9, CardType.RANK), 
	SKIP(10, CardType.ACTION), 
	DRAW_TWO(11, CardType.ACTION), 
	REVERSE(12, CardType.ACTION), 
	WILD(13, CardType.WILD), 
	WILD_DRAW_FOUR(14, CardType.WILD);

	private int value;
	private CardType type;

	Rank(int value, CardType type) {
		this.value = value;
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public CardType getType() {
		return type;
	}
		
}
