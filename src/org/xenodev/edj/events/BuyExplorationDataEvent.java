package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class BuyExplorationDataEvent extends Event {
	
	private String system;
	private Integer cost;
	
	public BuyExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.system = JsonTranslator.getString(json, "System");
		this.cost = JsonTranslator.getInteger(json, "Cost");
	}

	public String getSystem() {
		return system;
	}

	public Integer getCost() {
		return cost;
	}

}
