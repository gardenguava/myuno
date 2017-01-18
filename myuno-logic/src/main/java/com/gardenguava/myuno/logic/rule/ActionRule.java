package com.gardenguava.myuno.logic.rule;

import com.gardenguava.myuno.logic.GameLogic;
import com.gardenguava.myuno.logic.base.Card;
import com.gardenguava.myuno.logic.base.Player;

public interface ActionRule {
	//Player takeAction(Card currentCard, Player currentPlayer, GameLogic logic);
	public Player takeAction(Card currentCard, GameLogic logic);
	public boolean isMatchToAction(Card currentCard, GameLogic logic);
	public boolean getIsSuccess();
}
