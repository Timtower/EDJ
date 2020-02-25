package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class AsteroidCrackedEvent extends Event {
	
	private String body;

	public AsteroidCrackedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.body = JsonTranslator.getString(json, "Body");
	}

	public String getBody() {
		return body;
	}

}
