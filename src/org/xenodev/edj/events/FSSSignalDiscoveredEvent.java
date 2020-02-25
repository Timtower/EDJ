package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class FSSSignalDiscoveredEvent extends Event {

	private String signalName, signalName_Localised, USSType, USSType_Localised, spawningState, spawningState_Localised, spawningFaction, spawningFaction_Localised;
	private Integer threatLevel;
	private Long systemAddress;
	private Double timeRemaining;
	private Boolean isStation;
	
	public FSSSignalDiscoveredEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.signalName = JsonTranslator.getString(json, "SignalName");
		this.signalName_Localised = JsonTranslator.getString(json, "SignalName_Localised");
		this.USSType = JsonTranslator.getString(json, "USSType");
		this.USSType_Localised = JsonTranslator.getString(json, "USSType_Localised");
		this.spawningState = JsonTranslator.getString(json, "SpawningState");
		this.spawningState_Localised = JsonTranslator.getString(json, "SpawningState_Localised");
		this.spawningFaction = JsonTranslator.getString(json, "SpawningFaction");
		this.spawningFaction_Localised = JsonTranslator.getString(json, "SpawningFaction_Localised");
		this.threatLevel = JsonTranslator.getInteger(json, "ThreatLevel");
		this.systemAddress = JsonTranslator.getLong(json, "SystemAddress");
		this.timeRemaining = JsonTranslator.getDouble(json, "TimeRemaining");
		this.isStation = JsonTranslator.getBoolean(json, "IsStation");
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
