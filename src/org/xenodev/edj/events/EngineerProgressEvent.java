package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.interfaces.EngineerProgressInfo;
import org.xenodev.edj.events.storage.engineer.EngineerProgress;
import org.xenodev.edj.events.storage.engineer.EngineerProgressStartup;
import org.xenodev.edj.events.storage.engineer.EngineerProgressUpdate;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

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
		return new EngineerProgressUpdate(new EngineerProgress(JsonTranslator.getString(json, "Engineer"), JsonTranslator.getString(json, "Progress"),
				JsonTranslator.getInteger(json, "EngineerID"), JsonTranslator.getInteger(json, "Rank"), JsonTranslator.getDouble(json, "RankProgress")));
	}

}
