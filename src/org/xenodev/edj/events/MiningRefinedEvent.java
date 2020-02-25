package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class MiningRefinedEvent extends Event {
	
	private String type;

	public MiningRefinedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = JsonTranslator.getString(json, "Type");
	}

	public String getType() {
		return type;
	}

}
