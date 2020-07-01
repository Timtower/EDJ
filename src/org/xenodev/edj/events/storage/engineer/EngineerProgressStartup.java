package org.xenodev.edj.events.storage.engineer;

import java.util.List;

import org.xenodev.edj.events.interfaces.EngineerProgressInfo;

public class EngineerProgressStartup implements EngineerProgressInfo {
	
	private List<EngineerProgress> engineerProgressList;

	public EngineerProgressStartup(List<EngineerProgress> engineerProgressList) {
		this.engineerProgressList = engineerProgressList;
	}

	public List<EngineerProgress> getEngineerProgress() {
		return engineerProgressList;
	}

}
