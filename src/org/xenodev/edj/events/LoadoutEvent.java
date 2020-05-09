package org.xenodev.edj.events;

import java.util.ArrayList;
import java.util.List;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Module;

public class LoadoutEvent extends Event {
	
	String ship, shipName, shipIdent;
	Integer shipID, hullValue, moduleValue, rebuy;
	Double hullHealth;
	List<Module> modules;
	
	public LoadoutEvent(String timestamp, String ship, String shipName, String shipIdent, int shipID, int hullValue, int moduleValue, double hullHealth, int rebuy, List<Module> modules) {
		super(timestamp);
		this.ship = ship;
		this.shipName = shipName;
		this.shipIdent = shipIdent;
		this.shipID = shipID;
		this.hullValue = hullValue;
		this.moduleValue = moduleValue;
		this.hullHealth = hullHealth;
		this.rebuy = rebuy;
		this.modules = modules;
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

	public int getShipID() {
		return shipID;
	}

	public void setShipID(int shipID) {
		this.shipID = shipID;
	}

	public int getHullValue() {
		return hullValue;
	}

	public void setHullValue(int hullValue) {
		this.hullValue = hullValue;
	}

	public int getModuleValue() {
		return moduleValue;
	}

	public void setModuleValue(int moduleValue) {
		this.moduleValue = moduleValue;
	}

	public double getHullHealth() {
		return hullHealth;
	}

	public void setHullHealth(double hullHealth) {
		this.hullHealth = hullHealth;
	}

	public int getRebuy() {
		return rebuy;
	}

	public void setRebuy(int rebuy) {
		this.rebuy = rebuy;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	

}
