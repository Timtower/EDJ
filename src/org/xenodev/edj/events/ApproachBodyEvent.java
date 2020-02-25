package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class ApproachBodyEvent extends Event {
	
	String startSystem, body;
	int bodyID;
	long systemAddress;
	
	public ApproachBodyEvent(String timestamp, String startSystem, String body, int bodyID, long systemAddress) {
		super(timestamp);
		this.startSystem = startSystem;
		this.body = body;
		this.bodyID = bodyID;
		this.systemAddress = systemAddress;
	}

	public String getStartSystem() {
		return startSystem;
	}

	public String getBody() {
		return body;
	}

	public int getBodyID() {
		return bodyID;
	}

	public long getSystemAddress() {
		return systemAddress;
	}

}
