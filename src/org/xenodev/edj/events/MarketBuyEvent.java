package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MarketBuyEvent extends Event {
	
	private Long marketID;
	private String type;
	private Integer count, buyPrice, totalCost;
	
	public MarketBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketID = json.getLong("MarketID");
		this.type = json.getString("Type");
		this.count = json.getInt("Count");
		this.buyPrice = json.getInt("BuyPrice");
		this.totalCost = json.getInt("TotalCost");
	}

	public Long getMarketID() {
		return marketID;
	}

	public String getType() {
		return type;
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

}
