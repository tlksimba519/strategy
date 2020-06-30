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
					
					Conversation.output("我方死亡");
					round = false;
					break;
					
				} else if(B.showAbility().getHp() <= 0) {
					
					Conversation.output("敵方死亡");
					round = false;
					break;
					
				} else {
					
					Conversation.output("我方血量 : " + A.showAbility().getHp());
					Conversation.output("敵方血量 : " + B.showAbility().getHp());
					
				}
				
				Conversation.output(("第" + Integer.toString(roundCount) + "回合"));
				Conversation.output("選擇動作", "1.B卡", 
											"2.A卡",
											"3.Q卡",
											"4.寶具卡");
				
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
							
							Conversation.output("Np未滿，不能施放寶具");
							break;
							
						} else {
							
							A.chooseStrategy(new NoblePhantasms());
							fight(A, B);
							if(B.showAbility().getHp() > 0) fight(B, A);
							roundCount++;
							break;
							
						}
					case "run" : 
						Conversation.output("您逃跑了");
						round = false;
					default:
						throw new OutOfRangeException("請勿輸入無法判定之指令");
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
				Conversation.output("敵人已就緒");
				
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