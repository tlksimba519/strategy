package adventurer;

import strategy.FightStrategy;

/*
 * «_ÀIªÌ¤¶­±
 */
public interface Adventurer {
	
	String getType();
	Ability showAbility();
	double attack();
	void chooseStrategy(FightStrategy strategy);
	
}
