package strategy;

import adventurer.Ability;
import utility.Conversation;

public class NoblePhantasms implements FightStrategy{

	@Override
	public double execute(Ability ability) {
	
		double damage = ability.getAtk() * 1.5;
		ability.alreadyUseNp();
		ability.recoverCrit();
		Conversation.output("Ä_¨ã ", ability.showNpName(), "¡A³y¦¨ ", damage, " ¶Ë®`!");
		return damage;

	}

}
