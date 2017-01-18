package com.gardenguava.myuno.logic.base;

import java.util.ArrayList;

import com.gardenguava.myuno.logic.type.Color;
import com.gardenguava.myuno.logic.utils.Configuration;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class Player {
	private int id;
	private String firstName;
	private String lastName;
	private String nickName;
	private int score;
	private ArrayList<Card> cardsHolding = new ArrayList<Card>();
	private boolean isActor;
	private Deck deck;

	public Player() {

	}

	public Player(Deck deck) {
		this.deck = deck;
		this.id = deck.getNextPlayerIndex();
		if(this.id == 1) {
			this.isActor = true;
		} else {
			this.isActor = false;
		}
		this.score = 0;
		for (int i = 0; i < Configuration.getInitialCardsForPlayer(); i++) {
			cardsHolding.add(deck.drawCard());
		}
	}

	public void drawCard() {
		cardsHolding.add(deck.drawCard());
	}

	public void throwCard(Card cardChoosenToThrow) {
		int index = cardsHolding.indexOf(cardChoosenToThrow);
		Card currentCard = cardsHolding.remove(index);
		deck.setCurrentCard(currentCard);
	}

	public ArrayList<Card> getEligibleCards(Color choosenColor) {
		Card currentCard = deck.getCurrentCard();
		ArrayList<Card> eligibleCards = new ArrayList<Card>();
		for (Card card : this.cardsHolding) {
			if (currentCard.isMatch(card, choosenColor)) {
				eligibleCards.add(card);
			}
		}
		return eligibleCards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Card> getCardsHolding() {
		return cardsHolding;
	}

	public void setCardsHolding(ArrayList<Card> cardsHolding) {
		this.cardsHolding = cardsHolding;
	}

	public boolean isActor() {
		return isActor;
	}

	public void setActor(boolean isActor) {
		this.isActor = isActor;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
		this.id = deck.getNextPlayerIndex();
		this.score = 0;
		for (int i = 0; i < Configuration.getInitialCardsForPlayer(); i++) {
			cardsHolding.add(deck.drawCard());
		}
		if(this.id == 1) {
			this.isActor = true;
		} else {
			this.isActor = false;
		}
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName
		    + ", score=" + score + ", cardsHolding=" + cardsHolding + ", isActor=" + isActor + ", deck=" + deck + "]";
	}

}
