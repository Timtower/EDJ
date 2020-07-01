package org.xenodev.edj.events.trade;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MarketSellEvent extends Event {
	
	private Long marketID;
	private String type, typeLocalised;
	private Integer count, sellPrice, totalSale, avgPricePaid;
	private Boolean illegalGoods, stolenGoods, blackMarket;
	
	public MarketSellEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketID = json.pullLong("MarketID");
		this.type = json.pullString("Type");
		this.typeLocalised = json.pullString("Type_Localised");
		this.count = json.pullInt("Count");
		this.sellPrice = json.pullInt("SellPrice");
		this.totalSale = json.pullInt("TotalSale");
		this.avgPricePaid = json.pullInt("AvgPricePaid");
		this.illegalGoods = json.pullBoolean("IllegalGoods");
		this.stolenGoods = json.pullBoolean("StolenGoods");
		this.blackMarket = json.pullBoolean("BlackMarket");
		
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
