package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class InterdictedEvent extends Event {
	
	private Boolean submitted, isPlayer;
	private String interdictor, faction, power;
	private Integer combatRank;
	
	public InterdictedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.submitted = json.pullBoolean("Submitted");
		this.isPlayer = json.pullBoolean("IsPlayer");
		this.interdictor = json.pullString("Interdictor");
		this.combatRank = isPlayer ? json.pullInt("CombatRank") : null;
		this.faction = isPlayer ? null : json.pullString("Faction");
		this.power = isPlayer ? null : json.pullString("Power");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public String getFaction() {
		return faction;
	}

	public String getPower() {
		return power;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

}
