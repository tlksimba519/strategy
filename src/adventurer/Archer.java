package adventurer;

import strategy.*;
import utility.*;

public class Archer implements Adventurer {
	
	Ability ability;
	FightStrategy fightStrategy;
	
	public Archer() {
		
		this.ability = new Ability(200,400);
		ability.setNpName("½b«B");
		
	}
	
	@Override
	public String getType() {
		
		Conversation.output("Archer here!");
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
