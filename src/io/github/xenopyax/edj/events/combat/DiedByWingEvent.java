package io.github.xenopyax.edj.events.combat;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.Killer;
import io.github.xenopyax.edj.utils.JournalUtils;

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
