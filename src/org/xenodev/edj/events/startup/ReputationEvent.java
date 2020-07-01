package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.localiser.Reputation;

/**
 * @author Xeno Pyax
 *
 */
public class ReputationEvent extends Event {

	private Integer empire, federation, alliance, independent;

	public ReputationEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.empire = json.pullDouble("Empire").intValue();
		this.federation = json.pullDouble("Federation").intValue();
		this.alliance = json.pullDouble("Alliance").intValue();
		this.independent = json.has("Independent") ? json.pullDouble("Independent").intValue() : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	/**
	 * Get Empire Reputation as an Integer between -100 an +100.
	 * 
	 * @return empire Reputation as integer.
	 */
	public Integer getEmpireReputation() {
		return empire;
	}
	
	/**
	 * Get Empire reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getEmpireReputationLocalised() {
		return Reputation.getReputationLocalised(empire);
	}

	/**
	 * Get Federation reputation as an Integer between -100 an +100.
	 * 
	 * @return Integer Reputation as integer.
	 */
	public Integer getFederationReputation() {
		return federation;
	}
	
	/**
	 * Get Federation reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getFederationReputationLocalised() {
		return Reputation.getReputationLocalised(federation);
	}

	/**
	 * Get Alliance reputation as an Integer between -100 an +100.
	 * 
	 * @return Integer Reputation as integer.
	 */
	public Integer getAllianceReputation() {
		return alliance;
	}
	
	/**
	 * Get Alliance reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getAllianceReputationLocalised() {
		return Reputation.getReputationLocalised(alliance);
	}
	
	/**
	 * Get Independent reputation as an Integer between -100 an +100.
	 * 
	 * @return Integer Reputation as integer.
	 */
	public Integer getIndependentReputation() {
		return independent;
	}
	
	/**
	 * Get Independent reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getIndependentReputationLocalised() {
		return Reputation.getReputationLocalised(independent);
	}
	
}
