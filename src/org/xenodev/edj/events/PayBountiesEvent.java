/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:49
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PayBountiesEvent extends Event {
	
	Long amount;
	String faction, factionLocalised;
	Integer shipId, brokerPercentage;
	
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

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getFactionLocalised() {
		return factionLocalised;
	}

	public void setFactionLocalised(String factionLocalised) {
		this.factionLocalised = factionLocalised;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Integer getBrokerPercentage() {
		return brokerPercentage;
	}

	public void setBrokerPercentage(Integer brokerPercentage) {
		this.brokerPercentage = brokerPercentage;
	}

}
