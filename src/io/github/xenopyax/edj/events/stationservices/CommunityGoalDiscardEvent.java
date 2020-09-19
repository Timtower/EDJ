package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CommunityGoalDiscardEvent extends Event {
	
	private Integer cgid;
	private String name, system;
	
	public CommunityGoalDiscardEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.cgid = json.pullInt("CGID");
		this.name = json.pullString("Name");
		this.system = json.pullString("System");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCgid() {
		return cgid;
	}

	public String getName() {
		return name;
	}

	public String getSystem() {
		return system;
	}

}
