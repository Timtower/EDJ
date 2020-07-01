/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:49
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PayBountiesEvent extends Event {
	
	private Long amount;
	private String faction, factionLocalised;
	private Integer shipId, brokerPercentage;
	
	public PayBountiesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.amount = json.pullLong("Amount");
		this.faction = json.pullString("Faction");
		this.factionLocalised = json.pullString("Faction_Localised");
		this.shipId = json.pullInt("ShipID");
		this.brokerPercentage = json.pullInt("BrokerPercentage");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getAmount() {
		return amount;
	}

	public String getFaction() {
		return faction;
	}

	public String getFactionLocalised() {
		return factionLocalised;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Integer getBrokerPercentage() {
		return brokerPercentage;
	}

}
