package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
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

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getEngineerID() {
		return engineerID;
	}

	public void setEngineerID(Integer engineerID) {
		this.engineerID = engineerID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}
