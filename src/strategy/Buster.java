package strategy;

import adventurer.Ability;
import utility.Conversation;

public class Buster implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit();
		double damage = ability.getAtk() * 0.8; //B�����y��0.8���ˮ`
		
		if(isCrit < 70) {
			
			Conversation.output("B�d�A�y�� ", damage, " �ˮ`!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("B�d�A�z��! �y�� ", damage, " �ˮ`!");
			
		}
		
		ability.recoverCrit();
		ability.changeHp(damage * 0.2); //�^�_�ˮ`�⦨��q
		Conversation.output("�^�_�����ˮ`��q");
		return damage;
		
	}

}
