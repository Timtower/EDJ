package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PvPKillEvent extends Event {
	
	String victim;
	Integer combatRank;
	
	public PvPKillEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.victim = json.getString("Victim");
		this.combatRank = json.getInt("CombatRank");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

	public void setCombatRank(Integer combatRank) {
		this.combatRank = combatRank;
	}

}
