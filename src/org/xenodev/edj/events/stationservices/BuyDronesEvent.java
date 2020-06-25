package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Integer buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
