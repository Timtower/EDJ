package io.github.xenopyax.edj.events.trade;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class EjectCargoEvent extends Event {
	
	private String type, typeLocalised, powerplayOrigin;
	private Integer count;
	private Long missionID;
	private Boolean abondoned;
	
	public EjectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.typeLocalised = json.pullString("Type_Localised");
		this.powerplayOrigin = json.pullString("PowerplayOrigin");
		this.count = json.pullInt("Count");
		this.missionID = json.pullLong("MissionID");
		this.abondoned = json.pullBoolean("Abandoned");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

	public String getPowerplayOrigin() {
		return powerplayOrigin;
	}

	public Integer getCount() {
		return count;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Boolean getAbondoned() {
		return abondoned;
	}

}
