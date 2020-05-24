package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage2 extends ShipScanStage1 implements ScanStageInfo {
	
	double shieldHealth, hullHealth;

	public ShipScanStage2(Boolean targetLocked, String ship, Integer scanStage, String pilotName, String pilotName_Localised, String pilotRank, Double shieldHealth, Double hullHealth) {
		super(targetLocked, ship, scanStage, pilotName, pilotName_Localised, pilotRank);
		this.shieldHealth = shieldHealth;
		this.hullHealth = hullHealth;
	}

	public double getShieldHealth() {
		return shieldHealth;
	}

	public void setShieldHealth(double shieldHealth) {
		this.shieldHealth = shieldHealth;
	}

	public double getHullHealth() {
		return hullHealth;
	}

	public void setHullHealth(double hullHealth) {
		this.hullHealth = hullHealth;
	}

}
