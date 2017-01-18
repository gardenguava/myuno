package com.gardenguava.myuno.logic.main;

import com.gardenguava.myuno.logic.GameLogic;
import com.gardenguava.myuno.logic.base.Card;
import com.gardenguava.myuno.logic.base.Deck;
import com.gardenguava.myuno.logic.base.DeckDefinition;
import com.gardenguava.myuno.logic.base.Player;

public class TestLogic {
	public static void main(String[] args) {
		for (int i = 0; i < 1; i++)
			TestLogic.testActions();
	}

	public static void testActions() {
		GameLogic logic = new GameLogic();
		for (int i = 0; i < 4; i++) {
			logic.addPlayer(new Player());
		}
		
		Card selectedCard = null;
		System.out.println("Starting Card: " + logic.getCurrentDeck().getCurrentCard());

		for (int i = 0; i < 18; i++) {
			logic.throwCard(selectedCard);
			showInformation(logic);
		}
	}

	public static void showInformation(GameLogic logic) {
		for (Player player : logic.getPlayersList()) {
			System.out.print("P" + player.getId() + "\t");
		}
		System.out.print("CP" + "\t");
		System.out.print("Card" + "\t\t\t\t\t\t\t");
		System.out.println();
		for (Player player : logic.getPlayersList()) {
			System.out.print(player.getCardsHolding().size() + "\t");
		}
		System.out.print("P" + logic.getCurrentPlayer().getId() + "\t");
		System.out.print(logic.getCurrentDeck().getCurrentCard());
		System.out.println();
	}

	public static void showPlayers() {
		GameLogic logic = new GameLogic();
		logic.changeDirection();
		for (int i = 0; i < 3; i++) {
			logic.addPlayer(new Player());
		}
		for (int i = 0; i < 6; i++) {
			Player player = logic.getNextPlayer();
			System.out.println(player);
		}
	}

	public static void showPlayer() {
		Deck deck = Deck.getCurrentDeck();
		Player player = new Player(deck);
		Card currentCard = deck.getCurrentCard();
		System.out.println("Card drawn: " + currentCard);
		System.out.println("Cards Holding: " + player.getCardsHolding());
		System.out.println("Eligible Cards: " + player.getEligibleCards(null));
	}

	public static void showCurrentDeck() {
		Deck deck = Deck.getCurrentDeck();
		for (int i = 0; i < 119; i++) {
			Card card = deck.drawCard();
			System.out.println(card);
			System.out.println("Current Deck Size:" + deck.getCurrentDeckSize());
		}
	}

	public static void showDefaultDeck() {
		Card cards[] = DeckDefinition.initializeCardsDeck();

		for (Card card : cards) {
			System.out.println(card);
		}

		System.out.println("Total Cards:" + cards.length);
	}
}
