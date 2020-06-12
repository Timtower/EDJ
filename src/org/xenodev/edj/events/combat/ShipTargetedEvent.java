package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.interfaces.ScanStageInfo;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage0;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage1;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage2;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage3;
import org.xenodev.edj.utils.JournalUtils;

public class ShipTargetedEvent extends Event {

	private Integer scanStage;
	private Boolean targetLocked;
	private String ship, shipLocalised, pilotName, pilotNameLocalised, pilotRank, faction, legalStatus, power;
	private Double shieldHealth, hullHealth;
	private Long bounty;
	
	public ShipTargetedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.scanStage = json.pullInt("ScanStage");
		this.bounty = json.pullLong("Bounty");
		this.targetLocked = json.pullBoolean("TargetLocked");
		this.ship = json.pullString("Ship");
		this.shipLocalised = json.pullString("Ship_Localised");
		this.pilotName = json.pullString("PilotName");
		this.pilotNameLocalised = json.pullString("PilotName_Localised");
		this.pilotRank = json.pullString("PilotRank");
		this.shieldHealth = json.pullDouble("ShieldHealth");
		this.hullHealth = json.pullDouble("HullHealth");
		this.faction = json.pullString("Faction");
		this.legalStatus = json.pullString("LegalStatus");
		this.power = json.pullString("Power");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}
	
	public ScanStageInfo getScanStageInfo() {
		if(scanStage == 0) {
			return new ShipScanStage0(targetLocked, ship, scanStage);
	 	}else if(scanStage == 1) {
	 		return new ShipScanStage1(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power);
	 	}else if(scanStage == 2) {
			return new ShipScanStage2(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power, shieldHealth, hullHealth);
		}else if(scanStage == 3) {
	 		return new ShipScanStage3(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power, shieldHealth, hullHealth, faction, legalStatus, bounty);
	 	}
		return null;
	 }

}
