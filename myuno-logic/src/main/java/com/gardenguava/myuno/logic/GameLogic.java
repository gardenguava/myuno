/**
 * 
 */
package com.gardenguava.myuno.logic;

import java.util.ArrayList;
import java.util.Arrays;

import com.gardenguava.myuno.logic.base.Card;
import com.gardenguava.myuno.logic.base.Deck;
import com.gardenguava.myuno.logic.base.Player;
import com.gardenguava.myuno.logic.rule.ActionRule;
import com.gardenguava.myuno.logic.rule.ActionRuleDrawTwo;
import com.gardenguava.myuno.logic.rule.ActionRuleNoEligibleCards;
import com.gardenguava.myuno.logic.rule.ActionRuleRankCard;
import com.gardenguava.myuno.logic.rule.ActionRuleReverse;
import com.gardenguava.myuno.logic.rule.ActionRuleSkip;
import com.gardenguava.myuno.logic.rule.ActionRuleWild;
import com.gardenguava.myuno.logic.rule.ActionRuleWildFour;
import com.gardenguava.myuno.logic.type.Color;
import com.gardenguava.myuno.logic.type.Direction;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class GameLogic {
	private Deck deck = Deck.getCurrentDeck();
	private ArrayList<Player> playersList = new ArrayList<Player>();
	private Player currentPlayer = null;
	private boolean isRuleExecutionSuccess = true;

	private ArrayList<ActionRule> rules = new ArrayList<ActionRule>(
	    Arrays.asList(new ActionRuleNoEligibleCards(), new ActionRuleRankCard(), new ActionRuleDrawTwo(),
	        new ActionRuleSkip(), new ActionRuleReverse(), new ActionRuleWild(), new ActionRuleWildFour()));

	public GameLogic() {

	}

	public void addPlayer(Player player) {
		player.setDeck(deck);
		playersList.add(player);
		if (this.currentPlayer == null) {
			this.setCurrentPlayer(player);
		}
	}

	public void throwCard(Card cardChoosenToThrow) {
		Player currentPlayer = this.getCurrentPlayer();
		this.takeAction();
		if(this.isRuleExecutionSuccess) {
			currentPlayer.throwCard(cardChoosenToThrow);
		}
	}

	public void takeAction() {
		for (ActionRule rule : rules) {
			if (rule.isMatchToAction(deck.getCurrentCard(), this)) {
				Player player = rule.takeAction(deck.getCurrentCard(), this);
				this.setCurrentPlayer(player);
				this.isRuleExecutionSuccess = rule.getIsSuccess();
				return;
			}
		}
	}

	public Deck getCurrentDeck() {
		return this.deck;
	}

	public ArrayList<Player> getPlayersList() {
		return this.playersList;
	}

	public void setChoosenColor(Color choosenColor) {
		deck.setChoosenColor(choosenColor);
	}

	public void changeDirection() {
		if (deck.getDirection() == Direction.CLOCK_WISE) {
			deck.setDirection(Direction.ANTI_CLOCK_WISE);
		} else {
			deck.setDirection(Direction.CLOCK_WISE);
		}
	}

	public Player getNextPlayer() {
		int playersListSize = playersList.size();
		int currentPlayerIndex = 0;
		int nextPlayerIndex = 0;
		for (Player player : playersList) {
			if (player.isActor()) {
				currentPlayerIndex = player.getId() - 1;
				player.setActor(false);
			}
		}
		if (deck.getDirection() == Direction.CLOCK_WISE) {
			nextPlayerIndex = currentPlayerIndex + 1;
			if (nextPlayerIndex >= playersListSize) {
				nextPlayerIndex = 0;
			}
		} else {
			nextPlayerIndex = currentPlayerIndex - 1;
			if (nextPlayerIndex < 0) {
				nextPlayerIndex = playersListSize - 1;
			}
		}
		Player nextPlayer = playersList.get(nextPlayerIndex);
		nextPlayer.setActor(true);
		return nextPlayer;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		if (this.currentPlayer != null) {
			this.currentPlayer.setActor(false);
		}
		this.currentPlayer = currentPlayer;
		this.currentPlayer.setActor(true);
	}
}
