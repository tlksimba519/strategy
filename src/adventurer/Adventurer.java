package adventurer;

import strategy.FightStrategy;

/*
 * �_�I�̤���
 */
public interface Adventurer {
	
	String getType();
	Ability showAbility();
	double attack();
	void chooseStrategy(FightStrategy strategy);
	
}
