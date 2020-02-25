package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class CommanderEvent extends Event {
	
	String name;
	String FID;
	
	public CommanderEvent(String timestamp, String name, String FID) {
		super(timestamp);
		this.name = name;
		this.FID = FID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

}
