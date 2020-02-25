package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class SupercruiseEntryEvent extends Event {
	
	String starSystem;
	long systemAdress;
	
	public SupercruiseEntryEvent(String timestamp, String starSystem, long systemAdress) {
		super(timestamp);
		this.starSystem = starSystem;
		this.systemAdress = systemAdress;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public long getSystemAdress() {
		return systemAdress;
	}

}
