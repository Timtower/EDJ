package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class InterdictionEvent extends Event {
	
	Boolean success, isPlayer;
	String interdictor, faction, power;
	Integer combatRank;
	
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

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getIsPlayer() {
		return isPlayer;
	}

	public void setIsPlayer(Boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	public String getInterdictor() {
		return interdictor;
	}

	public void setInterdictor(String interdictor) {
		this.interdictor = interdictor;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

	public void setCombatRank(Integer combatRank) {
		this.combatRank = combatRank;
	}

}
