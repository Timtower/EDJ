package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class SupercruiseExitEvent extends Event {

	private String starSystem, body, bodyType;
	private Long systemAddress;
	private Integer bodyID;
	
	public SupercruiseExitEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.pullString("StarSystem");
		this.body = json.pullString("Body");
		this.bodyType = json.pullString("BodyType");
		this.systemAddress = json.pullLong("SystemAddress");
		this.bodyID = json.pullInt("BodyID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
