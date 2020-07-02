/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 06/27/2020 11:15
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class TechnologyBrokerEvent extends Event {
	
	public TechnologyBrokerEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}
