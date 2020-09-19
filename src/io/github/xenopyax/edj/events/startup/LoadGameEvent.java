package io.github.xenopyax.edj.events.startup;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class LoadGameEvent extends Event {
	
	private String commander, FID, ship, shipLocalised, shipName, shipIdent, gameMode, group;
	private Integer shipId;
	private Double fuelLevel, fuelCapacity;
	private Long credits, loan;
	private Boolean horizons;
	
	public LoadGameEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.commander = json.pullString("Commander");
		this.FID = json.pullString("FID");
		this.ship = json.pullString("Ship");
		this.shipLocalised = json.pullString("Ship_Localised");
		this.shipName = json.pullString("ShipName");
		this.shipIdent = json.pullString("ShipIdent");
		this.gameMode = json.pullString("GameMode");
		this.shipId = json.pullInt("ShipID");
		this.fuelLevel = json.pullDouble("FuelLevel");
		this.fuelCapacity = json.pullDouble("FuelCapacity");
		this.credits = json.pullLong("Credits");
		this.loan = json.pullLong("Loan");
		this.group = json.has("Group") ? json.pullString("Group") : null;
		this.horizons = json.pullBoolean("Horizons");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getCommander() {
		return commander;
	}

	public String getFID() {
		return FID;
	}

	public String getShip() {
		return ship;
	}

	public String getShipLocalised() {
		return shipLocalised;
	}

	public String getShipName() {
		return shipName;
	}

	public String getShipIdent() {
		return shipIdent;
	}

	public String getGameMode() {
		return gameMode;
	}

	public String getGroup() {
		return group;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public Double getFuelCapacity() {
		return fuelCapacity;
	}

	public Long getCredits() {
		return credits;
	}

	public Long getLoan() {
		return loan;
	}

	public Boolean getHorizons() {
		return horizons;
	}

}
