package strategy;

import adventurer.Ability;
import utility.Conversation;

/*
 * 冒險者行動策略實作類別 - 猛擊
 */
public class Buster implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit(); //原爆擊率為30% 角色可提升爆擊率加成
		double damage = ability.getAtk() * 0.3; //B攻擊造成0.3倍傷害
		
		if(isCrit < 70) {
			
			Conversation.output("B卡，造成 " + damage + " 傷害!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("B卡，爆擊! 造成 " + damage + " 傷害!");
			
		}
		
		ability.recoverCrit(); //完成傷害計算後復原爆擊率
		ability.changeHp(damage * 0.5); //回復傷害一半血量
		Conversation.output("回復部分傷害血量", "-------");
		return damage;
		
	}

}
