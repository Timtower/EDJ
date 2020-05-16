package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class DiscoveryScanEvent extends Event {
	
	Long systemAddress;
	Integer bodies;

	public DiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.systemAddress = json.getLong("SystemAddress");
		this.bodies = json.getInt("Body");
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getBodies() {
		return bodies;
	}

}
