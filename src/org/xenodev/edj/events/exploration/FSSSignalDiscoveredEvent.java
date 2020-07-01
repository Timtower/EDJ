package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSSSignalDiscoveredEvent extends Event {

	private String signalName, signalName_Localised, USSType, USSType_Localised, spawningState, spawningState_Localised, spawningFaction, spawningFaction_Localised;
	private Integer threatLevel;
	private Long systemAddress;
	private Double timeRemaining;
	private Boolean isStation;
	
	public FSSSignalDiscoveredEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.signalName = json.pullString("SignalName");
		this.signalName_Localised = json.pullString("SignalName_Localised");
		this.USSType = json.pullString("USSType");
		this.USSType_Localised = json.pullString("USSType_Localised");
		this.spawningState = json.pullString("SpawningState");
		this.spawningState_Localised = json.pullString("SpawningState_Localised");
		this.spawningFaction = json.pullString("SpawningFaction");
		this.spawningFaction_Localised = json.pullString("SpawningFaction_Localised");
		this.threatLevel = json.pullInt("ThreatLevel");
		this.systemAddress = json.pullLong("SystemAddress");
		this.timeRemaining = json.pullDouble("TimeRemaining");
		this.isStation = json.pullBoolean("IsStation");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSignalName() {
		return signalName;
	}

	public String getSignalName_Localised() {
		return signalName_Localised;
	}

	public String getUSSType() {
		return USSType;
	}

	public String getUSSType_Localised() {
		return USSType_Localised;
	}

	public String getSpawningState() {
		return spawningState;
	}

	public String getSpawningState_Localised() {
		return spawningState_Localised;
	}

	public String getSpawningFaction() {
		return spawningFaction;
	}

	public String getSpawningFaction_Localised() {
		return spawningFaction_Localised;
	}

	public Integer getThreatLevel() {
		return threatLevel;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Double getTimeRemaining() {
		return timeRemaining;
	}

	public Boolean getIsStation() {
		return isStation;
	}

}
