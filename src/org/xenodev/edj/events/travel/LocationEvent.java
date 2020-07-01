package org.xenodev.edj.events.travel;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.Faction;
import org.xenodev.edj.events.storage.StationEconomy;
import org.xenodev.edj.utils.JournalUtils;

public class LocationEvent extends Event {
	
	private String starSystem, systemAllegiance, systemEconomy, systemEconomy_Localised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernment_Localised,
	systemSecurity, systemSecurity_Localised, body, bodyType, systemFactionName, systemFactionState, powerplayState, stationName, stationType, stationEconomy, stationFactionName, stationFactionState,
	stationAllegiance, stationGovernment, stationEconomyLocalised, stationGovernmentLocalised;
	private Double[] starPos;
	private Long systemAddress, population, marketID;
	private Integer bodyID;
	private Boolean docked;
	private List<Faction> factions;
	private List<String> powers, stationServices;
	private List<StationEconomy> stationEconomies;
	
	public LocationEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JSONObject systemFaction = json.has("SystemFaction") ? json.pullJSONObject("SystemFaction") : null;
		JSONObject stationFaction = json.has("StationFaction") ? json.pullJSONObject("StationFaction") : null;
		
		this.stationName = json.pullString("StationName");
		this.stationType = json.pullString("StationType");
		this.stationEconomy = json.pullString("StationEconomy");
		this.starSystem = json.pullString("StarSystem");
		this.systemAllegiance = json.pullString("SystemAllegiance");
		this.systemEconomy = json.pullString("SystemEconomy");
		this.systemEconomy_Localised = json.pullString("SystemEconomy_Localised");
		this.systemSecondEconomy = json.pullString("SystemSecondEconomy");
		this.systemSecondEconomy_Localised = json.pullString("SystemSecondEconomy_Localised");
		this.systemGovernment = json.pullString("SystemGovernment");
		this.systemGovernment_Localised = json.pullString("SystemGovernment_Localised");
		this.systemSecurity = json.pullString("SystemSecurity");
		this.systemSecurity_Localised = json.pullString("SystemSecurity_Localised");
		this.body = json.pullString("Body");
		this.bodyType = json.pullString("BodyType");
		this.stationFactionName = stationFaction == null ? null : stationFaction.pullString("Name");
		this.stationFactionState = stationFaction == null ? null : stationFaction.pullString("FactionState");
		this.systemFactionName = systemFaction == null ? null : systemFaction.pullString("Name");
		this.systemFactionState = systemFaction == null ? null : systemFaction.pullString("FactionState");
		this.factions = json.has("Factions") ? JournalUtils.createFactionsList(json.pullJSONArray("Factions")) : null;
		this.powerplayState = json.pullString("PowerplayState");
		this.starPos = JournalUtils.createPositionArray(json.pullJSONArray("StarPos"));
		this.systemAddress = json.pullLong("SystemAddress");
		this.population = json.pullLong("Population");
		this.marketID = json.pullLong("MarketID");
		this.bodyID = json.pullInt("BodyID");
		this.docked = json.pullBoolean("Docked");
		this.powers = json.has("Powers") ? JournalUtils.createPowersArray(json.pullJSONArray("Powers")) : null;
		this.stationServices = json.has("StationServices") ? JournalUtils.createStationServiceList(json.pullJSONArray("StationServices")) : null;
		this.stationEconomies = json.has("StationEconomies") ? JournalUtils.createStationEconomiesList(json.pullJSONArray("StationEconomies")) : null;
		this.stationAllegiance = json.pullString("StationAllegiance");
		this.stationGovernment = json.pullString("StationGovernment");
		this.stationEconomyLocalised = json.pullString("StationEconomy_Localised");
		this.stationGovernmentLocalised = json.pullString("StationGovernment_Localised");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public String getSystemFactionName() {
		return systemFactionName;
	}

	public String getSystemFactionState() {
		return systemFactionState;
	}

	public String getPowerplayState() {
		return powerplayState;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public String getStationEconomy() {
		return stationEconomy;
	}

	public String getStationFactionName() {
		return stationFactionName;
	}

	public String getStationFactionState() {
		return stationFactionState;
	}

	public String getStationAllegiance() {
		return stationAllegiance;
	}

	public String getStationGovernment() {
		return stationGovernment;
	}

	public String getStationEconomyLocalised() {
		return stationEconomyLocalised;
	}

	public String getStationGovernmentLocalised() {
		return stationGovernmentLocalised;
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

	public Boolean getDocked() {
		return docked;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public List<String> getPowers() {
		return powers;
	}

	public List<String> getStationServices() {
		return stationServices;
	}

	public List<StationEconomy> getStationEconomies() {
		return stationEconomies;
	}

}
