package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SRVDestroyedEvent extends Event {

	public SRVDestroyedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}