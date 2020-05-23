package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class FSSSignalDiscoveredEvent extends Event {

	private String signalName, signalName_Localised, USSType, USSType_Localised, spawningState, spawningState_Localised, spawningFaction, spawningFaction_Localised;
	private Integer threatLevel;
	private Long systemAddress;
	private Double timeRemaining;
	private Boolean isStation;
	
	public FSSSignalDiscoveredEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.signalName = json.getString("SignalName");
		this.signalName_Localised = json.getString("SignalName_Localised");
		this.USSType = json.getString("USSType");
		this.USSType_Localised = json.getString("USSType_Localised");
		this.spawningState = json.getString("SpawningState");
		this.spawningState_Localised = json.getString("SpawningState_Localised");
		this.spawningFaction = json.getString("SpawningFaction");
		this.spawningFaction_Localised = json.getString("SpawningFaction_Localised");
		this.threatLevel = json.getInt("ThreatLevel");
		this.systemAddress = json.getLong("SystemAddress");
		this.timeRemaining = json.getDouble("TimeRemaining");
		this.isStation = json.getBoolean("IsStation");
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
