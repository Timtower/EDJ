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

	public Integer getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(Integer totalSale) {
		this.totalSale = totalSale;
	}

	public Integer getAvgPricePaid() {
		return avgPricePaid;
	}

	public void setAvgPricePaid(Integer avgPricePaid) {
		this.avgPricePaid = avgPricePaid;
	}

	public Boolean getIllegalGoods() {
		return illegalGoods;
	}

	public void setIllegalGoods(Boolean illegalGoods) {
		this.illegalGoods = illegalGoods;
	}

	public Boolean getStolenGoods() {
		return stolenGoods;
	}

	public void setStolenGoods(Boolean stolenGoods) {
		this.stolenGoods = stolenGoods;
	}

	public Boolean getBlackMarket() {
		return blackMarket;
	}

	public void setBlackMarket(Boolean blackMarket) {
		this.blackMarket = blackMarket;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

	public void setTypeLocalised(String typeLocalised) {
		this.typeLocalised = typeLocalised;
	}

}
