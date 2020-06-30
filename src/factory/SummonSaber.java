package factory;

import adventurer.Adventurer;
import adventurer.Saber;
import utility.Conversation;

/*
 * ��ڤu�t���O - �C�h
 */
public class SummonSaber implements SummonSystem {
	@Override
	public Adventurer summonServent(String type) {

		Conversation.output("Summon a saber");
		return new Saber(type);
			
	}
	
}
