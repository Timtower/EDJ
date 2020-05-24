package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class HullDamageEvent extends Event {
	
	Double health;
	Boolean playerPilot, fighter;
	
	public HullDamageEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.health = json.getDouble("Health");
		this.playerPilot = json.pullBoolean("PlayerPilot");
		this.fighter = json.has("Fighter") ? json.pullBoolean("Fighter") : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	public Boolean getPlayerPilot() {
		return playerPilot;
	}

	public void setPlayerPilot(Boolean playerPilot) {
		this.playerPilot = playerPilot;
	}

	public Boolean getFighter() {
		return fighter;
	}

	public void setFighter(Boolean fighter) {
		this.fighter = fighter;
	}	
	
}
