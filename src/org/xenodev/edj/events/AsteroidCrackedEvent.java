package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class AsteroidCrackedEvent extends Event {
	
	private String body;

	public AsteroidCrackedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.body = json.pullString("Body");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
