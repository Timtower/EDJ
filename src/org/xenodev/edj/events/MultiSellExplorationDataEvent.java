package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.station.Discovered;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

public class MultiSellExplorationDataEvent extends Event {
	
	private Discovered[] discovered;
	private Integer baseValue, totalEarnings, bonus;
	
	public MultiSellExplorationDataEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.discovered = JournalUtils.createDiscoveredList(json.getJSONArray("Discovered"));
		this.baseValue = JsonTranslator.getInteger(json, "BaseValue");
		this.totalEarnings = JsonTranslator.getInteger(json, "TotalEarnings");
		this.bonus = JsonTranslator.getInteger(json, "Bonus");
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
