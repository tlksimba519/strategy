package adventurer;

/*
 * 冒險者能力值類別 冒險者持有能力值
 */
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
		this.np = 0; //起始能量槽為0
		this.crit = 1; //爆擊基準為1
		
	}
	
	public void changeHp(double hp) { //變動生命值
		
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
	
	public void plusNp() { //充能
		
		np++;
		
	}
	
	public void alreadyUseNp() { //使用後充能槽歸零
		
		this.np = 0;
		
	}

	public void plusCrit() { //爆擊率提升
		
		this.crit = 1.5;
		
	}
	
	public void recoverCrit() { //爆擊後復原基準
		
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
	
	public void recoverStatus() { //狀態恢復
		
		hp = status;
		
	}

}
