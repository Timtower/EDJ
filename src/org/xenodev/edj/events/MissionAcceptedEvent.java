/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 13:54
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MissionAcceptedEvent extends Event {
	
	String faction, name, localisedName, targetFaction, destinationSystem, destinationStation, influence, reputation;
	Long reward, missionId, expiry;
	
	public MissionAcceptedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.faction = json.getString("Faction");
		this.name = json.getString("Name");
		this.localisedName = json.getString("LocalisedName");
		this.targetFaction = json.getString("TargetFaction");
		this.destinationSystem = json.getString("DestinationSystem");
		this.destinationStation = json.getString("DestinationStation");
		this.expiry = JournalUtils.getTimeMillis(json.getString("Expiry"));
		this.influence = json.getString("Influence");
		this.reputation = json.getString("Reputation");
		this.reward = json.getLong("Reward");
		this.missionId = json.getLong("MissionID");
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

	public String getLocalisedName() {
		return localisedName;
	}

	public void setLocalisedName(String localisedName) {
		this.localisedName = localisedName;
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

	public Long getExpiry() {
		return expiry;
	}

	public void setExpiry(Long expiry) {
		this.expiry = expiry;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	public String getReputation() {
		return reputation;
	}

	public void setReputation(String reputation) {
		this.reputation = reputation;
	}

	public Long getReward() {
		return reward;
	}

	public void setReward(Long reward) {
		this.reward = reward;
	}

	public Long getMissionId() {
		return missionId;
	}

	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

}
