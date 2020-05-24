package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage0 implements ScanStageInfo {
	
	Boolean targetLocked;
	String ship;
	Integer scanStage;
	
	public ShipScanStage0(Boolean targetLocked, String ship, Integer scanStage) {
		this.targetLocked = targetLocked;
		this.ship = ship;
		this.scanStage = scanStage;
	}

	public Boolean getTargetLocked() {
		return targetLocked;
	}

	public void setTargetLocked(Boolean targetLocked) {
		this.targetLocked = targetLocked;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Integer getScanStage() {
		return scanStage;
	}

	public void setScanStage(Integer scanStage) {
		this.scanStage = scanStage;
	}
	
}
