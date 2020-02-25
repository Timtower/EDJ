package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CargoDepotEvent extends Event{
	
	private Long missionID, startMarketID, endMarketID;
	private Integer count, itemCollected, itemsDelivered, totalItemsToDeliver;
	private String updateType, cargoType;
	private Double progress;
	
	public CargoDepotEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.missionID = JsonTranslator.getLong(json, "MissionID");
		this.startMarketID = JsonTranslator.getLong(json, "StartMarketID");
		this.endMarketID = JsonTranslator.getLong(json, "EndMarketID");
		this.count = JsonTranslator.getInteger(json, "Count");
		this.itemCollected = JsonTranslator.getInteger(json, "ItemCollected");
		this.itemsDelivered = JsonTranslator.getInteger(json, "ItemDelivered");
		this.totalItemsToDeliver = JsonTranslator.getInteger(json, "TotalItemsToDeliver");
		this.updateType = JsonTranslator.getString(json, "UpdateType");
		this.cargoType = JsonTranslator.getString(json, "CargoType");
		this.progress = JsonTranslator.getDouble(json, "Progress");
	}

	public Long getMissionID() {
		return missionID;
	}

	public Long getStartMarketID() {
		return startMarketID;
	}

	public Long getEndMarketID() {
		return endMarketID;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getItemCollected() {
		return itemCollected;
	}

	public Integer getItemsDelivered() {
		return itemsDelivered;
	}

	public Integer getTotalItemsToDeliver() {
		return totalItemsToDeliver;
	}

	public String getUpdateType() {
		return updateType;
	}

	public String getCargoType() {
		return cargoType;
	}

	public Double getProgress() {
		return progress;
	}
	
}
