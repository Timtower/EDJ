package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.interfaces.ScanStageInfo;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage0;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage1;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage2;
import org.xenodev.edj.events.storage.shiptargeted.ShipScanStage3;
import org.xenodev.edj.utils.JournalUtils;

public class ShipTargetedEvent extends Event {

	JSONObject json;
	int scanStage;
	
	public ShipTargetedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.scanStage = json.pullInt("ScanStage");
		this.json = json;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}
	
	public ScanStageInfo getScanStageInfo() {
		if(scanStage == 0) {
			return new ShipScanStage0(json.getBoolean("TargetLocked"), json.getString("Ship"), scanStage);
	 	}else if(scanStage == 1) {
	 		return new ShipScanStage1(json.getBoolean("TargetLocked"), json.getString("Ship"), scanStage, json.getString("PilotName"), json.getString("PilotName_Localised"),
	 				json.getString("PilotRank"));
	 	}else if(scanStage == 2) {
			return new ShipScanStage2(json.getBoolean("TargetLocked"), json.getString("Ship"), scanStage, json.getString("PilotName"), json.getString("PilotName_Localised"),
	 				json.getString("PilotRank"), json.getDouble("ShieldHealth"), json.getDouble("HullHealth"));
	 	}else if(scanStage == 3) {
	 		return new ShipScanStage3(json.getBoolean("TargetLocked"), json.getString("Ship"), scanStage, json.getString("PilotName"), json.getString("PilotName_Localised"),
	 				json.getString("PilotRank"), json.getDouble("ShieldHealth"), json.getDouble("HullHealth"), json.getString("Faction"), json.getString("LegalStatus"));
	 	}
		return null;
	 }

}
