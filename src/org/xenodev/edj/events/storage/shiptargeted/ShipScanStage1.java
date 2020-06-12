package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage1 extends ShipScanStage0 implements ScanStageInfo {
	
	String pilotName, pilotNameLocalised, pilotRank, shipLocalised, power;

	public ShipScanStage1(Boolean targetLocked, String ship, Integer scanStage, String pilotName,
			String pilotNameLocalised, String pilotRank, String shipLocalised, String power) {
		super(targetLocked, ship, scanStage);
		this.pilotName = pilotName;
		this.pilotNameLocalised = pilotNameLocalised;
		this.pilotRank = pilotRank;
		this.shipLocalised = shipLocalised;
		this.power = power;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getPilotNameLocalised() {
		return pilotNameLocalised;
	}

	public void setPilotNameLocalised(String pilotNameLocalised) {
		this.pilotNameLocalised = pilotNameLocalised;
	}

	public String getPilotRank() {
		return pilotRank;
	}

	public void setPilotRank(String pilotRank) {
		this.pilotRank = pilotRank;
	}

	public String getShipLocalised() {
		return shipLocalised;
	}

	public void setShipLocalised(String shipLocalised) {
		this.shipLocalised = shipLocalised;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	
	
}
