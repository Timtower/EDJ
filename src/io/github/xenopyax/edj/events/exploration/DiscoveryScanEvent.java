package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class DiscoveryScanEvent extends Event {
	
	private Long systemAddress;
	private Integer bodies;

	public DiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemAddress = json.pullLong("SystemAddress");
		this.bodies = json.pullInt("Body");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getBodies() {
		return bodies;
	}

}
