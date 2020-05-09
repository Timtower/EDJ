package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class SupercruiseExitEvent extends Event {

	String starSystem, body, bodyType;
	Long systemAddress;
	Integer bodyID;
	
	public SupercruiseExitEvent(String timestamp, String starSystem, String body, String bodyType, Long systemAddress,
			int bodyID) {
		super(timestamp);
		this.starSystem = starSystem;
		this.body = body;
		this.bodyType = bodyType;
		this.systemAddress = systemAddress;
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

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getBodyID() {
		return bodyID;
	}

}
