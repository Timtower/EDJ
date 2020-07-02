package org.xenodev.edj.events.combat;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.Killer;
import org.xenodev.edj.utils.JournalUtils;

public class DiedByWingEvent extends Event {

	private List<Killer> killers;

	public DiedByWingEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.killers = JournalUtils.createKillerList(json.pullJSONArray("Killers"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public List<Killer> getKillers() {
		return killers;
	}
	
}
