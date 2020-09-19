/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 13:54
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MissionAcceptedEvent extends Event {
	
	private String faction, name, localisedName, targetFaction, destinationSystem, destinationStation, influence, reputation;
	private Long reward, missionId, expiry;
	
	public MissionAcceptedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.faction = json.pullString("Faction");
		this.name = json.pullString("Name");
		this.localisedName = json.pullString("LocalisedName");
		this.targetFaction = json.pullString("TargetFaction");
		this.destinationSystem = json.pullString("DestinationSystem");
		this.destinationStation = json.pullString("DestinationStation");
		this.expiry = JournalUtils.getTimeMillis(json.pullString("Expiry"));
		this.influence = json.pullString("Influence");
		this.reputation = json.pullString("Reputation");
		this.reward = json.pullLong("Reward");
		this.missionId = json.pullLong("MissionID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getFaction() {
		return faction;
	}

	public String getName() {
		return name;
	}

	public String getLocalisedName() {
		return localisedName;
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

	public Long getExpiry() {
		return expiry;
	}

	public String getInfluence() {
		return influence;
	}

	public String getReputation() {
		return reputation;
	}

	public Long getReward() {
		return reward;
	}

	public Long getMissionId() {
		return missionId;
	}

}
