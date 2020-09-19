package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
