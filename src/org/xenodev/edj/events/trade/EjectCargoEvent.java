package org.xenodev.edj.events.trade;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class EjectCargoEvent extends Event {
	
	private String type, powerplayOrigin;
	private Integer count;
	private Long missionID;
	private Boolean abondoned;
	
	public EjectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.powerplayOrigin = json.pullString("PowerplayOrigin");
		this.count = json.pullInt("Count");
		this.missionID = json.pullLong("MissionID");
		this.abondoned = json.pullBoolean("Abondoned");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPowerplayOrigin() {
		return powerplayOrigin;
	}

	public void setPowerplayOrigin(String powerplayOrigin) {
		this.powerplayOrigin = powerplayOrigin;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getMissionID() {
		return missionID;
	}

	public void setMissionID(Long missionID) {
		this.missionID = missionID;
	}

	public Boolean getAbondoned() {
		return abondoned;
	}

	public void setAbondoned(Boolean abondoned) {
		this.abondoned = abondoned;
	}

}
