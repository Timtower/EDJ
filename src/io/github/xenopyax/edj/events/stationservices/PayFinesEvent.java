/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:52
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class PayFinesEvent extends Event {
	
	private Long amount;
	private Integer shipId;
	private Boolean allFines;

	public PayFinesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.amount = json.pullLong("Amount");
		this.shipId = json.pullInt("ShipID");
		this.allFines = json.pullBoolean("AllFines");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getAmount() {
		return amount;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Boolean getAllFines() {
		return allFines;
	}

}
