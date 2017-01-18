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
public class ActionRuleWild extends AbstractActionRule {

	private int ruleOrder = 5;
	
	/*
	 * Set color choosen by player
	 */
	public Player takeAction(Card currentCard, GameLogic logic) {
		return logic.getNextPlayer();
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
		if(currentCard.getRank() == Rank.WILD) {
			return true;
		}
		return false;
	}
}
