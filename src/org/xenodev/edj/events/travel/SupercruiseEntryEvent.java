package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SupercruiseEntryEvent extends Event {
	
	String starSystem;
	Long SystemAddress;
	
	public SupercruiseEntryEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.pullString("StarSystem");
		this.SystemAddress = json.pullLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public Long getSystemAddress() {
		return SystemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		SystemAddress = systemAddress;
	}

}
