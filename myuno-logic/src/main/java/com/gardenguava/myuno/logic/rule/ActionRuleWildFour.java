/**
 * 
 */
package com.gardenguava.myuno.logic.rule;

import com.gardenguava.myuno.logic.GameLogic;
import com.gardenguava.myuno.logic.base.Card;
import com.gardenguava.myuno.logic.base.Player;
import com.gardenguava.myuno.logic.type.Rank;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class ActionRuleWildFour extends AbstractActionRule {

	private int ruleOrder = 6;
	
	/*
	 * Draw four cards then move to next player 
	 */
	public Player takeAction(Card currentCard, GameLogic logic) {
		Player player = logic.getNextPlayer();
		player.drawCard();
		player.drawCard();
		player.drawCard();
		player.drawCard();
		player = logic.getNextPlayer();
		return player;
	}

	@Override
	public int getRuleOrder() {
		return this.ruleOrder;
	}

	@Override
	public void setRuleOrder(int ruleOrder) {
		this.ruleOrder = ruleOrder;
	}

	@Override
	public boolean isMatchToAction(Card currentCard, GameLogic logic) {
		if(currentCard.getRank() == Rank.WILD_DRAW_FOUR) {
			return true;
		}
		return false;
	}
}
