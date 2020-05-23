package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CrewHireEvent extends Event {
	
	private String name, faction;
	private Integer crewID, cost, combatRank;
	
	public CrewHireEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = json.getString("Name");
		this.faction = json.getString("Faction");
		this.crewID = json.getInt("CrewID");
		this.cost = json.getInt("Cost");
		this.combatRank = json.getInt("CombatRank");
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
