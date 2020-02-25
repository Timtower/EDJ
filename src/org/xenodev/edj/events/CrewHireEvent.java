package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CrewHireEvent extends Event {
	
	private String name, faction;
	private Integer crewID, cost, combatRank;
	
	public CrewHireEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = JsonTranslator.getString(json, "Name");
		this.faction = JsonTranslator.getString(json, "Faction");
		this.crewID = JsonTranslator.getInteger(json, "CrewID");
		this.cost = JsonTranslator.getInteger(json, "Cost");
		this.combatRank = JsonTranslator.getInteger(json, "CombatRank");
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
