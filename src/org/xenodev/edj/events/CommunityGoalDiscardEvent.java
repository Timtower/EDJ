package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CommunityGoalDiscardEvent extends Event {
	
	private Integer cgid;
	private String name, system;
	
	public CommunityGoalDiscardEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = json.getInt("CGID");
		this.name = json.getString("Name");
		this.system = json.getString("System");
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
