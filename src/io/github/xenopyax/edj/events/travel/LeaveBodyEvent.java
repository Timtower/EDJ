package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
