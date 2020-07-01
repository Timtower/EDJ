/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:51
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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
