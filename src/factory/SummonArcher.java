package factory;

import adventurer.Adventurer;
import adventurer.Archer;
import utility.Conversation;

public class SummonArcher implements SummonSystem {
	@Override
	public Adventurer summonServent() {

		Conversation.output("Summon a archer");
		return new Archer();
			
	}
		
}
