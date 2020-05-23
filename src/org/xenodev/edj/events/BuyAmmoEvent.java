package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class BuyAmmoEvent extends Event {
	
	private Integer cost;

	public BuyAmmoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cost = json.getInt("Cost");
	}

	public Integer getCost() {
		return cost;
	}

}
