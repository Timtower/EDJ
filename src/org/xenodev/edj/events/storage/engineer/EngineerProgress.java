package org.xenodev.edj.events.storage.engineer;

public class EngineerProgress {
	
	private String engineer, progress;
	private Integer engineerID, rank;
	private Double rankProgress;
	
	public EngineerProgress(String engineer, String progress, Integer engineerID, Integer rank, Double rankProgress) {
		this.engineer = engineer;
		this.progress = progress;
		this.engineerID = engineerID;
		this.rank = rank;
		this.rankProgress = rankProgress;
	}

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Integer getEngineerID() {
		return engineerID;
	}

	public void setEngineerID(Integer engineerID) {
		this.engineerID = engineerID;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getRankProgress() {
		return rankProgress;
	}

	public void setRankProgress(Double rankProgress) {
		this.rankProgress = rankProgress;
	}


}
