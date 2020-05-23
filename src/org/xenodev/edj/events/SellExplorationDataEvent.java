package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SellExplorationDataEvent extends Event {
	
	private String[] systemns, discovered;
	private Integer baseValue, bonus, totalEarnings;
	
	public SellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.systemns = JournalUtils.createDataSystemsList(json.getJSONArray("Systems"));
		this.discovered = JournalUtils.createDataDiscoveredList(json.getJSONArray("Discovered"));
		this.baseValue = json.getInt("BaseValue");
		this.bonus = json.getInt("Bonus");
		this.totalEarnings = json.getInt("TotalEarnings");
	}

	public String[] getSystemns() {
		return systemns;
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
