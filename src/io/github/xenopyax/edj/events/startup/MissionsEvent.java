package io.github.xenopyax.edj.events.startup;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.Mission;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MissionsEvent extends Event {
	
	private List<Mission> active;
	private List<Mission> failed;
	private List<Mission> complete;
	
	public MissionsEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.active = JournalUtils.createMissionList(json.pullJSONArray("Active"));
		this.failed = JournalUtils.createMissionList(json.pullJSONArray("Failed"));
		this.complete = JournalUtils.createMissionList(json.pullJSONArray("Complete"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public List<Mission> getActive() {
		return active;
	}

	public List<Mission> getFailed() {
		return failed;
	}

	public List<Mission> getComplete() {
		return complete;
	}

}
