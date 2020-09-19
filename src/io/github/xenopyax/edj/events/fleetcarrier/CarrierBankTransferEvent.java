/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:15
*/

package io.github.xenopyax.edj.events.fleetcarrier;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CarrierBankTransferEvent extends Event {
	
	private Long deposit, carrierId, playerBalance, carrierBalance;

	public CarrierBankTransferEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.deposit = json.pullLong("Deposit");
		this.carrierId = json.pullLong("CarrierID");
		this.playerBalance = json.pullLong("PlayerBalance");
		this.carrierBalance = json.pullLong("CarrierBalance");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getDeposit() {
		return deposit;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public Long getPlayerBalance() {
		return playerBalance;
	}

	public Long getCarrierBalance() {
		return carrierBalance;
	}
	
}
