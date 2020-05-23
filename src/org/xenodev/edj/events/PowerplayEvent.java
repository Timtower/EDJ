package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class PowerplayEvent extends Event {
	
	String power;
	Integer rank, merits, votes, timePledged;
	
	public PowerplayEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.power = json.getString("Power");
		this.rank = json.getInt("Rank");
		this.merits = json.getInt("Merits");
		this.votes = json.getInt("Votes");
		this.timePledged = json.getInt("TimePledged");
		
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
