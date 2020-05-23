package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSDTargetEvent extends Event {
	
	String name;
	Long systemAdress;
	
	public FSDTargetEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.getString("Name");
		this.systemAdress = json.getLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public void setSystemAdress(Long systemAdress) {
		this.systemAdress = systemAdress;
	}

}
