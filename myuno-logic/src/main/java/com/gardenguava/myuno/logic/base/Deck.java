/**
 * 
 */
package com.gardenguava.myuno.logic.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.gardenguava.myuno.logic.type.Color;
import com.gardenguava.myuno.logic.type.Direction;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public final class Deck {
	private int id;
	private int playerIndex = 1;
	private Card currentCard;
	private ArrayList<Card> cardsList = new ArrayList<Card>(Arrays.asList(DeckDefinition.initializeCardsDeck()));
	private int currentDeckSize = cardsList.size();
	private static Deck deck=null;
	private Direction direction;
	private Random random = new Random();
	private Color choosenColor = null;

	private Deck() {
		
	}
	
	public static Deck getCurrentDeck() {
		if(deck == null) {
			deck = new Deck();
			deck.setCurrentCard(deck.drawCard());
			deck.setDirection(Direction.CLOCK_WISE);
		}
		return deck;
	}
	
	public Card drawCard() {
		if (isDeckEmpty()) {
			return null;
		}
		int nextInt = this.random.nextInt(getCurrentDeckSize());
		Card selectedCard = this.cardsList.remove(nextInt);		
		setCurrentDeckSize(this.cardsList.size());
		return selectedCard;
	}
	
	public boolean isDeckEmpty() {
		return (this.currentDeckSize == 0);
	}

	public ArrayList<Card> getCardsList() {
		return this.cardsList;
	}

	public int getNextPlayerIndex() {
		return this.playerIndex++;
	}
	
	public int getCurrentDeckSize() {
		return this.currentDeckSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Card getCurrentCard() {
		return currentCard;
	}

	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setCurrentDeckSize(int currentDeckSize) {
		this.currentDeckSize = currentDeckSize;
	}

	/**
	 * @return the choosenColor
	 */
	public Color getChoosenColor() {
		return choosenColor;
	}

	/**
	 * @param choosenColor the choosenColor to set
	 */
	public void setChoosenColor(Color choosenColor) {
		this.choosenColor = choosenColor;
	}	
}
