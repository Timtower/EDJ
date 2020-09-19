/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 06/27/2020 12:46
*/

package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ApproachSettlementEvent extends Event {
	
	private String name, bodyName;
	private Integer bodyId;
	private Double latitude, longitude;
	private Long marketId, systemaddress;
	
	public ApproachSettlementEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.bodyName = json.pullString("BodyName");
		this.bodyId = json.pullInt("BodyID");
		this.latitude = json.pullDouble("Latitude");
		this.longitude = json.pullDouble("Longitude");
		this.marketId = json.pullLong("MarketID");
		this.systemaddress = json.pullLong("SystemAddress");
				
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public String getBodyName() {
		return bodyName;
	}

	public Integer getBodyId() {
		return bodyId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Long getSystemaddress() {
		return systemaddress;
	}

}
