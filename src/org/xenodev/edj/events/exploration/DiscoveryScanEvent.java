package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DiscoveryScanEvent extends Event {
	
	Long systemAddress;
	Integer bodies;

	public DiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemAddress = json.pullLong("SystemAddress");
		this.bodies = json.pullInt("Body");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

	public Integer getBodies() {
		return bodies;
	}

	public void setBodies(Integer bodies) {
		this.bodies = bodies;
	}

}
