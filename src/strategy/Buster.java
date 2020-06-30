package strategy;

import adventurer.Ability;
import utility.Conversation;

/*
 * �_�I�̦�ʵ�����@���O - �r��
 */
public class Buster implements FightStrategy{

	@Override
	public double execute(Ability ability) {
		
		double isCrit = (Math.random() * 100 + 1) * ability.getCrit(); //���z���v��30% ����i�����z���v�[��
		double damage = ability.getAtk() * 0.3; //B�����y��0.3���ˮ`
		
		if(isCrit < 70) {
			
			Conversation.output("B�d�A�y�� " + damage + " �ˮ`!");
			
		} else {
			
			damage = damage * 1.5;
			Conversation.output("B�d�A�z��! �y�� " + damage + " �ˮ`!");
			
		}
		
		ability.recoverCrit(); //�����ˮ`�p���_���z���v
		ability.changeHp(damage * 0.5); //�^�_�ˮ`�@�b��q
		Conversation.output("�^�_�����ˮ`��q", "-------");
		return damage;
		
	}

}
