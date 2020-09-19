package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class BuyDronesEvent extends Event {
	
	private Integer count, buyPrice, totalCost;
	private String type;
	
	public BuyDronesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.count = json.pullInt("Count");
		this.buyPrice = json.pullInt("BuyPrice");
		this.totalCost = json.pullInt("TotalCost");
		this.type = json.pullString("Type");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCount() {
		return count;
	}

	public Integer getBuyPrice() {
		return buyPrice;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public String getType() {
		return type;
	}

}
