package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CommunityGoalRewardEvent extends Event{
	
	private Integer cgid, reward;
	private String name, system;
	
	public CommunityGoalRewardEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.cgid = json.pullInt("CGID");
		this.name = json.pullString("Name");
		this.system = json.pullString("System");
		this.reward = json.pullInt("Reward");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCgid() {
		return cgid;
	}

	public Integer getReward() {
		return reward;
	}

	public String getName() {
		return name;
	}

	public String getSystem() {
		return system;
	}

}
