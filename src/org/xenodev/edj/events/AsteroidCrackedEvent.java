package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class AsteroidCrackedEvent extends Event {
	
	private String body;

	public AsteroidCrackedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.body = json.getString("Body");
	}

	public String getBody() {
		return body;
	}

}
