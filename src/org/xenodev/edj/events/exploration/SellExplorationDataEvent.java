package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SellExplorationDataEvent extends Event {
	
	private String[] systemns, discovered;
	private Integer baseValue, bonus, totalEarnings;
	
	public SellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemns = JournalUtils.createDataSystemsList(json.getJSONArray("Systems"));
		this.discovered = JournalUtils.createDataDiscoveredList(json.getJSONArray("Discovered"));
		this.baseValue = json.pullInt("BaseValue");
		this.bonus = json.pullInt("Bonus");
		this.totalEarnings = json.pullInt("TotalEarnings");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String[] getSystemns() {
		return systemns;
	}

	public void setSystemns(String[] systemns) {
		this.systemns = systemns;
	}

	public String[] getDiscovered() {
		return discovered;
	}

	public void setDiscovered(String[] discovered) {
		this.discovered = discovered;
	}

	public Integer getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(Integer baseValue) {
		this.baseValue = baseValue;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Integer totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

}
