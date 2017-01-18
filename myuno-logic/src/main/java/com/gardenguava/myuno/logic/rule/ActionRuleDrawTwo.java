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
public class ActionRuleDrawTwo extends AbstractActionRule {
	private int ruleOrder = 3;

	public Player takeAction(Card currentCard, GameLogic logic) {
		Player newPlayer = logic.getNextPlayer();
		newPlayer.drawCard();
		newPlayer.drawCard();
		newPlayer = logic.getNextPlayer();
		return newPlayer;
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
		if (currentCard.getRank() == Rank.DRAW_TWO) {
			return true;
		}
		return false;
	}
}
