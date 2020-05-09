package org.xenodev.edj.events;

import java.util.List;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Faction;

public class FSDJumpEvent extends Event {
	
	String starSystem, systemAllegiance, systemEconomy, systemEconomyLocalised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernmentLocalised, systemSecurity, systemSecurityLocalised;
	Long population, systemAddress;
	Double jumpDistance, fuelUsed, fuelLevel;
	List<Faction> factions;
	Double[] starPos;
	
	public FSDJumpEvent(String timestamp, String starSystem, String systemAllegiance, String systemEconomy,
			String systemEconomyLocalised, String systemSecondEconomy, String systemSecondEconomy_Localised,
			String systemGovernment, String systemGovernmentLocalised, String systemSecurity,
			String systemSecurityLocalised, Long population, Long systemAddress, Double jumpDistance, Double fuelUsed,
			Double fuelLevel, List<Faction> factions, Double[] starPos) {
		super(timestamp);
		this.starSystem = starSystem;
		this.systemAllegiance = systemAllegiance;
		this.systemEconomy = systemEconomy;
		this.systemEconomyLocalised = systemEconomyLocalised;
		this.systemSecondEconomy = systemSecondEconomy;
		this.systemSecondEconomy_Localised = systemSecondEconomy_Localised;
		this.systemGovernment = systemGovernment;
		this.systemGovernmentLocalised = systemGovernmentLocalised;
		this.systemSecurity = systemSecurity;
		this.systemSecurityLocalised = systemSecurityLocalised;
		this.population = population;
		this.systemAddress = systemAddress;
		this.jumpDistance = jumpDistance;
		this.fuelUsed = fuelUsed;
		this.fuelLevel = fuelLevel;
		this.factions = factions;
		this.starPos = starPos;
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

	public String getSystemEconomyLocalised() {
		return systemEconomyLocalised;
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

	public String getSystemGovernmentLocalised() {
		return systemGovernmentLocalised;
	}

	public String getSystemSecurity() {
		return systemSecurity;
	}

	public String getSystemSecurityLocalised() {
		return systemSecurityLocalised;
	}

	public Long getPopulation() {
		return population;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Double getJumpDistance() {
		return jumpDistance;
	}

	public Double getFuelUsed() {
		return fuelUsed;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public Double[] getStarPos() {
		return starPos;
	}
	
}
