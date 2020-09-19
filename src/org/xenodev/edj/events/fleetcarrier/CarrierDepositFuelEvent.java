/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:41
*/

package org.xenodev.edj.events.fleetcarrier;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CarrierDepositFuelEvent extends Event {
	
	private Integer total, amount;
	private Long carrierId;
	
	public CarrierDepositFuelEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.total = json.pullInt("Total");
		this.amount = json.pullInt("Amount");
		this.carrierId = json.pullLong("CarrierID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getAmount() {
		return amount;
	}

	public Long getCarrierId() {
		return carrierId;
	}

}
