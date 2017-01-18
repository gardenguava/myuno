/**
 * 
 */
package com.gardenguava.myuno.logic.base;

import com.gardenguava.myuno.logic.type.CardType;
import com.gardenguava.myuno.logic.type.Color;
import com.gardenguava.myuno.logic.type.Rank;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public final class Card {
	private int id;
	private Color color;
	private Rank rank;
	
	public Card(Color color, Rank rank) {
		this.color = color;
		this.rank = rank;
	}
	
	public Card(Color color, Rank rank, int id) {
		this.color = color;
		this.rank = rank;
		this.id = id;
	}
	
	public boolean isMatch(Card card, Color choosenColor) {
		if(choosenColor == null) {
			if((this.rank.getValue() == card.getRank().getValue()) || (this.color == card.getColor())) {
				return true;
			}
		} else {
			if((this.rank.getValue() == card.getRank().getValue()) || (this.color == choosenColor)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isRankCard() {
		return (this.rank.getType() == CardType.RANK);
	}
	
	public boolean isActionCard() {
		return (this.rank.getType() == CardType.ACTION);
	}
	
	public boolean isWildCard() {
		return (this.rank.getType() == CardType.WILD);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", color=" + color + ", rank=[" + rank + ", type=" + rank.getType() + "]]";
	}

}
