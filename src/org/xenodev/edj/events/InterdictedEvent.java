package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class InterdictedEvent extends Event {
	
	boolean submitted, isPlayer;
	String interdictor, faction, power;
	Integer combatRank;
	
	public InterdictedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.submitted = json.getBoolean("Submitted");
		this.isPlayer = json.getBoolean("IsPlayer");
		this.interdictor = json.getString("Interdictor");
		this.combatRank = isPlayer ? json.getInt("CombatRank") : null;
		this.faction = isPlayer ? null : json.getString("Faction");
		this.power = isPlayer ? null : json.getString("Power");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
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
