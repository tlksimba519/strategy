package adventurer;

public class Ability {
	private double status;
	private double hp;
	private double atk;
	private double np;
	private double crit;
	private String npName;
	
	Ability(double hp, double atk) {
		
		this.status = hp;
		this.hp = hp;
		this.atk = atk;
		this.np = 0;
		this.crit = 1;
		
	}
	
	public void changeHp(double hp) {
		
		this.hp += hp;
		
	}
	
	public double getHp() {
		
		return hp;
		
	}
	
	public double getAtk() {
		
		return atk;
		
	}
	
	public double getNp() {
		
		return np;
	
	}
	
	public void plusNp() {
		
		np++;
		
	}
	
	public void alreadyUseNp() {
		
		this.np = 0;
		
	}

	public void plusCrit() {
		
		this.crit = 1.5;
		
	}
	
	public void recoverCrit() {
		
		this.crit = 1;
		
	}

	public double getCrit() {
		
		return crit;
	
	}
	
	public void setNpName(String npName) {
		
		this.npName = npName;
	
	}
	
	public String showNpName() {
		
		return npName;
		
	}
	
	public void recoverStatus() {
		
		hp = status;
		
	}

}
