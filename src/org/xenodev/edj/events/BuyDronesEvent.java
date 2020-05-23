package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class BuyDronesEvent extends Event {
	
	private Integer count, buyPrice, totalPrice;
	private String type;
	
	public BuyDronesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.count = json.getInt("Count");
		this.buyPrice = json.getInt("BuyPrice");
		this.totalPrice = json.getInt("TotalPrice");
		this.type = json.getString("Type");
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
