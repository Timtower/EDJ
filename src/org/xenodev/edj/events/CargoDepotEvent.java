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

	public void setMissionID(Long missionID) {
		this.missionID = missionID;
	}

	public Long getStartMarketID() {
		return startMarketID;
	}

	public void setStartMarketID(Long startMarketID) {
		this.startMarketID = startMarketID;
	}

	public Long getEndMarketID() {
		return endMarketID;
	}

	public void setEndMarketID(Long endMarketID) {
		this.endMarketID = endMarketID;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getItemCollected() {
		return itemCollected;
	}

	public void setItemCollected(Integer itemCollected) {
		this.itemCollected = itemCollected;
	}

	public Integer getItemsDelivered() {
		return itemsDelivered;
	}

	public void setItemsDelivered(Integer itemsDelivered) {
		this.itemsDelivered = itemsDelivered;
	}

	public Integer getTotalItemsToDeliver() {
		return totalItemsToDeliver;
	}

	public void setTotalItemsToDeliver(Integer totalItemsToDeliver) {
		this.totalItemsToDeliver = totalItemsToDeliver;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public Double getProgress() {
		return progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

}
