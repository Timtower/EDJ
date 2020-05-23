package org.xenodev.edj.events;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Faction;
import org.xenodev.edj.utils.JournalUtils;

public class LocationEvent extends Event {
	
	String starSystem, systemAllegiance, systemEconomy, systemEconomy_Localised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernment_Localised, systemSecurity, systemSecurity_Localised, body, bodyType, systemFaction_Name, systemFaction_State, powerplayState;
	Double[] starPos;
	Long systemAddress, population, marketID;
	Integer bodyID;
	Boolean docked;
	List<Faction> factions;
	List<String> powers;
	
	public LocationEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.getString("StarSystem");
		this.systemAllegiance = json.getString("SystemAllegiance");
		this.systemEconomy = json.getString("SystemEconomy");
		this.systemEconomy_Localised = json.getString("SystemEconomy_Localised");
		this.systemSecondEconomy = json.getString("SystemSecondEconomy");
		this.systemSecondEconomy_Localised = json.getString("SystemSecondEconomy_Localised");
		this.systemGovernment = json.getString("SystemGovernment");
		this.systemGovernment_Localised = json.getString("SystemGovernment_Localised");
		this.systemSecurity = json.getString("SystemSecurity");
		this.systemSecurity_Localised = json.getString("SystemSecurity_Localised");
		this.body = json.getString("Body");
		this.bodyType = json.getString("BodyType");
		this.systemFaction_Name = json.getJSONObject("SystemFaction").getString("FactionName");
		this.systemFaction_State = json.getJSONObject("SystemFaction").getString("FactionState");
		this.powerplayState = json.getString("PowerplayState");
		this.starPos = JournalUtils.createPositionArray(json.getJSONArray("StarPos"));
		this.systemAddress = json.getLong("SystemAddress");
		this.population = json.getLong("Population");
		this.marketID = json.getLong("MarketID");
		this.bodyID = json.getInt("BodyID");
		this.docked = json.getBoolean("Docked");
		this.factions = json.has("Factions") ? JournalUtils.createFactionList(json.getJSONArray("Factions")) : null;
		this.powers = json.has("Powers") ? JournalUtils.createPowersArray(json.getJSONArray("Powers")) : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public String getSystemAllegiance() {
		return systemAllegiance;
	}

	public void setSystemAllegiance(String systemAllegiance) {
		this.systemAllegiance = systemAllegiance;
	}

	public String getSystemEconomy() {
		return systemEconomy;
	}

	public void setSystemEconomy(String systemEconomy) {
		this.systemEconomy = systemEconomy;
	}

	public String getSystemEconomy_Localised() {
		return systemEconomy_Localised;
	}

	public void setSystemEconomy_Localised(String systemEconomy_Localised) {
		this.systemEconomy_Localised = systemEconomy_Localised;
	}

	public String getSystemSecondEconomy() {
		return systemSecondEconomy;
	}

	public void setSystemSecondEconomy(String systemSecondEconomy) {
		this.systemSecondEconomy = systemSecondEconomy;
	}

	public String getSystemSecondEconomy_Localised() {
		return systemSecondEconomy_Localised;
	}

	public void setSystemSecondEconomy_Localised(String systemSecondEconomy_Localised) {
		this.systemSecondEconomy_Localised = systemSecondEconomy_Localised;
	}

	public String getSystemGovernment() {
		return systemGovernment;
	}

	public void setSystemGovernment(String systemGovernment) {
		this.systemGovernment = systemGovernment;
	}

	public String getSystemGovernment_Localised() {
		return systemGovernment_Localised;
	}

	public void setSystemGovernment_Localised(String systemGovernment_Localised) {
		this.systemGovernment_Localised = systemGovernment_Localised;
	}

	public String getSystemSecurity() {
		return systemSecurity;
	}

	public void setSystemSecurity(String systemSecurity) {
		this.systemSecurity = systemSecurity;
	}

	public String getSystemSecurity_Localised() {
		return systemSecurity_Localised;
	}

	public void setSystemSecurity_Localised(String systemSecurity_Localised) {
		this.systemSecurity_Localised = systemSecurity_Localised;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getSystemFaction_Name() {
		return systemFaction_Name;
	}

	public void setSystemFaction_Name(String systemFaction_Name) {
		this.systemFaction_Name = systemFaction_Name;
	}

	public String getSystemFaction_State() {
		return systemFaction_State;
	}

	public void setSystemFaction_State(String systemFaction_State) {
		this.systemFaction_State = systemFaction_State;
	}

	public String getPowerplayState() {
		return powerplayState;
	}

	public void setPowerplayState(String powerplayState) {
		this.powerplayState = powerplayState;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public void setStarPos(Double[] starPos) {
		this.starPos = starPos;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getMarketID() {
		return marketID;
	}

	public void setMarketID(Long marketID) {
		this.marketID = marketID;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

	public Boolean getDocked() {
		return docked;
	}

	public void setDocked(Boolean docked) {
		this.docked = docked;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public void setFactions(List<Faction> factions) {
		this.factions = factions;
	}

	public List<String> getPowers() {
		return powers;
	}

	public void setPowers(List<String> powers) {
		this.powers = powers;
	}
	
}
