package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class SupercruiseExitEvent extends Event {

	String starSystem, body, bodyType;
	long systemAdress;
	int bodyID;
	
	public SupercruiseExitEvent(String timestamp, String starSystem, String body, String bodyType, long systemAdress,
			int bodyID) {
		super(timestamp);
		this.starSystem = starSystem;
		this.body = body;
		this.bodyType = bodyType;
		this.systemAdress = systemAdress;
		this.bodyID = bodyID;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public long getSystemAdress() {
		return systemAdress;
	}

	public int getBodyID() {
		return bodyID;
	}

}
