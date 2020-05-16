package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.utils.localiser.Reputation;

/**
 * @author Xeno Pyax
 *
 */
public class ReputationEvent extends Event {

	Integer empire, federation, alliance;

	public ReputationEvent(String timestamp, Integer empire, Integer federation, Integer alliance) {
		super(timestamp);
		this.empire = empire;
		this.federation = federation;
		this.alliance = alliance;
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
	
}
