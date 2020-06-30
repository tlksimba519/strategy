package strategy;

import adventurer.Ability;
import utility.Conversation;

/*
 * 冒險者行動策略實作類別 - 武技
 */
public class Art implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit();
		double damage = ability.getAtk() * 0.2; //A攻擊造成0.2倍傷害
		
		if(isCrit < 70) {
			
			Conversation.output("A卡，造成 " + damage + " 傷害!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("A卡，爆擊! 造成 " + damage + " 傷害!");
			
		}
		
		ability.recoverCrit();
		ability.plusNp(); //寶具充能
		Conversation.output("獲得 1 充能", "-------");
		return damage;
		
	}

}
