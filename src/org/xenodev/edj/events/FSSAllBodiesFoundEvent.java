package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class FSSAllBodiesFoundEvent extends Event {
	
	String systemName;
	Long systemAdress;
	Integer count;
	
	public FSSAllBodiesFoundEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.systemName = json.getString("SystemName");
		this.systemAdress = json.getLong("SystemAdress");
		this.count = json.getInt("Count");
	}

	public String getSystemName() {
		return systemName;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Integer getCount() {
		return count;
	}

}
