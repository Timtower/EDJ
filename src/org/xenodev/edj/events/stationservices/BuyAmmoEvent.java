package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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
