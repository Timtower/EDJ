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

	public Integer getCGID() {
		return cgid;
	}

	public void setCGID(Integer cgid) {
		this.cgid = cgid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}
	
}
