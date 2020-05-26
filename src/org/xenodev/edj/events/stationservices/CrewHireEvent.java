package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public Integer getCrewID() {
		return crewID;
	}

	public void setCrewID(Integer crewID) {
		this.crewID = crewID;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

	public void setCombatRank(Integer combatRank) {
		this.combatRank = combatRank;
	}

}
