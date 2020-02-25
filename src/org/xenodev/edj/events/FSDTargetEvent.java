package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class FSDTargetEvent extends Event {
	
	String name;
	long systemAdress;
	
	public FSDTargetEvent(String timestamp, String name, long systemAdress) {
		super(timestamp);
		this.name = name;
		this.systemAdress = systemAdress;
	}

	public String getName() {
		return name;
	}

	public long getSystemAdress() {
		return systemAdress;
	}

}
