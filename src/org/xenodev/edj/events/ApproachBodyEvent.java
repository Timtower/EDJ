package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ApproachBodyEvent extends Event {
	
	String startSystem, body;
	Integer bodyID;
	Long systemAddress;
	
	public ApproachBodyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.startSystem = json.pullString("StartSystem");
		this.body = json.pullString("Body");
		this.bodyID = json.pullInt("BodyID");
		this.systemAddress = json.pullLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStartSystem() {
		return startSystem;
	}

	public void setStartSystem(String startSystem) {
		this.startSystem = startSystem;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

}
