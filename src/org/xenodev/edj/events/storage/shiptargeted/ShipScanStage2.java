package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage2 extends ShipScanStage1 implements ScanStageInfo {
	
	Double shieldHealth, hullHealth;


	public ShipScanStage2(Boolean targetLocked, String ship, Integer scanStage, String pilotName,
			String pilotNameLocalised, String pilotRank, String shipLocalised, String power, Double shieldHealth,
			Double hullHealth) {
		super(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power);
		this.shieldHealth = shieldHealth;
		this.hullHealth = hullHealth;
	}

	public double getShieldHealth() {
		return shieldHealth;
	}

	public void setShieldHealth(Double shieldHealth) {
		this.shieldHealth = shieldHealth;
	}

	public Double getHullHealth() {
		return hullHealth;
	}

	public void setHullHealth(Double hullHealth) {
		this.hullHealth = hullHealth;
	}

}
