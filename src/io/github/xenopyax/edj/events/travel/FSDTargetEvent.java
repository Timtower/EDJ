package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class FSDTargetEvent extends Event {
	
	private String name, starClass;
	private Long systemAdress;
	private Integer remainingJumpsInRoute;
	
	public FSDTargetEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.systemAdress = json.pullLong("SystemAddress");
		this.remainingJumpsInRoute = json.pullInt("RemainingJumpsInRoute");
		this.starClass = json.pullString("StarClass");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public String getStarClass() {
		return starClass;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Integer getRemainingJumpsInRoute() {
		return remainingJumpsInRoute;
	}

}
