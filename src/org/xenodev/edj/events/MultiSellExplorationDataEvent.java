package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.station.Discovered;
import org.xenodev.edj.utils.JournalUtils;

public class MultiSellExplorationDataEvent extends Event {
	
	private Discovered[] discovered;
	private Integer baseValue, totalEarnings, bonus;
	
	public MultiSellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.discovered = JournalUtils.createDiscoveredList(json.getJSONArray("Discovered"));
		this.baseValue = json.getInt("BaseValue");
		this.totalEarnings = json.getInt("TotalEarnings");
		this.bonus = json.getInt("Bonus");
	}
	
	public Discovered[] getDiscovered() {
		return discovered;
	}
	
	public Integer getBaseValue() {
		return baseValue;
	}
	
	public Integer getTotalEarnings() {
		return totalEarnings;
	}
	
	public Integer getBonus() {
		return bonus;
	}

}
