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
	
	String type, loadout;
	Long cost;
	Integer count;
	
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

	public void setType(String type) {
		this.type = type;
	}

	public String getLoadout() {
		return loadout;
	}

	public void setLoadout(String loadout) {
		this.loadout = loadout;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
