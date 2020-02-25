package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class EngineerContributionEvent extends Event {
	
	private String engineer, type, commodity, faction, material;
	private Integer engineerID, quantity, totalQuantity;
	
	public EngineerContributionEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.engineer = JsonTranslator.getString(json, "Engineer");
		this.type = JsonTranslator.getString(json, "Type");
		this.commodity = JsonTranslator.getString(json, "Commodity");
		this.faction = JsonTranslator.getString(json, "Faction");
		this.material = JsonTranslator.getString(json, "Material");
		this.engineerID = JsonTranslator.getInteger(json, "EngineerID");
		this.quantity = JsonTranslator.getInteger(json, "Quantity");
		this.totalQuantity = JsonTranslator.getInteger(json, "TotalQuantity");
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
