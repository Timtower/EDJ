/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 09:02
*/

package org.xenodev.edj.events.fleetcarrier;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CarrierFinanceEvent extends Event {
	
	private Double taxRate, reservePercent;
	private Long carrierId, carrierBalance, reserveBalance, availableBalance;
	
	public CarrierFinanceEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.taxRate = json.pullDouble("TaxRate");
		this.reservePercent = json.pullDouble("ReservePercent");
		this.carrierId = json.pullLong("CarrierID");
		this.carrierBalance = json.pullLong("CarrierBalance");
		this.reserveBalance = json.pullLong("ReserveBalance");
		this.availableBalance = json.pullLong("AvailableBalance");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public Double getReservePercent() {
		return reservePercent;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public Long getCarrierBalance() {
		return carrierBalance;
	}

	public Long getReserveBalance() {
		return reserveBalance;
	}

	public Long getAvailableBalance() {
		return availableBalance;
	}

}
