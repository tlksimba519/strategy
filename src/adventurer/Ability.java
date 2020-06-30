package adventurer;

/*
 * �_�I�̯�O�����O �_�I�̫�����O��
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
		this.np = 0; //�_�l��q�Ѭ�0
		this.crit = 1; //�z����Ǭ�1
		
	}
	
	public void changeHp(double hp) { //�ܰʥͩR��
		
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
	
	public void plusNp() { //�R��
		
		np++;
		
	}
	
	public void alreadyUseNp() { //�ϥΫ�R����k�s
		
		this.np = 0;
		
	}

	public void plusCrit() { //�z���v����
		
		this.crit = 1.5;
		
	}
	
	public void recoverCrit() { //�z����_����
		
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
	
	public void recoverStatus() { //���A��_
		
		hp = status;
		
	}

}
