package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;

public class CommunityGoalJoinEvent extends Event {
	
	private Integer cgid;
	private String name, system;
	
	public CommunityGoalJoinEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = json.pullInt("CGID");
		this.name = json.pullString("Name");
		this.system = json.pullString("System");
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
