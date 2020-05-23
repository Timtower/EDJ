package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.interfaces.EngineerProgressInfo;
import org.xenodev.edj.events.storage.engineer.EngineerProgress;
import org.xenodev.edj.events.storage.engineer.EngineerProgressStartup;
import org.xenodev.edj.events.storage.engineer.EngineerProgressUpdate;
import org.xenodev.edj.utils.JournalUtils;

public class EngineerProgressEvent extends Event {
	
	JSONObject json;

	public EngineerProgressEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.json = json;
	}
	
	public EngineerProgressInfo getEngineerProgressInfo() {
		if(json.has("Engineers")) {
			return new EngineerProgressStartup(JournalUtils.createEngineerProgressList(json.getJSONArray("Engineers")));
		}
		return new EngineerProgressUpdate(new EngineerProgress(json.getString("Engineer"), json.getString("Progress"),
				json.getInt("EngineerID"), json.getInt("Rank"), json.getDouble("RankProgress")));
	}

}
