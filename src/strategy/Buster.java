package strategy;

import adventurer.Ability;
import utility.Conversation;

public class Buster implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit();
		double damage = ability.getAtk() * 0.8; //B攻擊造成0.8倍傷害
		
		if(isCrit < 70) {
			
			Conversation.output("B卡，造成 ", damage, " 傷害!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("B卡，爆擊! 造成 ", damage, " 傷害!");
			
		}
		
		ability.recoverCrit();
		ability.changeHp(damage * 0.2); //回復傷害兩成血量
		Conversation.output("回復部分傷害血量");
		return damage;
		
	}

}
