package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class LoadGameEvent extends Event {
	
	String commander, FID, ship, shipName, shipIdent, gameMode;
	Integer shipId;
	Double fuelLevel, fuelCapacity;
	Long credits, loan;
	Boolean horizons;
	
	public LoadGameEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.commander = json.getString("Commander");
		this.FID = json.getString("FID");
		this.ship = json.getString("Ship");
		this.shipName = json.getString("ShipName");
		this.shipIdent = json.getString("ShipIdent");
		this.gameMode = json.getString("GameMode");
		this.shipId = json.getInt("ShipID");
		this.fuelLevel = json.getDouble("FuelLevel");
		this.fuelCapacity = json.getDouble("FuelCapacity");
		this.credits = json.getLong("Credits");
		this.loan = json.getLong("Loan");
		this.horizons = json.getBoolean("Horizons");
		
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

}
