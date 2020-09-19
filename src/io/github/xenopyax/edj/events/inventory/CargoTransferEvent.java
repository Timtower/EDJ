/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:05
*/

package io.github.xenopyax.edj.events.inventory;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.inventory.Transfer;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CargoTransferEvent extends Event {
	
	private List<Transfer> transfers;
	
	public CargoTransferEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.transfers = JournalUtils.createTransferList(json.pullJSONArray("Transfers"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}
	
}
