/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:51
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class RestockVehicleEvent extends Event {
	
	private String type, loadout;
	private Long cost;
	private Integer count;
	
	public RestockVehicleEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.loadout = json.pullString("Loadout");
		this.cost = json.pullLong("Cost");
		this.count = json.pullInt("Count");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public String getLoadout() {
		return loadout;
	}

	public Long getCost() {
		return cost;
	}

	public Integer getCount() {
		return count;
	}

}
