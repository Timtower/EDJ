package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
