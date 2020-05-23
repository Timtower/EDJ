package org.xenodev.edj.events;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Module;
import org.xenodev.edj.utils.JournalUtils;

public class LoadoutEvent extends Event {
	
	String ship, shipName, shipIdent;
	Integer shipID, hullValue, moduleValue, rebuy;
	Double hullHealth;
	List<Module> modules;
	
	public LoadoutEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.ship = json.getString("Ship");
		this.shipName = json.getString("ShipName");
		this.shipIdent = json.getString("ShipIdent");
		this.shipID = json.getInt("ShipID");
		this.hullValue = json.getInt("HullValue");
		this.moduleValue = json.getInt("ModulesValue");
		this.hullHealth = json.getDouble("HullHealth");
		this.rebuy = json.getInt("Rebuy");
		this.modules = JournalUtils.createModuleList(json.getJSONArray("Modules"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public Integer getShipID() {
		return shipID;
	}

	public void setShipID(Integer shipID) {
		this.shipID = shipID;
	}

	public Integer getHullValue() {
		return hullValue;
	}

	public void setHullValue(Integer hullValue) {
		this.hullValue = hullValue;
	}

	public Integer getModuleValue() {
		return moduleValue;
	}

	public void setModuleValue(Integer moduleValue) {
		this.moduleValue = moduleValue;
	}

	public Integer getRebuy() {
		return rebuy;
	}

	public void setRebuy(Integer rebuy) {
		this.rebuy = rebuy;
	}

	public Double getHullHealth() {
		return hullHealth;
	}

	public void setHullHealth(Double hullHealth) {
		this.hullHealth = hullHealth;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
}
