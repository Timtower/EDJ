package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DiedEvent extends Event {
	
	String killerName, killerShip, killerRank;

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

	public void setKillerName(String killerName) {
		this.killerName = killerName;
	}

	public String getKillerShip() {
		return killerShip;
	}

	public void setKillerShip(String killerShip) {
		this.killerShip = killerShip;
	}

	public String getKillerRank() {
		return killerRank;
	}

	public void setKillerRank(String killerRank) {
		this.killerRank = killerRank;
	}

}
