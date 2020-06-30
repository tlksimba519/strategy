package factory;

import adventurer.Adventurer;

/*
 * 工廠介面 - 劍士
 */
public interface SummonSystem {
	
	public Adventurer summonServent(String type);
	
}
