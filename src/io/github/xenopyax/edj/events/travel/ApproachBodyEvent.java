package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
