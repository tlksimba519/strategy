package adventurer;

import java.io.IOException;

import org.junit.Test;

import factory.SummonArcher;
import factory.SummonSaber;
import factory.SummonSystem;
import strategy.Art;
import strategy.Buster;
import strategy.NoblePhantasms;
import strategy.Quick;
import utility.Conversation;

public class AdventurerTest {
	
	String[] adventures = {"factory.SummonSaber", "factory.SummonArcher"};
	
	private static void fight(Adventurer attacker, Adventurer defender) {
		
		if(attacker.getType().equalsIgnoreCase("enemy")) {
			
			switch((int)(Math.random() * 4)) {
				case 0 :
					attacker.chooseStrategy(new Buster());
					break;
				case 1 :
					attacker.chooseStrategy(new Art());
					break;
				case 2 :
					attacker.chooseStrategy(new Quick());
					break;
				case 3 :
					if(attacker.showAbility().getNp() < 3) {
						attacker.chooseStrategy(new Art());
						break;
					}
					else {
						attacker.chooseStrategy(new NoblePhantasms());
						break;
					}
			}
			
		}
		
		defender.showAbility().changeHp(-attacker.attack());
		
	}
	
	@Test
	public void test() throws NumberFormatException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	
		SummonSystem summonSystem = new SummonArcher();
		Adventurer A = summonSystem.summonServent("player");
		
		summonSystem = new SummonSaber();
		Adventurer B = summonSystem.summonServent("enemy");
		
		boolean continueBattle = true;
		
		while(continueBattle) {
			
			int roundCount = 1;
			boolean round = true;
			
			while(round) {
				
				if(A.showAbility().getHp() <= 0) {
					
					Conversation.output("�ڤ覺�`");
					round = false;
					break;
					
				} else if(B.showAbility().getHp() <= 0) {
					
					Conversation.output("�Ĥ覺�`");
					round = false;
					break;
					
				} else {
					
					Conversation.output("�ڤ��q : " + A.showAbility().getHp());
					Conversation.output("�Ĥ��q : " + B.showAbility().getHp());
					
				}
				
				Conversation.output(("��" + Integer.toString(roundCount) + "�^�X"));
				Conversation.output("��ܰʧ@", "1.B�d", 
											"2.A�d",
											"3.Q�d",
											"4.�_��d");
				
				switch(Conversation.input()) {
					case "1" :
						A.chooseStrategy(new Buster());
						fight(A, B);
						if(B.showAbility().getHp() > 0) fight(B, A);
						roundCount++;
						break;
					case "2" :
						A.chooseStrategy(new Art());
						fight(A, B);
						if(B.showAbility().getHp() > 0) fight(B, A);
						roundCount++;
						break;
					case "3" :
						A.chooseStrategy(new Quick());
						fight(A, B);
						if(B.showAbility().getHp() > 0) fight(B, A);
						roundCount++;
						break;
					case "4" :
						if(A.showAbility().getNp() < 3) {
							
							Conversation.output("Np�����A����I���_��");
							break;
							
						} else {
							
							A.chooseStrategy(new NoblePhantasms());
							fight(A, B);
							if(B.showAbility().getHp() > 0) fight(B, A);
							roundCount++;
							break;
							
						}
					case "run" : 
						Conversation.output("�z�k�]�F");
						round = false;
					default:
						throw new OutOfRangeException("�Фſ�J�L�k�P�w�����O");
				}
				
			}
			
			Conversation.output("Continue? Y/N");
			if(Conversation.input().equalsIgnoreCase("Y")) {
				Class<?> c = Class.forName(adventures[(int)(Math.random()*2)]);
				summonSystem = (SummonSystem) c.newInstance();
				B = summonSystem.summonServent("enemy");
				A.showAbility().recoverStatus();
				round = true;
				roundCount = 1;
				Conversation.output("�ĤH�w�N��");
				
			} else if(Conversation.input().equalsIgnoreCase("N")) {
				
				continueBattle = false;
				
			} else continueBattle = false;
			
		}
	}

}

class OutOfRangeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OutOfRangeException(String s) {
		
		super(s);

	}
	
}