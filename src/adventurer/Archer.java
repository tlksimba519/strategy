package adventurer;

import strategy.Buster;
import strategy.FightStrategy;

/*
 * �_�I�̹�@���O - �}�b��
 */
public class Archer implements Adventurer {
	
	String type;
	Ability ability;
	FightStrategy fightStrategy;
	
	public Archer(String type) {
		
		this.ability = new Ability(1200,1400);
		ability.setNpName("�b�B");
		this.type = type;
		
	}
	
	@Override
	public String getType() {
		
		return type;
		
	}
	
	@Override
	public Ability showAbility() {
		
		return ability;
		
	}
	
	@Override
	public double attack() {
		
		if(fightStrategy == null) {
			
			fightStrategy = new Buster();
			
		}
		
		return fightStrategy.execute(ability);
		
	}

	@Override
	public void chooseStrategy(FightStrategy strategy){
		
        this.fightStrategy = strategy;
        
    }
	
}
