/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:36
*/

package org.xenodev.edj.events.storage;

public class StoredModule {
	
	String name, nameLocalised, starSystem;
	Integer storageSlot;
	Long marketId, transferCost, transferTime, buyPrice;
	Boolean hot;
	
	public StoredModule(String name, String nameLocalised, String starSystem, Integer storageSlot, Long marketId,
			Long transferCost, Long transferTime, Long buyPrice, Boolean hot) {
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.starSystem = starSystem;
		this.storageSlot = storageSlot;
		this.marketId = marketId;
		this.transferCost = transferCost;
		this.transferTime = transferTime;
		this.buyPrice = buyPrice;
		this.hot = hot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public void setNameLocalised(String nameLocalised) {
		this.nameLocalised = nameLocalised;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String sarSystem) {
		this.starSystem = sarSystem;
	}

	public Integer getStorageSlot() {
		return storageSlot;
	}

	public void setStorageSlot(Integer storageSlot) {
		this.storageSlot = storageSlot;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getTransferCost() {
		return transferCost;
	}

	public void setTransferCost(Long transferCost) {
		this.transferCost = transferCost;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

}
