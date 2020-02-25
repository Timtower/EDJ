package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage0 implements ScanStageInfo {
	
	boolean targetLocked;
	String ship;
	int scanStage;
	
	public ShipScanStage0(boolean targetLocked, String ship, int scanStage) {
		this.targetLocked = targetLocked;
		this.ship = ship;
		this.scanStage = scanStage;
	}

	public boolean isTargetLocked() {
		return targetLocked;
	}

	public String getShip() {
		return ship;
	}

	public int getScanStage() {
		return scanStage;
	}

}
