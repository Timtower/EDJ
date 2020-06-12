package org.xenodev.edj.events.storage;

public class ConflicFaction {
	
	private String name, stake;
	private Integer daysWon;
	
	public ConflicFaction(String name, String stake, Integer daysWon) {
		this.name = name;
		this.stake = stake;
		this.daysWon = daysWon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStake() {
		return stake;
	}

	public void setStake(String stake) {
		this.stake = stake;
	}

	public Integer getDaysWon() {
		return daysWon;
	}

	public void setDaysWon(Integer daysWon) {
		this.daysWon = daysWon;
	}

}
