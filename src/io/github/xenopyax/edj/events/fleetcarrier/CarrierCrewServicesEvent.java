/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:38
*/

package io.github.xenopyax.edj.events.fleetcarrier;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CarrierCrewServicesEvent extends Event{

	private String crewName, crewRole, operation;
	private Long carrierId;
	
	public CarrierCrewServicesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.crewName = json.pullString("CrewName");
		this.crewRole = json.pullString("CrewRole");
		this.operation = json.pullString("Operation");
		this.carrierId = json.pullLong("CarrierID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getCrewName() {
		return crewName;
	}

	public String getCrewRole() {
		return crewRole;
	}

	public String getOperation() {
		return operation;
	}

	public Long getCarrierId() {
		return carrierId;
	}
	
}
