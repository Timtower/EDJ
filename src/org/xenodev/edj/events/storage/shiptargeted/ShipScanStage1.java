package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage1 extends ShipScanStage0 implements ScanStageInfo {
	
	String pilotName, pilotName_Localised, pilotRank;

	public ShipScanStage1(Boolean targetLocked, String ship, Integer scanStage, String pilotName, String pilotName_Localised, String pilotRank) {
		super(targetLocked, ship, scanStage);
		this.pilotName = pilotName;
		this.pilotName_Localised = pilotName_Localised;
		this.pilotRank = pilotRank;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getPilotName_Localised() {
		return pilotName_Localised;
	}

	public void setPilotName_Localised(String pilotName_Localised) {
		this.pilotName_Localised = pilotName_Localised;
	}

	public String getPilotRank() {
		return pilotRank;
	}

	public void setPilotRank(String pilotRank) {
		this.pilotRank = pilotRank;
	}

}
