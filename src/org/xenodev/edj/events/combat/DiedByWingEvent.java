package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.Killer;
import org.xenodev.edj.utils.JournalUtils;

public class DiedByWingEvent extends Event {

	Killer[] killers;

	public DiedByWingEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.killers = JournalUtils.createKillerList(json.pullJSONArray("Killers"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Killer[] getKillers() {
		return killers;
	}

	public void setKillers(Killer[] killers) {
		this.killers = killers;
	}
	
}
