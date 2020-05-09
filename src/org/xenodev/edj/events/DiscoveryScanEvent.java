package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class DiscoveryScanEvent extends Event {
	
	Long systemAddress;
	Integer bodies;
	
	public DiscoveryScanEvent(String timestamp, Long systemAddress, Integer bodies) {
		super(timestamp);
		this.systemAddress = systemAddress;
		this.bodies = bodies;
	}

	public long getSystemAddress() {
		return systemAddress;
	}

	public int getBodies() {
		return bodies;
	}

}
