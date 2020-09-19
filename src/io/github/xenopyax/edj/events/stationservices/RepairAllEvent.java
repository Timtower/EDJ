/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:49
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class RepairAllEvent extends Event {
	
	private Long cost;

	public RepairAllEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.cost = json.pullLong("Cost");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getCost() {
		return cost;
	}

}
