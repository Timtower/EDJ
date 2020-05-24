package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MarketBuyEvent extends Event {
	
	private Long marketID;
	private String type;
	private Integer count, buyPrice, totalCost;
	
	public MarketBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketID = json.pullLong("MarketID");
		this.type = json.pullString("Type");
		this.count = json.pullInt("Count");
		this.buyPrice = json.pullInt("BuyPrice");
		this.totalCost = json.pullInt("TotalCost");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketID() {
		return marketID;
	}

	public void setMarketID(Long marketID) {
		this.marketID = marketID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
