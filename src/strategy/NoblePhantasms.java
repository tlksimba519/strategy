package strategy;

import adventurer.Ability;
import utility.Conversation;

/*
 * 冒險者行動策略實作類別 - 寶具(大絕)
 */
public class NoblePhantasms implements FightStrategy{

	@Override
	public double execute(Ability ability) {
	
		double damage = ability.getAtk() * 1.5;
		ability.alreadyUseNp();
		ability.recoverCrit();
		Conversation.output("寶具 " + ability.showNpName() + "，造成 " + damage + " 傷害!", "-------");
		return damage;

	}

}
