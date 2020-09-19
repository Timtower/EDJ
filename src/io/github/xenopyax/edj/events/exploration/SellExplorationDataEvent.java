package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class SellExplorationDataEvent extends Event {
	
	private String[] systems, discovered;
	private Integer baseValue, bonus, totalEarnings;
	
	public SellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systems = JournalUtils.createDataSystemsList(json.getJSONArray("Systems"));
		this.discovered = JournalUtils.createDataDiscoveredList(json.getJSONArray("Discovered"));
		this.baseValue = json.pullInt("BaseValue");
		this.bonus = json.pullInt("Bonus");
		this.totalEarnings = json.pullInt("TotalEarnings");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String[] getSystems() {
		return systems;
	}

	public String[] getDiscovered() {
		return discovered;
	}

	public Integer getBaseValue() {
		return baseValue;
	}

	public Integer getBonus() {
		return bonus;
	}

	public Integer getTotalEarnings() {
		return totalEarnings;
	}

}
