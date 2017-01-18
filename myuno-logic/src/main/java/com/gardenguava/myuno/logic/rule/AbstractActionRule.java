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
public abstract class AbstractActionRule implements ActionRule {
	private boolean isSuccess = true;
	
	public abstract Player takeAction(Card currentCard, GameLogic logic);
	
	public abstract int getRuleOrder();
	
	public abstract void setRuleOrder(int ruleOrder);

	public abstract boolean isMatchToAction(Card currentCard, GameLogic logic);

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public boolean getIsSuccess() {
		return this.isSuccess;
	}
}
