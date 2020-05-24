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
	Integer scanStage;
	
	public ShipTargetedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.scanStage = json.pullInt("ScanStage");
		this.json = json;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}
	
	public ScanStageInfo getScanStageInfo() {
		if(scanStage == 0) {
			return new ShipScanStage0(json.pullBoolean("TargetLocked"), json.pullString("Ship"), scanStage);
	 	}else if(scanStage == 1) {
	 		return new ShipScanStage1(json.pullBoolean("TargetLocked"), json.pullString("Ship"), scanStage, json.pullString("PilotName"), json.pullString("PilotName_Localised"),
	 				json.pullString("PilotRank"));
	 	}else if(scanStage == 2) {
			return new ShipScanStage2(json.pullBoolean("TargetLocked"), json.pullString("Ship"), scanStage, json.pullString("PilotName"), json.pullString("PilotName_Localised"),
	 				json.pullString("PilotRank"), json.getDouble("ShieldHealth"), json.getDouble("HullHealth"));
	 	}else if(scanStage == 3) {
	 		return new ShipScanStage3(json.pullBoolean("TargetLocked"), json.pullString("Ship"), scanStage, json.pullString("PilotName"), json.pullString("PilotName_Localised"),
	 				json.pullString("PilotRank"), json.getDouble("ShieldHealth"), json.getDouble("HullHealth"), json.pullString("Faction"), json.pullString("LegalStatus"));
	 	}
		return null;
	 }

}
