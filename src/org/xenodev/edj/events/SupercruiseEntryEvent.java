package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class SupercruiseEntryEvent extends Event {
	
	String starSystem;
	Long SystemAddress;
	
	public SupercruiseEntryEvent(String timestamp, String starSystem, Long SystemAddress) {
		super(timestamp);
		this.starSystem = starSystem;
		this.SystemAddress = SystemAddress;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Long getSystemAddress() {
		return SystemAddress;
	}

}
