package io.github.xenopyax.edj.events.datastorage.engineer;

import java.util.List;

import io.github.xenopyax.edj.events.interfaces.EngineerProgressInfo;

public class EngineerProgressStartup implements EngineerProgressInfo {
	
	private List<EngineerProgress> engineerProgressList;

	public EngineerProgressStartup(List<EngineerProgress> engineerProgressList) {
		this.engineerProgressList = engineerProgressList;
	}

	public List<EngineerProgress> getEngineerProgress() {
		return engineerProgressList;
	}

}
