package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ApproachBodyEvent extends Event {
	
	private String starSystem, body;
	private Integer bodyID;
	private Long systemAddress;
	
	public ApproachBodyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.pullString("StarSystem");
		this.body = json.pullString("Body");
		this.bodyID = json.pullInt("BodyID");
		this.systemAddress = json.pullLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

}
