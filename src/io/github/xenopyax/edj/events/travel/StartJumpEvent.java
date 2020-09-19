package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class StartJumpEvent extends Event {
	
	private String jumpType, starSystem, starClass;
	private Long systemAddress;
	
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

	public String getStarSystem() {
		return starSystem;
	}

	public String getStarClass() {
		return starClass;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}
	
}
