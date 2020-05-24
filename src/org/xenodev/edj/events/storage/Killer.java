package org.xenodev.edj.events.storage;

public class Killer {
	
	String name, ship, rank;

	public Killer(String name, String ship, String rank) {
		this.name = name;
		this.ship = ship;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
