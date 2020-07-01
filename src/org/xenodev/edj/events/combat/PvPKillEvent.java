package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PvPKillEvent extends Event {
	
	private String victim;
	private Integer combatRank;
	
	public PvPKillEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.victim = json.pullString("Victim");
		this.combatRank = json.pullInt("CombatRank");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getVictim() {
		return victim;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

}
