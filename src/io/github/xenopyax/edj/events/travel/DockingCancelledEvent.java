package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class DockingCancelledEvent extends Event {
	
	public DockingCancelledEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}
