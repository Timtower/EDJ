/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:41
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class RefuelAllEvent extends Event {
	
	private Long cost;
	private Double amount;
	
	public RefuelAllEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.cost = json.pullLong("Cost");
		this.amount = json.pullDouble("Amount");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getCost() {
		return cost;
	}

	public Double getAmount() {
		return amount;
	}

}
