package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class FSSAllBodiesFoundEvent extends Event {
	
	String systemName;
	Long systemAdress;
	Integer count;
	
	public FSSAllBodiesFoundEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.systemName = JsonTranslator.getString(json, "SystemName");
		this.systemAdress = JsonTranslator.getLong(json, "SystemAdress");
		this.count = JsonTranslator.getInteger(json, "Count");
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
