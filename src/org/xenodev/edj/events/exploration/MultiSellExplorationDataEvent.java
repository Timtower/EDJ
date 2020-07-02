package org.xenodev.edj.events.exploration;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.station.Discovered;
import org.xenodev.edj.utils.JournalUtils;

public class MultiSellExplorationDataEvent extends Event {
	
	private List<Discovered> discovered;
	private Integer baseValue, totalEarnings, bonus;
	
	public MultiSellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.discovered = JournalUtils.createDiscoveredList(json.pullJSONArray("Discovered"));
		this.baseValue = json.pullInt("BaseValue");
		this.totalEarnings = json.pullInt("TotalEarnings");
		this.bonus = json.pullInt("Bonus");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public List<Discovered> getDiscovered() {
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
