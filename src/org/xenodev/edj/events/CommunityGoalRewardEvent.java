package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CommunityGoalRewardEvent extends Event{
	
	private Integer cgid, reward;
	private String name, system;
	
	public CommunityGoalRewardEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = json.getInt("CGID");
		this.name = json.getString("Name");
		this.system = json.getString("System");
		this.reward = json.getInt("Reward");
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
