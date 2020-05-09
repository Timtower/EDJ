package org.xenodev.edj;

import org.xenodev.edj.utils.JournalUtils;

public class Event {
	
	long timestamp;
	
	public Event(String timestamp) {
		this.timestamp = JournalUtils.getTimeMillis(timestamp);
	}

	/**
	 * @return String Date & Time as String formatted E.g 
	 * {@literal} <b>12 Apr 2019</b>
	 */
	public String getTimestampFormatted() {
		return JournalUtils.getFormattedDate("dd MMM yyyy HH:mm:ss");
	}

	/**
	 * @return timestamp time in milliseconds
	 */
	public long getTimestamp() {
		return timestamp;
	}

}
