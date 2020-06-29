package adventurer;

import strategy.Buster;
import strategy.FightStrategy;
import utility.Conversation;

public class Saber implements Adventurer {
	
	Ability ability;
	FightStrategy fightStrategy;
	
	public Saber() {
		
		this.ability = new Ability(400,200);
		ability.setNpName("¥þ¤O¤@À»");
		
	}
	
	@Override
	public String getType() {
		
		Conversation.output("Saber here!");
		return this.getClass().getSimpleName();
		
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
