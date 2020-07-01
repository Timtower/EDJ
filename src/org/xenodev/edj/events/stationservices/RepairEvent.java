/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:47
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class RepairEvent extends Event {
	
	private String item;
	private Long cost;
	
	public RepairEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.item = json.pullString("Item");
		this.cost = json.pullLong("Cost");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getItem() {
		return item;
	}

	public Long getCost() {
		return cost;
	}

}
