package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShieldStateEvent extends Event {
	
	Boolean shieldsUp;

	public ShieldStateEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shieldsUp = json.pullBoolean("ShieldsUp");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Boolean isShieldsUp() {
		return shieldsUp;
	}

	public void setShieldsUp(Boolean shieldsUp) {
		this.shieldsUp = shieldsUp;
	}

}
