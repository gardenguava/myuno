/**
 * 
 */
package com.gardenguava.myuno.logic.rule;

import java.util.ArrayList;

import com.gardenguava.myuno.logic.GameLogic;
import com.gardenguava.myuno.logic.base.Card;
import com.gardenguava.myuno.logic.base.Player;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class ActionRuleNoEligibleCards extends AbstractActionRule {

	@Override
	public Player takeAction(Card currentCard, GameLogic logic) {
		logic.getCurrentPlayer().drawCard();
		this.setIsSuccess(false);
		if(this.isMatchToAction(currentCard, logic)) {
			return logic.getNextPlayer();
		} else {
			ArrayList<Card> eligibleCards = logic.getCurrentPlayer().getEligibleCards(logic.getCurrentDeck().getChoosenColor());
			logic.getCurrentPlayer().throwCard(eligibleCards.get(0));
			return logic.getNextPlayer();
		}
	}

	@Override
	public boolean isMatchToAction(Card currentCard, GameLogic logic) {
		ArrayList<Card> eligibleCards = logic.getCurrentPlayer().getEligibleCards(logic.getCurrentDeck().getChoosenColor());
		if(eligibleCards.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getRuleOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRuleOrder(int ruleOrder) {
		// TODO Auto-generated method stub

	}

}
