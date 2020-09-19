package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CrewHireEvent extends Event {
	
	private String name, faction;
	private Integer crewID, cost, combatRank;
	
	public CrewHireEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.faction = json.pullString("Faction");
		this.crewID = json.pullInt("CrewID");
		this.cost = json.pullInt("Cost");
		this.combatRank = json.pullInt("CombatRank");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public String getFaction() {
		return faction;
	}

	public Integer getCrewID() {
		return crewID;
	}

	public Integer getCost() {
		return cost;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

}
