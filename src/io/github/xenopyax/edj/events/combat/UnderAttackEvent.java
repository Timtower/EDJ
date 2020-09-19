package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

/**
 * This event is fired every time the player is under attack.
 * 
 */
public class UnderAttackEvent extends Event {
	
	private String target;
	
	public UnderAttackEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.target = json.pullString("Target");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}
	
	/**
	 * Gets the target that is getting shot: Fighter, Mothership or You.
	 * @return target Fighter, Mothership or You
	 */
	public String getTarget() {
		return target;
	}
	
}
