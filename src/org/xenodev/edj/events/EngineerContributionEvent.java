package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class EngineerContributionEvent extends Event {
	
	private String engineer, type, commodity, faction, material;
	private Integer engineerID, quantity, totalQuantity;
	
	public EngineerContributionEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.engineer = json.getString("Engineer");
		this.type = json.getString("Type");
		this.commodity = json.getString("Commodity");
		this.faction = json.getString("Faction");
		this.material = json.getString("Material");
		this.engineerID = json.getInt("EngineerID");
		this.quantity = json.getInt("Quantity");
		this.totalQuantity = json.getInt("TotalQuantity");
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
