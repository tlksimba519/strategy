package strategy;

import adventurer.Ability;

/*
 * 冒險者行動策略介面
 */
public interface FightStrategy {
	
	double execute(Ability ability);
	
}
