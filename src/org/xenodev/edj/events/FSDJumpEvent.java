package org.xenodev.edj.events;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Faction;
import org.xenodev.edj.utils.JournalUtils;

public class FSDJumpEvent extends Event {
	
	String starSystem, systemAllegiance, systemEconomy, systemEconomyLocalised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernmentLocalised, systemSecurity, systemSecurityLocalised;
	Long population, systemAddress;
	Double jumpDistance, fuelUsed, fuelLevel;
	List<Faction> factions;
	Double[] starPos;
	
	public FSDJumpEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.pullString("StarSystem");
		this.systemAllegiance = json.pullString("SystemAllegiance");
		this.systemEconomy = json.pullString("SystemEconomy");
		this.systemEconomyLocalised = json.pullString("SystemEconomy_Localised");
		this.systemSecondEconomy = json.pullString("SystemSecondEconomy");
		this.systemSecondEconomy_Localised = json.pullString("SystemSecondEconomy_Localised");
		this.systemGovernment = json.pullString("SystemGovernment");
		this.systemGovernmentLocalised = json.pullString("SystemGovernment_Localised");
		this.systemSecurity = json.pullString("SystemSecurity");
		this.systemSecurityLocalised = json.pullString("SystemSecurity_Localised");
		this.population = json.pullLong("Population");
		this.systemAddress = json.pullLong("SystemAddress");
		this.jumpDistance = json.getDouble("JumpDist");
		this.fuelUsed = json.getDouble("FuelUsed");
		this.fuelLevel = json.getDouble("FuelLevel");
		this.starPos = JournalUtils.createPositionArray(json.getJSONArray("StarPos"));
		
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

	public String getSystemEconomyLocalised() {
		return systemEconomyLocalised;
	}

	public void setSystemEconomyLocalised(String systemEconomyLocalised) {
		this.systemEconomyLocalised = systemEconomyLocalised;
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

	public String getSystemGovernmentLocalised() {
		return systemGovernmentLocalised;
	}

	public void setSystemGovernmentLocalised(String systemGovernmentLocalised) {
		this.systemGovernmentLocalised = systemGovernmentLocalised;
	}

	public String getSystemSecurity() {
		return systemSecurity;
	}

	public void setSystemSecurity(String systemSecurity) {
		this.systemSecurity = systemSecurity;
	}

	public String getSystemSecurityLocalised() {
		return systemSecurityLocalised;
	}

	public void setSystemSecurityLocalised(String systemSecurityLocalised) {
		this.systemSecurityLocalised = systemSecurityLocalised;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

	public Double getJumpDistance() {
		return jumpDistance;
	}

	public void setJumpDistance(Double jumpDistance) {
		this.jumpDistance = jumpDistance;
	}

	public Double getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(Double fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public void setFactions(List<Faction> factions) {
		this.factions = factions;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public void setStarPos(Double[] starPos) {
		this.starPos = starPos;
	}

}
