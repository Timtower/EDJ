package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class MarketBuyEvent extends Event {
	
	private Long marketID;
	private String type;
	private Integer count, buyPrice, totalCost;
	
	public MarketBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketID = JsonTranslator.getLong(json, "MarketID");
		this.type = JsonTranslator.getString(json, "Type");
		this.count = JsonTranslator.getInteger(json, "Count");
		this.buyPrice = JsonTranslator.getInteger(json, "BuyPrice");
		this.totalCost = JsonTranslator.getInteger(json, "TotalCost");
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
