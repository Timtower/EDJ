package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage3 extends ShipScanStage2 implements ScanStageInfo {
	
	String faction, legalStatus;

	public ShipScanStage3(boolean targetLocked, String ship, int scanStage, String pilotName, String pilotName_Localised, String pilotRank, double shieldHealth, double hullHealth,
			String faction,	String legalStatus) {
		super(targetLocked, ship, scanStage, pilotName, pilotName_Localised, pilotRank, shieldHealth, hullHealth);
		this.faction = faction;
		this.legalStatus = legalStatus;
	}

	public String getFaction() {
		return faction;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

}
