package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class LoadGameEvent extends Event {
	
	String commander, FID, ship, shipLocalised, shipName, shipIdent, gameMode, group;
	Integer shipId;
	Double fuelLevel, fuelCapacity;
	Long credits, loan;
	Boolean horizons;
	
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

	public void setCommander(String commander) {
		this.commander = commander;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipIdent() {
		return shipIdent;
	}

	public void setShipIdent(String shipIdent) {
		this.shipIdent = shipIdent;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public Double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(Double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public Long getCredits() {
		return credits;
	}

	public void setCredits(Long credits) {
		this.credits = credits;
	}

	public Long getLoan() {
		return loan;
	}

	public void setLoan(Long loan) {
		this.loan = loan;
	}

	public Boolean getHorizons() {
		return horizons;
	}

	public void setHorizons(Boolean horizons) {
		this.horizons = horizons;
	}

	public String getShipLocalised() {
		return shipLocalised;
	}

	public void setShipLocalised(String shipLocalised) {
		this.shipLocalised = shipLocalised;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
