/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:49
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class PayBountiesEvent extends Event {
	
	Long amount;
	String faction, factionLocalised;
	Integer shipId, brokerPercentage;
	
	public PayBountiesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.amount = json.getLong("Amount");
		this.faction = json.getString("Faction");
		this.factionLocalised = json.getString("Faction_Localised");
		this.shipId = json.getInt("ShipID");
		this.brokerPercentage = json.getInt("BrokerPercentage");
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
