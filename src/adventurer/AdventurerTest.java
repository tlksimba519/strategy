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
	private static void fight(Adventurer you, Adventurer enemy) {
		
		enemy.showAbility().changeHp(-you.attack());
		
	}
	@Test
	public void test() throws NumberFormatException, IOException {
		
		SummonSystem summonsystem = new SummonArcher();
		Adventurer A = summonsystem.summonServent();
		
		summonsystem = new SummonSaber();
		Adventurer B = summonsystem.summonServent();
		
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
					
					Conversation.output("我方血量 : ", A.showAbility().getHp());
					Conversation.output("敵方血量 : ", B.showAbility().getHp());
					
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
				
				B = summonsystem.summonServent();
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
	
	OutOfRangeException(String s) {
		
		super(s);

	}
	
}