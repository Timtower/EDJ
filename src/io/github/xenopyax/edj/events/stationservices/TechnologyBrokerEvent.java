/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 06/27/2020 11:15
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class TechnologyBrokerEvent extends Event {
	
	public TechnologyBrokerEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}
