/**
 * 
 */
package com.gardenguava.myuno.logic.base;

import java.util.ArrayList;

import com.gardenguava.myuno.logic.type.Color;
import com.gardenguava.myuno.logic.type.Rank;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class DeckDefinition {
	private static int cardIndex=1;
	private static class DeckCardDefinition {		
		private Color colors[];
		private Rank rank;
		private int count;

		DeckCardDefinition(Color[] colors, Rank rank, int count) {
			this.colors = colors;
			this.rank = rank;
			this.count = count;
		}
		
		public ArrayList<Card> generateCards() {
			ArrayList<Card> cardsList = new ArrayList<Card>();
			for(Color color : this.colors) {
				for(int index=0; index<count; index++) {
					cardsList.add(new Card(color, this.rank, cardIndex++));
				}
			}
			return cardsList;
		}
	};

	private static final Color STANDARD_COLORS[] = {Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW};
	private static final Color WILD_COLOR[] = {Color.WILD};		
	
	private static final DeckCardDefinition definitions[] = {
			new DeckCardDefinition(STANDARD_COLORS, Rank.ZERO, 1),
			new DeckCardDefinition(STANDARD_COLORS, Rank.ONE, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.TWO, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.THREE, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.FOUR, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.FIVE, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.SIX, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.SEVEN, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.EIGHT, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.NINE, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.SKIP, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.REVERSE, 2),
			new DeckCardDefinition(STANDARD_COLORS, Rank.DRAW_TWO, 2),
			new DeckCardDefinition(WILD_COLOR, Rank.WILD, 4),
			new DeckCardDefinition(WILD_COLOR, Rank.WILD_DRAW_FOUR, 4)
	};
	
	public static Card[] initializeCardsDeck() {
		ArrayList<Card> cardsList = new ArrayList<Card>();
		for(DeckCardDefinition cardDefinition : definitions) {
			cardsList.addAll(cardDefinition.generateCards());
		}
		return cardsList.toArray(new Card[cardsList.size()]);
	}
}
