package org.xenodev.edj.events.storage.shiptargeted;

import org.xenodev.edj.events.interfaces.ScanStageInfo;

public class ShipScanStage3 extends ShipScanStage2 implements ScanStageInfo {
	
	private String faction, legalStatus;
	private Long bounty;

	public ShipScanStage3(Boolean targetLocked, String ship, Integer scanStage, String pilotName,
			String pilotNameLocalised, String pilotRank, String shipLocalised, String power, Double shieldHealth,
			Double hullHealth, String faction, String legalStatus, Long bounty) {
		super(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power,
				shieldHealth, hullHealth);
		this.faction = faction;
		this.legalStatus = legalStatus;
		this.bounty = bounty;
	}

	public Long getBounty() {
		return bounty;
	}

	public void setBounty(Long bounty) {
		this.bounty = bounty;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

}
