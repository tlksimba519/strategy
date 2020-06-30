package factory;

import adventurer.Adventurer;
import adventurer.Archer;
import utility.Conversation;

/*
 * ��ڤu�t���O - �}�b��
 */
public class SummonArcher implements SummonSystem {
	@Override
	public Adventurer summonServent(String type) {

		Conversation.output("Summon a archer");
		return new Archer(type);
			
	}
		
}
