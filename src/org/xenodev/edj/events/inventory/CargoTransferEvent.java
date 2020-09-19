/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:05
*/

package org.xenodev.edj.events.inventory;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.inventory.Transfer;
import org.xenodev.edj.utils.JournalUtils;

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
