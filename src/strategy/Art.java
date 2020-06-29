package strategy;

import adventurer.Ability;
import utility.Conversation;

public class Art implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit();
		double damage = ability.getAtk() * 0.5; //A�����y��0.5���ˮ`
		
		if(isCrit < 70) {
			
			Conversation.output("A�d�A�y�� ", damage, " �ˮ`!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("A�d�A�z��! �y�� ", damage, " �ˮ`!");
			
		}
		
		ability.recoverCrit();
		ability.plusNp(); //�_��R��
		Conversation.output("��o 1 �R��");
		return damage;
		
	}

}
