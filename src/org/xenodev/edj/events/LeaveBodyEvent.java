package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class LeaveBodyEvent extends Event {

	String starSystem, body;
	Long systemAdress;
	Integer bodyID;
	
	public LeaveBodyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.getString("StarSystem");
		this.body = json.getString("Body");
		this.systemAdress = json.getLong("SystemAddress");
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

	public Long getSystemAdress() {
		return systemAdress;
	}

	public void setSystemAdress(Long systemAdress) {
		this.systemAdress = systemAdress;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

}
