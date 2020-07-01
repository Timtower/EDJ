package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class LeaveBodyEvent extends Event {

	private String starSystem, body;
	private Long systemAdress;
	private Integer bodyID;
	
	public LeaveBodyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.pullString("StarSystem");
		this.body = json.pullString("Body");
		this.systemAdress = json.pullLong("SystemAddress");
		this.bodyID = json.pullInt("BodyID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Integer getBodyID() {
		return bodyID;
	}

}
