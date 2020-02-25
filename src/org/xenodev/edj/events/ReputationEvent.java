package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.utils.localiser.Reputation;

/**
 * @author Xeno Pyax
 *
 */
public class ReputationEvent extends Event {

	int empire, federation, independent, alliance;

	public ReputationEvent(String timestamp, int empire, int federation, int independent, int alliance) {
		super(timestamp);
		this.empire = empire;
		this.federation = federation;
		this.independent = independent;
		this.alliance = alliance;
	}

	/**
	 * Get Empire Reputation as an Integer between -100 an +100.
	 * 
	 * @return empire Reputation as integer.
	 */
	public int getEmpireReputation() {
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
	 * @return int Reputation as integer.
	 */
	public int getFederationReputation() {
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
	 * Get Independent reputation as an Integer between -100 an +100.
	 * 
	 * @return int Reputation as integer.
	 */
	public int getIndependentReputation() {
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

	/**
	 * Get Alliance reputation as an Integer between -100 an +100.
	 * 
	 * @return int Reputation as integer.
	 */
	public int getAllianceReputation() {
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
