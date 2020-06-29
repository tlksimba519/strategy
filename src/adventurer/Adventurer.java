package adventurer;

import strategy.FightStrategy;

public interface Adventurer {
	
	String getType();
	Ability showAbility();
	double attack();
	void chooseStrategy(FightStrategy strategy);
	
}
