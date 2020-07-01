package org.xenodev.edj.events.storage;

public class FactionState {
	
	private String state;
	private Double trend;
	
	public FactionState(String state, Double trend) {
		this.state = state;
		this.trend = trend;
	}

	public String getState() {
		return state;
	}

	public Double getTrend() {
		return trend;
	}

}
