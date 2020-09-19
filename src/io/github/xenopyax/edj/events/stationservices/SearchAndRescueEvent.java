/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:55
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class SearchAndRescueEvent extends Event {
	
	private Long marketId, reward;
	private String name, nameLocalised;
	private Integer count;
	
	public SearchAndRescueEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.reward = json.pullLong("Reward");
		this.name = json.pullString("Name");
		this.nameLocalised = json.pullString("Name_Localised");
		this.count = json.pullInt("Count");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketId() {
		return marketId;
	}

	public Long getReward() {
		return reward;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public Integer getCount() {
		return count;
	}

}
