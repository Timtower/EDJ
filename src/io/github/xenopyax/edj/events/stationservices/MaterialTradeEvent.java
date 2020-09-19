/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:23
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.TradeData;
import io.github.xenopyax.edj.utils.JournalUtils;

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

	public String getTraderType() {
		return traderType;
	}

	public TradeData getPaid() {
		return paid;
	}

	public TradeData getReceived() {
		return received;
	}

}
