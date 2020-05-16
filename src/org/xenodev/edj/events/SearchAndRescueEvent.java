/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:55
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class SearchAndRescueEvent extends Event {
	
	Long marketId, reward;
	String name, nameLocalised;
	Integer count;
	
	public SearchAndRescueEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketId = json.getLong("MarketID");
		this.reward = json.getLong("Reward");
		this.name = json.getString("Name");
		this.nameLocalised = json.getString("Name_Localised");
		this.count = json.getInt("Count");
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getReward() {
		return reward;
	}

	public void setReward(Long reward) {
		this.reward = reward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public void setNameLocalised(String nameLocalised) {
		this.nameLocalised = nameLocalised;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
