package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SupercruiseExitEvent extends Event {

	String starSystem, body, bodyType;
	Long systemAddress;
	Integer bodyID;
	
	public SupercruiseExitEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.getString("StarSystem");
		this.body = json.getString("Body");
		this.bodyType = json.getString("BodyType");
		this.systemAddress = json.getLong("SystemAddress");
		this.bodyID = json.getInt("BodyID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

}
