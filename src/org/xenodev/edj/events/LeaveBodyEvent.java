package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class LeaveBodyEvent extends Event {

	String starSystem, body;
	long systemAdress;
	int bodyID;
	
	public LeaveBodyEvent(String timestamp, String starSystem, String body, long systemAdress, int bodyID) {
		super(timestamp);
		this.starSystem = starSystem;
		this.body = body;
		this.systemAdress = systemAdress;
		this.bodyID = bodyID;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public long getSystemAdress() {
		return systemAdress;
	}

	public int getBodyID() {
		return bodyID;
	}

}
