package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class SupercruiseEntryEvent extends Event {
	
	private String starSystem;
	private Long SystemAddress;
	
	public SupercruiseEntryEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.starSystem = json.pullString("StarSystem");
		this.SystemAddress = json.pullLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Long getSystemAddress() {
		return SystemAddress;
	}

}
