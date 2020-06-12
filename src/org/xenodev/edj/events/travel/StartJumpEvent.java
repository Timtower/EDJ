package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class StartJumpEvent extends Event {
	
	String jumpType, starSystem, starClass;
	Long systemAddress;
	
	public StartJumpEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.jumpType = json.pullString("JumpType");
		this.starSystem = json.pullString("StarSystem");
		this.starClass = json.pullString("StarClass");
		this.systemAddress = json.pullLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getJumpType() {
		return jumpType;
	}

	public void setJumpType(String jumpType) {
		this.jumpType = jumpType;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public String getStarClass() {
		return starClass;
	}

	public void setStarClass(String starClass) {
		this.starClass = starClass;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}
	
}
