/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:04
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MissionCompletedEvent extends Event {
	
	private String faction, name, targetFaction, destinationSystem, destinationStation;
	private Long missionId, reward;
	
	public MissionCompletedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.faction = json.pullString("Faction");
		this.name = json.pullString("Name");
		this.targetFaction = json.pullString("TargetFaction");
		this.destinationSystem = json.pullString("DestinationSystem");
		this.destinationStation = json.pullString("DestinationStation");
		this.missionId = json.pullLong("MissionID");
		this.reward = json.pullLong("Reward");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getFaction() {
		return faction;
	}

	public String getName() {
		return name;
	}

	public String getTargetFaction() {
		return targetFaction;
	}

	public String getDestinationSystem() {
		return destinationSystem;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public Long getMissionId() {
		return missionId;
	}

	public Long getReward() {
		return reward;
	}

}
