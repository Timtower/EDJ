/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:52
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PayFinesEvent extends Event {
	
	Long amount;
	Integer shipId;
	Boolean allFines;

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

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
