/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:33
*/

package org.xenodev.edj.events.storage.bounty;

public class FactionBounty {
	
	String faction;
	Long amount;
	
	public FactionBounty(String faction, Long amount) {
		this.faction = faction;
		this.amount = amount;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
