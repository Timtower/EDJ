package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.station.Discovered;
import org.xenodev.edj.utils.JournalUtils;

public class MultiSellExplorationDataEvent extends Event {
	
	private Discovered[] discovered;
	private Integer baseValue, totalEarnings, bonus;
	
	public MultiSellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.discovered = JournalUtils.createDiscoveredList(json.getJSONArray("Discovered"));
		this.baseValue = json.pullInt("BaseValue");
		this.totalEarnings = json.pullInt("TotalEarnings");
		this.bonus = json.pullInt("Bonus");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Discovered[] getDiscovered() {
		return discovered;
	}

	public void setDiscovered(Discovered[] discovered) {
		this.discovered = discovered;
	}

	public Integer getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(Integer baseValue) {
		this.baseValue = baseValue;
	}

	public Integer getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Integer totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	
}
