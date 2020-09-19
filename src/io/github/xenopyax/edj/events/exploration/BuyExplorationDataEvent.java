package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class BuyExplorationDataEvent extends Event {
	
	private String system;
	private Integer cost;
	
	public BuyExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.system = json.pullString("System");
		this.cost = json.pullInt("Cost");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSystem() {
		return system;
	}

	public Integer getCost() {
		return cost;
	}

}
