package strategy;

import adventurer.Ability;
import utility.Conversation;

/*
 * 冒險者行動策略實作類別 - 快攻
 */
public class Quick implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit();
		double damage = ability.getAtk() * 0.1; //Q攻擊造成0.1倍傷害
		
		if(isCrit < 70) {
			
			Conversation.output("Q卡，造成 " + damage + " 傷害!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("Q卡，爆擊! 造成 " + damage + " 傷害!");
			
		}
		
		ability.recoverCrit();
		ability.plusCrit(); //下一擊爆擊率提升
		Conversation.output("爆擊機率提升", "-------");
		
		return damage;
		
	}
	
}
