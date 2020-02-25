package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class BuyAmmoEvent extends Event {
	
	private Integer cost;

	public BuyAmmoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cost = JsonTranslator.getInteger(json, "Cost");
	}

	public Integer getCost() {
		return cost;
	}

}
