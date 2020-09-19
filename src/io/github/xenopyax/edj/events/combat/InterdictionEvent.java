package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class InterdictionEvent extends Event {
	
	private Boolean success, isPlayer;
	private String interdictor, faction, power;
	private Integer combatRank;
	
	public InterdictionEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.success = json.pullBoolean("Submitted");
		this.isPlayer = json.pullBoolean("IsPlayer");
		this.interdictor = json.pullString("Interdictor");
		this.faction = isPlayer ? null : json.pullString("Faction");
		this.power = isPlayer ?  null : json.pullString("Power");
		this.combatRank = isPlayer ? json.pullInt("CombatRank") : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Boolean getSuccess() {
		return success;
	}

	public Boolean getIsPlayer() {
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
