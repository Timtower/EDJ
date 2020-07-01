package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DiedEvent extends Event {
	
	private String killerName, killerShip, killerRank;

	public DiedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.killerName = json.pullString("KillerName");
		this.killerShip = json.pullString("KillerShip");
		this.killerRank = json.pullString("KillerRank");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getKillerName() {
		return killerName;
	}

	public String getKillerShip() {
		return killerShip;
	}

	public String getKillerRank() {
		return killerRank;
	}

}
