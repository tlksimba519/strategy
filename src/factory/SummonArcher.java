package factory;

import adventurer.Adventurer;
import adventurer.Archer;
import utility.Conversation;

/*
 * 實際工廠類別 - 弓箭手
 */
public class SummonArcher implements SummonSystem {
	@Override
	public Adventurer summonServent(String type) {

		Conversation.output("Summon a archer");
		return new Archer(type);
			
	}
		
}
