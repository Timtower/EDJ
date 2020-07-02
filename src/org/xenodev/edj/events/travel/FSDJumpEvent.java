package org.xenodev.edj.events.travel;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.Conflict;
import org.xenodev.edj.events.datastorage.Faction;
import org.xenodev.edj.utils.JournalUtils;

public class FSDJumpEvent extends Event {
	
	private String starSystem, systemAllegiance, systemEconomy, systemEconomyLocalised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernmentLocalised,
	systemSecurity, systemSecurityLocalised, body, bodyType, powerplayState, systemfactionName, systemfactionState;
	private Long population, systemAddress, boostUsed;
	private Integer bodyId;
	private Double jumpDistance, fuelUsed, fuelLevel;
	private List<Faction> factions;
	private Conflict conflict;
	private Double[] starPos;
	private List<String> powers;
	
	public FSDJumpEvent(String timestamp, JSONObject json) {
		super(timestamp);
		JSONObject systemFaction = json.has("SystemFaction") ? json.pullJSONObject("SystemFaction") : null;
		
		this.body = json.pullString("Body");
		this.bodyId = json.pullInt("BodyID");
		this.bodyType = json.pullString("BodyType");
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
		this.jumpDistance = json.pullDouble("JumpDist");
		this.fuelUsed = json.pullDouble("FuelUsed");
		this.fuelLevel = json.pullDouble("FuelLevel");
		this.boostUsed = json.pullLong("BoostUsed");
		this.powers = json.has("Powers") ? JournalUtils.createPowersArray(json.pullJSONArray("Powers")) : null;
		this.systemfactionName = systemFaction != null ? systemFaction.getString("Name") : null;
		this.systemfactionState = systemFaction != null ? systemFaction.getString("FactionState") : null;
		this.starPos = JournalUtils.createPositionArray(json.pullJSONArray("StarPos"));
		this.factions = json.has("Factions") ? JournalUtils.createFactionsList(json.pullJSONArray("Factions")) : null;
		this.conflict = json.has("Conflicts") ? JournalUtils.createConflict(json.pullJSONArray("Conflicts")) : null;
		this.powerplayState = json.pullString("PowerplayState");
		
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

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getPowerplayState() {
		return powerplayState;
	}

	public String getSystemfactionName() {
		return systemfactionName;
	}

	public String getSystemfactionState() {
		return systemfactionState;
	}

	public Long getPopulation() {
		return population;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Long getBoostUsed() {
		return boostUsed;
	}

	public Integer getBodyId() {
		return bodyId;
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

	public Conflict getConflict() {
		return conflict;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public List<String> getPowers() {
		return powers;
	}

}
