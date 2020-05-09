package org.xenodev.edj.events;

import java.util.List;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Faction;

public class LocationEvent extends Event {
	
	String starSystem, systemAllegiance, systemEconomy, systemEconomy_Localised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernment_Localised, systemSecurity, systemSecurity_Localised, body, bodyType, systemFaction_Name, systemFaction_State, powerplayState;
	Double[] starPos;
	Long systemAddress, population, marketID;
	Integer bodyID;
	Boolean docked;
	List<Faction> factions;
	List<String> powers;
	
	public LocationEvent(String timestamp, String starSystem, String systemAllegiance, String systemEconomy,
			String systemEconomy_Localised, String systemSecondEconomy, String systemSecondEconomy_Localised,
			String systemGovernment, String systemGovernment_Localised, String systemSecurity,
			String systemSecurity_Localised, String body, String bodyType, String systemFaction_Name,
			String systemFaction_State, String powerplayState, Double[] starPos, Long systemAddress, Long population,
			Long marketID, Integer bodyID, Boolean docked, List<Faction> factions, List<String> powers) {
		super(timestamp);
		this.starSystem = starSystem;
		this.systemAllegiance = systemAllegiance;
		this.systemEconomy = systemEconomy;
		this.systemEconomy_Localised = systemEconomy_Localised;
		this.systemSecondEconomy = systemSecondEconomy;
		this.systemSecondEconomy_Localised = systemSecondEconomy_Localised;
		this.systemGovernment = systemGovernment;
		this.systemGovernment_Localised = systemGovernment_Localised;
		this.systemSecurity = systemSecurity;
		this.systemSecurity_Localised = systemSecurity_Localised;
		this.body = body;
		this.bodyType = bodyType;
		this.systemFaction_Name = systemFaction_Name;
		this.systemFaction_State = systemFaction_State;
		this.powerplayState = powerplayState;
		this.starPos = starPos;
		this.systemAddress = systemAddress;
		this.population = population;
		this.marketID = marketID;
		this.bodyID = bodyID;
		this.docked = docked;
		this.factions = factions;
		this.powers = powers;
	}
	
	public LocationEvent(String timestamp, String starSystem, String systemAllegiance, String systemEconomy,
			String systemEconomy_Localised, String systemSecondEconomy, String systemSecondEconomy_Localised,
			String systemGovernment, String systemGovernment_Localised, String systemSecurity,
			String systemSecurity_Localised, String body, String bodyType, String systemFaction_Name,
			String systemFaction_State, Double[] starPos, Long systemAddress, Long population,
			Long marketID, Integer bodyID, Boolean docked, List<Faction> factions) {
		super(timestamp);
		this.starSystem = starSystem;
		this.systemAllegiance = systemAllegiance;
		this.systemEconomy = systemEconomy;
		this.systemEconomy_Localised = systemEconomy_Localised;
		this.systemSecondEconomy = systemSecondEconomy;
		this.systemSecondEconomy_Localised = systemSecondEconomy_Localised;
		this.systemGovernment = systemGovernment;
		this.systemGovernment_Localised = systemGovernment_Localised;
		this.systemSecurity = systemSecurity;
		this.systemSecurity_Localised = systemSecurity_Localised;
		this.body = body;
		this.bodyType = bodyType;
		this.systemFaction_Name = systemFaction_Name;
		this.systemFaction_State = systemFaction_State;
		this.starPos = starPos;
		this.systemAddress = systemAddress;
		this.population = population;
		this.marketID = marketID;
		this.bodyID = bodyID;
		this.docked = docked;
		this.factions = factions;
	}
	
	public LocationEvent(String timestamp, String starSystem, String systemAllegiance, String systemEconomy,
			String systemEconomy_Localised, String systemSecondEconomy, String systemSecondEconomy_Localised,
			String systemGovernment, String systemGovernment_Localised, String systemSecurity,
			String systemSecurity_Localised, String body, String bodyType, Double[] starPos, Long systemAddress, Long population,
			Long marketID, Integer bodyID, Boolean docked) {
		super(timestamp);
		this.starSystem = starSystem;
		this.systemAllegiance = systemAllegiance;
		this.systemEconomy = systemEconomy;
		this.systemEconomy_Localised = systemEconomy_Localised;
		this.systemSecondEconomy = systemSecondEconomy;
		this.systemSecondEconomy_Localised = systemSecondEconomy_Localised;
		this.systemGovernment = systemGovernment;
		this.systemGovernment_Localised = systemGovernment_Localised;
		this.systemSecurity = systemSecurity;
		this.systemSecurity_Localised = systemSecurity_Localised;
		this.body = body;
		this.bodyType = bodyType;
		this.starPos = starPos;
		this.systemAddress = systemAddress;
		this.population = population;
		this.marketID = marketID;
		this.bodyID = bodyID;
		this.docked = docked;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getSystemAllegiance() {
		return systemAllegiance;
	}

	public String getSystemEconomy() {
		return systemEconomy;
	}

	public String getSystemEconomy_Localised() {
		return systemEconomy_Localised;
	}

	public String getSystemSecondEconomy() {
		return systemSecondEconomy;
	}

	public String getSystemSecondEconomy_Localised() {
		return systemSecondEconomy_Localised;
	}

	public String getSystemGovernment() {
		return systemGovernment;
	}

	public String getSystemGovernment_Localised() {
		return systemGovernment_Localised;
	}

	public String getSystemSecurity() {
		return systemSecurity;
	}

	public String getSystemSecurity_Localised() {
		return systemSecurity_Localised;
	}

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getSystemFaction_Name() {
		return systemFaction_Name;
	}

	public String getSystemFaction_State() {
		return systemFaction_State;
	}

	public String getPowerplayState() {
		return powerplayState;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Long getPopulation() {
		return population;
	}

	public Long getMarketID() {
		return marketID;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Boolean isDocked() {
		return docked;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public List<String> getPowers() {
		return powers;
	}
	
	
}
