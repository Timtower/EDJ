package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class InterdictionByPlayerEvent extends Event {
	
	boolean success, isPlayer;
	String interdictor;
	int combatRank;
	
	public InterdictionByPlayerEvent(String timestamp, boolean success, boolean isPlayer, String interdictor, int combatRank) {
		super(timestamp);
		this.success = success;
		this.isPlayer = isPlayer;
		this.interdictor = interdictor;
		this.combatRank = combatRank;
	}
	
	public boolean isSuccessful() {
		return success;
	}
	
	public boolean isPlayer() {
		return isPlayer;
	}
	
	public String getInterdictor() {
		return interdictor;
	}
	
	public int getCombatRank() {
		return combatRank;
	}

}
