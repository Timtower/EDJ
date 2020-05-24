/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:23
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.TradeData;
import org.xenodev.edj.utils.JournalUtils;

public class MaterialTradeEvent extends Event {
	
	Long marketId;
	String traderType;
	TradeData paid, received;

	public MaterialTradeEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.traderType = json.pullString("TraderType");
		this.paid = JournalUtils.createTradeData(json.getJSONArray("Paid"));
		this.received = JournalUtils.createTradeData(json.getJSONArray("Received"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getTraderType() {
		return traderType;
	}

	public void setTraderType(String traderType) {
		this.traderType = traderType;
	}

	public TradeData getPaid() {
		return paid;
	}

	public void setPaid(TradeData paid) {
		this.paid = paid;
	}

	public TradeData getReceived() {
		return received;
	}

	public void setReceived(TradeData received) {
		this.received = received;
	}

}
