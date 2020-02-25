package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class MarketSellEvent extends Event {
	
	private Long marketID;
	private String type;
	private Integer count, sellPrice, totalSale, avgPricePaid;
	private Boolean illegalGoods, stolenGoods, blackMarket;
	
	public MarketSellEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketID = JsonTranslator.getLong(json, "MarketID");
		this.type = JsonTranslator.getString(json, "Type");
		this.count = JsonTranslator.getInteger(json, "Count");
		this.sellPrice = JsonTranslator.getInteger(json, "SellPrice");
		this.totalSale = JsonTranslator.getInteger(json, "TotalPrice");
		this.avgPricePaid = JsonTranslator.getInteger(json, "AvgPricePaid");
		this.illegalGoods = JsonTranslator.getBoolean(json, "IllegalGoods");
		this.stolenGoods = JsonTranslator.getBoolean(json, "StolenGoods");
		this.blackMarket = JsonTranslator.getBoolean(json, "BlackMarket");
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

	public Integer getSellPrice() {
		return sellPrice;
	}

	public Integer getTotalSale() {
		return totalSale;
	}

	public Integer getAvgPricePaid() {
		return avgPricePaid;
	}

	public Boolean getIllegalGoods() {
		return illegalGoods;
	}

	public Boolean getStolenGoods() {
		return stolenGoods;
	}

	public Boolean getBlackMarket() {
		return blackMarket;
	}

}
