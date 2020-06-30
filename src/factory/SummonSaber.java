package factory;

import adventurer.Adventurer;
import adventurer.Saber;
import utility.Conversation;

/*
 * 實際工廠類別 - 劍士
 */
public class SummonSaber implements SummonSystem {
	@Override
	public Adventurer summonServent(String type) {

		Conversation.output("Summon a saber");
		return new Saber(type);
			
	}
	
}
