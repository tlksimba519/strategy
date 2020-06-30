package adventurer;

import strategy.Buster;
import strategy.FightStrategy;

/*
 * 冒險者實作類別 - 劍士
 */
public class Saber implements Adventurer {
	
	String type;
	Ability ability;
	FightStrategy fightStrategy;
	
	public Saber(String type) {
		
		this.ability = new Ability(1400,1200);
		ability.setNpName("全力一擊");
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
