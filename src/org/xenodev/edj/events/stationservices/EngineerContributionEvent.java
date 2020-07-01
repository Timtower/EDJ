package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class EngineerContributionEvent extends Event {
	
	private String engineer, type, commodity, faction, material;
	private Integer engineerID, quantity, totalQuantity;
	
	public EngineerContributionEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.engineer = json.pullString("Engineer");
		this.type = json.pullString("Type");
		this.commodity = json.pullString("Commodity");
		this.faction = json.pullString("Faction");
		this.material = json.pullString("Material");
		this.engineerID = json.pullInt("EngineerID");
		this.quantity = json.pullInt("Quantity");
		this.totalQuantity = json.pullInt("TotalQuantity");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getEngineer() {
		return engineer;
	}

	public String getType() {
		return type;
	}

	public String getCommodity() {
		return commodity;
	}

	public String getFaction() {
		return faction;
	}

	public String getMaterial() {
		return material;
	}

	public Integer getEngineerID() {
		return engineerID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

}
