package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CargoDepotEvent extends Event{
	
	private Long missionID, startMarketID, endMarketID;
	private Integer count, itemCollected, itemsDelivered, totalItemsToDeliver;
	private String updateType, cargoType;
	private Double progress;
	
	public CargoDepotEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.missionID = json.pullLong("MissionID");
		this.startMarketID = json.pullLong("StartMarketID");
		this.endMarketID = json.pullLong("EndMarketID");
		this.count = json.pullInt("Count");
		this.itemCollected = json.pullInt("ItemCollected");
		this.itemsDelivered = json.pullInt("ItemDelivered");
		this.totalItemsToDeliver = json.pullInt("TotalItemsToDeliver");
		this.updateType = json.pullString("UpdateType");
		this.cargoType = json.pullString("CargoType");
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
