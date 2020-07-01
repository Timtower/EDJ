package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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
