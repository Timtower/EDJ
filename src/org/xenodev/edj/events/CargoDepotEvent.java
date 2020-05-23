package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CargoDepotEvent extends Event{
	
	private Long missionID, startMarketID, endMarketID;
	private Integer count, itemCollected, itemsDelivered, totalItemsToDeliver;
	private String updateType, cargoType;
	private Double progress;
	
	public CargoDepotEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.missionID = json.getLong("MissionID");
		this.startMarketID = json.getLong("StartMarketID");
		this.endMarketID = json.getLong("EndMarketID");
		this.count = json.getInt("Count");
		this.itemCollected = json.getInt("ItemCollected");
		this.itemsDelivered = json.getInt("ItemDelivered");
		this.totalItemsToDeliver = json.getInt("TotalItemsToDeliver");
		this.updateType = json.getString("UpdateType");
		this.cargoType = json.getString("CargoType");
		this.progress = json.getDouble("Progress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
