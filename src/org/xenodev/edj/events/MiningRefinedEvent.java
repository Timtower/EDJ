package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MiningRefinedEvent extends Event {
	
	private String type;

	public MiningRefinedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = json.getString("Type");
	}

	public String getType() {
		return type;
	}

}
