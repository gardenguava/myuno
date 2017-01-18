/**
 * 
 */
package com.gardenguava.myuno.logic.rule;

import com.gardenguava.myuno.logic.GameLogic;
import com.gardenguava.myuno.logic.base.Card;
import com.gardenguava.myuno.logic.base.Player;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class ActionRuleRankCard extends AbstractActionRule {

	private int ruleOrder = 1;

	/*
	 * Go to next player
	 */
	public Player takeAction(Card currentCard, GameLogic logic) {
		return logic.getNextPlayer();
	}

	/**
	 * @return the ruleOrder
	 */
	public int getRuleOrder() {
		return ruleOrder;
	}

	/**
	 * @param ruleOrder
	 *          the ruleOrder to set
	 */
	public void setRuleOrder(int ruleOrder) {
		this.ruleOrder = ruleOrder;
	}

	@Override
	public boolean isMatchToAction(Card currentCard, GameLogic logic) {
		if (currentCard.isRankCard()) {
			return true;
		}
		return false;
	}

}
