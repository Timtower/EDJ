package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MarketSellEvent extends Event {
	
	private Long marketID;
	private String type;
	private Integer count, sellPrice, totalSale, avgPricePaid;
	private Boolean illegalGoods, stolenGoods, blackMarket;
	
	public MarketSellEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketID = json.getLong("MarketID");
		this.type = json.getString("Type");
		this.count = json.getInt("Count");
		this.sellPrice = json.getInt("SellPrice");
		this.totalSale = json.getInt("TotalPrice");
		this.avgPricePaid = json.getInt("AvgPricePaid");
		this.illegalGoods = json.getBoolean("IllegalGoods");
		this.stolenGoods = json.getBoolean("StolenGoods");
		this.blackMarket = json.getBoolean("BlackMarket");
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
