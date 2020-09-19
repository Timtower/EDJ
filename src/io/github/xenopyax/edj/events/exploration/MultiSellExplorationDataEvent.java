package io.github.xenopyax.edj.events.exploration;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.station.Discovered;
import io.github.xenopyax.edj.utils.JournalUtils;

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
