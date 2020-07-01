package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class HullDamageEvent extends Event {
	
	private Double health;
	private Boolean playerPilot, fighter;
	
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

	public Boolean getPlayerPilot() {
		return playerPilot;
	}

	public Boolean getFighter() {
		return fighter;
	}
	
}
