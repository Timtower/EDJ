package org.xenodev.edj.events.startup;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.Module;
import org.xenodev.edj.utils.JournalUtils;

public class LoadoutEvent extends Event {
	
	private String ship, shipName, shipIdent;
	private Integer shipID, hullValue, moduleValue, rebuy, cargoCapcity, main;
	private Double hullHealth, maxJumpRange, reserve, unladenMass;
	private List<Module> modules;
	
	public LoadoutEvent(String timestamp, JSONObject json) {
		super(timestamp);
		JSONObject fuelCapcity = json.pullJSONObject("FuelCapacity");
		
		this.ship = json.pullString("Ship");
		this.shipName = json.pullString("ShipName");
		this.shipIdent = json.pullString("ShipIdent");
		this.shipID = json.pullInt("ShipID");
		this.hullValue = json.pullInt("HullValue");
		this.moduleValue = json.pullInt("ModulesValue");
		this.hullHealth = json.pullDouble("HullHealth");
		this.rebuy = json.pullInt("Rebuy");
		this.maxJumpRange = json.pullDouble("MaxJumpRange");
		this.cargoCapcity = json.pullInt("CargoCapacity");
		this.main = fuelCapcity.getInt("Main");
		this.reserve = fuelCapcity.getDouble("Reserve");
		this.unladenMass = json.pullDouble("UnladenMass");
		this.modules = JournalUtils.createModuleList(json.pullJSONArray("Modules"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getShip() {
		return ship;
	}

	public String getShipName() {
		return shipName;
	}

	public String getShipIdent() {
		return shipIdent;
	}

	public Integer getShipID() {
		return shipID;
	}

	public Integer getHullValue() {
		return hullValue;
	}

	public Integer getModuleValue() {
		return moduleValue;
	}

	public Integer getRebuy() {
		return rebuy;
	}

	public Integer getCargoCapcity() {
		return cargoCapcity;
	}

	public Integer getMain() {
		return main;
	}

	public Double getHullHealth() {
		return hullHealth;
	}

	public Double getMaxJumpRange() {
		return maxJumpRange;
	}

	public Double getReserve() {
		return reserve;
	}

	public Double getUnladenMass() {
		return unladenMass;
	}

	public List<Module> getModules() {
		return modules;
	}

}
