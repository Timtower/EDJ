package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PowerplayEvent extends Event {
	
	String power;
	Integer rank, merits, votes, timePledged;
	
	public PowerplayEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.power = json.pullString("Power");
		this.rank = json.pullInt("Rank");
		this.merits = json.pullInt("Merits");
		this.votes = json.pullInt("Votes");
		this.timePledged = json.pullInt("TimePledged");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getMerits() {
		return merits;
	}

	public void setMerits(Integer merits) {
		this.merits = merits;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getTimePledged() {
		return timePledged;
	}

	public void setTimePledged(Integer timePledged) {
		this.timePledged = timePledged;
	}

}
