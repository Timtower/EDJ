package org.xenodev.edj.events.storage.engineer;

import org.xenodev.edj.events.interfaces.EngineerProgressInfo;

public class EngineerProgressStartup implements EngineerProgressInfo {
	
	private EngineerProgress[] engineerProgress;

	public EngineerProgressStartup(EngineerProgress[] engineerProgress) {
		this.engineerProgress = engineerProgress;
	}

	public EngineerProgress[] getEngineerProgress() {
		return engineerProgress;
	}

	public void setEngineerProgress(EngineerProgress[] engineerProgress) {
		this.engineerProgress = engineerProgress;
	}

}
