package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.interfaces.ScanInfo;
import org.xenodev.edj.events.storage.scan.PlanetScan;
import org.xenodev.edj.events.storage.scan.StarScan;
import org.xenodev.edj.utils.JsonTranslator;

public class ScanEvent extends Event {
	
	String scanType;
	Boolean star;
	JSONObject json;
	
	public ScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.json = json;
		this.scanType = JsonTranslator.getString(json, "ScanType");
		this.star = json.has("StarType");
	}
	
	public ScanInfo getInfo() {
		if(star) {
			return new StarScan(json);
		}
		
		return new PlanetScan(json);
	}

	public String getScanType() {
		return scanType;
	}

}
