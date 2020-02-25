package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CommunityGoalRewardEvent extends Event{
	
	private Integer cgid, reward;
	private String name, system;
	
	public CommunityGoalRewardEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = JsonTranslator.getInteger(json, "CGID");
		this.name = JsonTranslator.getString(json, "Name");
		this.system = JsonTranslator.getString(json, "System");
		this.reward = JsonTranslator.getInteger(json, "Reward");
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

	public Integer getReward() {
		return reward;
	}

}
