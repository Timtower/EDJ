package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class BuyAmmoEvent extends Event {
	
	private Integer cost;

	public BuyAmmoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.cost = json.pullInt("Cost");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCost() {
		return cost;
	}

}
