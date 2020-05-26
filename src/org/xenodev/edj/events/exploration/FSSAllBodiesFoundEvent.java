package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSSAllBodiesFoundEvent extends Event {
	
	String systemName;
	Long systemAdress;
	Integer count;
	
	public FSSAllBodiesFoundEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemName = json.pullString("SystemName");
		this.systemAdress = json.pullLong("SystemAdress");
		this.count = json.pullInt("Count");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public void setSystemAdress(Long systemAdress) {
		this.systemAdress = systemAdress;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
