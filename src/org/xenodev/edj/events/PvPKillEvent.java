package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class PvPKillEvent extends Event {
	
	String victim;
	int combatRank;
	
	public PvPKillEvent(String timestamp, String victim, int combatRank) {
		super(timestamp);
		this.victim = victim;
		this.combatRank = combatRank;
	}

	public String getVictim() {
		return victim;
	}

	public int getCombatRank() {
		return combatRank;
	}

}
