package io.github.xenopyax.edj.events.trade;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
}
