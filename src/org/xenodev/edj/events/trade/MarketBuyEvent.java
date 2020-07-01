package org.xenodev.edj.events.trade;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MarketBuyEvent extends Event {
	
	private Long marketID;
	private String type, typeLocalised;
	private Integer count, buyPrice, totalCost;
	
	public MarketBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketID = json.pullLong("MarketID");
		this.type = json.pullString("Type");
		this.typeLocalised = json.pullString("Type_Localised");
		this.count = json.pullInt("Count");
		this.buyPrice = json.pullInt("BuyPrice");
		this.totalCost = json.pullInt("TotalCost");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketID() {
		return marketID;
	}

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
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
