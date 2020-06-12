package org.xenodev.edj.events.storage;

import java.util.List;

public class Conflict {
	
	private String status, warType;
	private List<ConflicFaction> cFactionList;
	
	public Conflict(String status, String warType, List<ConflicFaction> cFactionList) {
		this.status = status;
		this.warType = warType;
		this.cFactionList = cFactionList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWarType() {
		return warType;
	}

	public void setWarType(String warType) {
		this.warType = warType;
	}

	public List<ConflicFaction> getcFactionList() {
		return cFactionList;
	}

	public void setcFactionList(List<ConflicFaction> cFactionList) {
		this.cFactionList = cFactionList;
	}

}