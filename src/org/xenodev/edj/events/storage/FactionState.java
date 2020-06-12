package org.xenodev.edj.events.storage;

public class FactionState {
	
	String state;
	Double trend;
	
	public FactionState(String state, Double trend) {
		this.state = state;
		this.trend = trend;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getTrend() {
		return trend;
	}

	public void setTrend(Double trend) {
		this.trend = trend;
	}

}
