package org.xenodev.edj.events.storage;

public class StoredShipHere {
	
	private Boolean hot;
	private String name, shipType, shipTypeLocalised;
	private Long value;
	private Integer shipId;
	
	public StoredShipHere(Boolean hot, String name, String shipType, String shipTypeLocalised, Long value, Integer shipId) {
		this.hot = hot;
		this.name = name;
		this.shipType = shipType;
		this.shipTypeLocalised = shipTypeLocalised;
		this.value = value;
		this.shipId = shipId;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public void setShipTypeLocalised(String shipTypeLocalised) {
		this.shipTypeLocalised = shipTypeLocalised;
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

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

}
