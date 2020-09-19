/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:41
*/

package io.github.xenopyax.edj.events.fleetcarrier;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
