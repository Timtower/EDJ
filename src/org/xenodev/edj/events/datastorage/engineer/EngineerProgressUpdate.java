package org.xenodev.edj.events.datastorage.engineer;

import org.xenodev.edj.events.interfaces.EngineerProgressInfo;

public class EngineerProgressUpdate implements EngineerProgressInfo {
	
	private EngineerProgress progress;

	public EngineerProgressUpdate(EngineerProgress progress) {
		this.progress = progress;
	}

	public EngineerProgress getProgress() {
		return progress;
	}

}
