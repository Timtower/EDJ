/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 07:14
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class SellShipOnRebuyEvent extends Event {
	
	/**
	 * !!Experimental!! This event will throw and Exception since I am missing the event data only use if you want to help me complete this Event.
	 * Send the Unused Event data to Discord => XenoPyax#5647  OR Mail to => xeno.pyax@gmail.com
	 * 
	 * @param timestamp
	 * @param json
	 */
	public SellShipOnRebuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}
