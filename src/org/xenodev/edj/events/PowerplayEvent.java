package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class PowerplayEvent extends Event {
	
	String power;
	int rank, merits, votes, timePledged;
	
	public PowerplayEvent(String timestamp, String power, int rank, int merits, int votes, int timePledged) {
		super(timestamp);
		this.power = power;
		this.rank = rank;
		this.merits = merits;
		this.votes = votes;
		this.timePledged = timePledged;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getMerits() {
		return merits;
	}

	public void setMerits(int merits) {
		this.merits = merits;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getTimePledged() {
		return timePledged;
	}

	public void setTimePledged(int timePledged) {
		this.timePledged = timePledged;
	}

}
