package io.github.xenopyax.edj.events.datastorage;

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

	public String getStake() {
		return stake;
	}

	public Integer getDaysWon() {
		return daysWon;
	}

}
