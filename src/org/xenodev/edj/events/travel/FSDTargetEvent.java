package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSDTargetEvent extends Event {
	
	String name, starClass;
	Long systemAdress;
	Integer remainingJumpsInRoute;
	
	public FSDTargetEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.systemAdress = json.pullLong("SystemAddress");
		this.remainingJumpsInRoute = json.pullInt("RemainingJumpsInRoute");
		this.starClass = json.pullString("StarClass");
		
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

	public String getStarClass() {
		return starClass;
	}

	public void setStarClass(String starClass) {
		this.starClass = starClass;
	}

	public Integer getRemainingJumpsInRoute() {
		return remainingJumpsInRoute;
	}

	public void setRemainingJumpsInRoute(Integer remainingJumpsInRoute) {
		this.remainingJumpsInRoute = remainingJumpsInRoute;
	}

}
