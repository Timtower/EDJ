package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CommunityGoalJoinEvent extends Event {
	
	private Integer cgid;
	private String name, system;
	
	public CommunityGoalJoinEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = JsonTranslator.getInteger(json, "CGID");
		this.name = JsonTranslator.getString(json, "Name");
		this.system = JsonTranslator.getString(json, "System");
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
