/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:32
*/

package org.xenodev.edj.events.stationservices;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.bounty.FactionBounty;
import org.xenodev.edj.utils.JournalUtils;

public class RedeemVoucherEvent extends Event {
	
	String type;
	Long totalAmount;
	Integer brokerPercentage;
	List<FactionBounty> factionBounties;
	
	public RedeemVoucherEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.totalAmount = json.pullLong("Amount");
		this.brokerPercentage = json.pullInt("BrokerPercentage");
		this.factionBounties = JournalUtils.createFactionBountyList(json.pullJSONArray("Factions"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
