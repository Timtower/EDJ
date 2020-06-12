package org.xenodev.edj.events.storage;

public class StoredShipRemote {
	
	private Boolean hot;
	private String name, shipType, shipTypeLocalised, starSystem;
	private Long value, shipMarketId, transferTime, transferrice;
	private Integer shipId;
	
	public StoredShipRemote(Boolean hot, String name, String shipType, String shipTypeLocalised, String starSystem,
			Long value, Long shipMarketId, Long transferTime, Long transferrice, Integer shipId) {
		this.hot = hot;
		this.name = name;
		this.shipType = shipType;
		this.shipTypeLocalised = shipTypeLocalised;
		this.starSystem = starSystem;
		this.value = value;
		this.shipMarketId = shipMarketId;
		this.transferTime = transferTime;
		this.transferrice = transferrice;
		this.shipId = shipId;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public void setShipTypeLocalised(String shipTypeLocalised) {
		this.shipTypeLocalised = shipTypeLocalised;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Long getShipMarketId() {
		return shipMarketId;
	}

	public void setShipMarketId(Long shipMarketId) {
		this.shipMarketId = shipMarketId;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}

	public Long getTransferrice() {
		return transferrice;
	}

	public void setTransferrice(Long transferrice) {
		this.transferrice = transferrice;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

}
