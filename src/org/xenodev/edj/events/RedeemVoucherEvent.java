/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:32
*/

package org.xenodev.edj.events;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.bounty.FactionBounty;
import org.xenodev.edj.utils.JournalUtils;

public class RedeemVoucherEvent extends Event {
	
	String type;
	Long totalAmount;
	List<FactionBounty> factionBounties;
	
	public RedeemVoucherEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = json.getString("Type");
		this.totalAmount = json.getLong("Amount");
		this.factionBounties = JournalUtils.createFactionBountyList(json.getJSONArray("Factions"));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<FactionBounty> getFactionBounties() {
		return factionBounties;
	}

	public void setFactionBounties(List<FactionBounty> factionBounties) {
		this.factionBounties = factionBounties;
	}

}
