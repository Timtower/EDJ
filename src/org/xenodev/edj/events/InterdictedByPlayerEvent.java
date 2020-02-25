package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class InterdictedByPlayerEvent extends Event {
	
	boolean submitted, isPlayer;
	String interdictor;
	int combatRank;
	
	public InterdictedByPlayerEvent(String timestamp, boolean submitted, boolean isPlayer, String interdictor, int combatRank) {
		super(timestamp);
		this.submitted = submitted;
		this.isPlayer = isPlayer;
		this.interdictor = interdictor;
		this.combatRank = combatRank;
	}
	
	public boolean isSubmitted() {
		return submitted;
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
