package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.shiptargeted.ShipScanStage0;
import io.github.xenopyax.edj.events.datastorage.shiptargeted.ShipScanStage1;
import io.github.xenopyax.edj.events.datastorage.shiptargeted.ShipScanStage2;
import io.github.xenopyax.edj.events.datastorage.shiptargeted.ShipScanStage3;
import io.github.xenopyax.edj.events.interfaces.ScanStageInfo;
import io.github.xenopyax.edj.utils.JournalUtils;

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
