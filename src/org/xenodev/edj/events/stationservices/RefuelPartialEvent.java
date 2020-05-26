/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:44
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class RefuelPartialEvent extends Event {
	
	/**
	 * !!Experimental!! This event will throw and Exception since I am missing the event data only use if you want to help me complete this Event.
	 * Send the Unused Event data to Discord => XenoPyax#5647  OR Mail to => xeno.pyax@gmail.com
	 * 
	 * @param timestamp
	 * @param json
	 */
	public RefuelPartialEvent(String timestamp , JSONObject json) {
		super(timestamp);
	
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}
