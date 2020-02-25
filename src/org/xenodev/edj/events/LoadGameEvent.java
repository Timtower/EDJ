package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class LoadGameEvent extends Event {
	
	String commander, FID, ship, shipName, shipIdent, gameMode;
	int shipId;
	double fuelLevel, fuelCapacity;
	long credits, loan;
	Boolean horizons;
	
	public LoadGameEvent(String timestamp, String commander, String FID, String ship, String shipName, String shipIdent,
			String gameMode, int shipId, double fuelLevel, double fuelCapacity, long credits, long loan,
			Boolean horizons) {
		super(timestamp);
		this.commander = commander;
		this.FID = FID;
		this.ship = ship;
		this.shipName = shipName;
		this.shipIdent = shipIdent;
		this.gameMode = gameMode;
		this.shipId = shipId;
		this.fuelLevel = fuelLevel;
		this.fuelCapacity = fuelCapacity;
		this.credits = credits;
		this.loan = loan;
		this.horizons = horizons;
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
	public void setFID(String FID) {
		this.FID = FID;
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
	public int getShipId() {
		return shipId;
	}
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	public double getFuelLevel() {
		return fuelLevel;
	}
	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	public double getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	public long getCredits() {
		return credits;
	}
	public void setCredits(long credits) {
		this.credits = credits;
	}
	public long getLoan() {
		return loan;
	}
	public void setLoan(long loan) {
		this.loan = loan;
	}
	public Boolean getHorizons() {
		return horizons;
	}
	public void setHorizons(Boolean horizons) {
		this.horizons = horizons;
	}

}
