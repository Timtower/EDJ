/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:47
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class RepairEvent extends Event {
	
	String item;
	Long cost;
	
	public RepairEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.item = json.getString("Item");
		this.cost = json.getLong("Cost");
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

}
