package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class BuyDronesEvent extends Event {
	
	private Integer count, buyPrice, totalPrice;
	private String type;
	
	public BuyDronesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.count = JsonTranslator.getInteger(json, "Count");
		this.buyPrice = JsonTranslator.getInteger(json, "BuyPrice");
		this.totalPrice = JsonTranslator.getInteger(json, "TotalPrice");
		this.type = JsonTranslator.getString(json, "Type");
	}

	public Integer getCount() {
		return count;
	}

	public Integer getBuyPrice() {
		return buyPrice;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public String getType() {
		return type;
	}

}
