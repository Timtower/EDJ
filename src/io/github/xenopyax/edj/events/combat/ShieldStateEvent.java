package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ShieldStateEvent extends Event {
	
	private Boolean shieldsUp;

	public ShieldStateEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shieldsUp = json.pullBoolean("ShieldsUp");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Boolean isShieldsUp() {
		return shieldsUp;
	}

}
