package strategy;

import adventurer.Ability;
import utility.Conversation;

/*
 * �_�I�̦�ʵ�����@���O - �֧�
 */
public class Quick implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit();
		double damage = ability.getAtk() * 0.1; //Q�����y��0.1���ˮ`
		
		if(isCrit < 70) {
			
			Conversation.output("Q�d�A�y�� " + damage + " �ˮ`!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("Q�d�A�z��! �y�� " + damage + " �ˮ`!");
			
		}
		
		ability.recoverCrit();
		ability.plusCrit(); //�U�@���z���v����
		Conversation.output("�z�����v����", "-------");
		
		return damage;
		
	}
	
}
