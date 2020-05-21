/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:49
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class RepairAllEvent extends Event {
	
	Long cost;

	public RepairAllEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cost = json.getLong("Cost");
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

}