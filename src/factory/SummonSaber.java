package factory;

import adventurer.Adventurer;
import adventurer.Saber;
import utility.Conversation;

public class SummonSaber implements SummonSystem {
	@Override
	public Adventurer summonServent() {

		Conversation.output("Summon a saber");
		return new Saber();
			
	}
	
}
