package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONArray;
import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.engineer.EngineerProgress;
import io.github.xenopyax.edj.events.datastorage.engineer.EngineerProgressStartup;
import io.github.xenopyax.edj.events.datastorage.engineer.EngineerProgressUpdate;
import io.github.xenopyax.edj.events.interfaces.EngineerProgressInfo;
import io.github.xenopyax.edj.utils.JournalUtils;

public class EngineerProgressEvent extends Event {
	
	private String engineer, progress;
	private Integer engineerId, rank;
	private Double rankProgress;
	private JSONArray engineersArray;

	public EngineerProgressEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		if(json.has("Engineers")) {
			this.engineersArray = json.pullJSONArray("Engineers");
		}else {
			this.engineer = json.pullString("Engineer");
			this.progress = json.pullString("Progress");
			this.engineerId = json.pullInt("EngineerID");
			this.rank = json.pullInt("Rank");
			this.rankProgress = json.getDouble("RankProgress");
		}
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}
	
	public EngineerProgressInfo getEngineerProgressInfo() {
		if(engineersArray != null) {
			return new EngineerProgressStartup(JournalUtils.createEngineerProgressList(engineersArray));
		}
		return new EngineerProgressUpdate(new EngineerProgress(engineer, progress, engineerId, rank, rankProgress));
	}

}
