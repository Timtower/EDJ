package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class BuyTradeDataEvent extends Event {
	
	private String system;
	private Integer cost;
	
	public BuyTradeDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.system = json.getString("System");
		this.cost = json.getInt("Cost");
	}
	
	public String getSystem() {
		return system;
	}
	
	public Integer getCost() {
		return cost;
	}
	
}
