package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class DiscoveryScanEvent extends Event {
	
	long systemAdress;
	int bodies;
	
	public DiscoveryScanEvent(String timestamp, long systemAdress, int bodies) {
		super(timestamp);
		this.systemAdress = systemAdress;
		this.bodies = bodies;
	}

	public long getSystemAdress() {
		return systemAdress;
	}

	public int getBodies() {
		return bodies;
	}

}
