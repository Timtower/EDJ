package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage2 extends ShipScanStage1 implements ScanStageInfo {
	
	double shieldHealth, hullHealth;

	public ShipScanStage2(boolean targetLocked, String ship, int scanStage, String pilotName, String pilotName_Localised, String pilotRank, double shieldHealth, double hullHealth) {
		super(targetLocked, ship, scanStage, pilotName, pilotName_Localised, pilotRank);
		this.shieldHealth = shieldHealth;
		this.hullHealth = hullHealth;
	}

	public double getShieldHealth() {
		return shieldHealth;
	}

	public double getHullHealth() {
		return hullHealth;
	}

}
