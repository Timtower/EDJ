/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:04
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MissionCompletedEvent extends Event {
	
	String faction, name, targetFaction, destinationSystem, destinationStation;
	Long missionId, reward;
	
	public MissionCompletedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.faction = json.getString("Faction");
		this.name = json.getString("Name");
		this.targetFaction = json.getString("TargetFaction");
		this.destinationSystem = json.getString("DestinationSystem");
		this.destinationStation = json.getString("DestinationStation");
		this.missionId = json.getLong("MissionID");
		this.reward = json.getLong("Reward");
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTargetFaction() {
		return targetFaction;
	}

	public void setTargetFaction(String targetFaction) {
		this.targetFaction = targetFaction;
	}

	public String getDestinationSystem() {
		return destinationSystem;
	}

	public void setDestinationSystem(String destinationSystem) {
		this.destinationSystem = destinationSystem;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Long getMissionId() {
		return missionId;
	}

	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

	public Long getReward() {
		return reward;
	}

	public void setReward(Long reward) {
		this.reward = reward;
	}

}
