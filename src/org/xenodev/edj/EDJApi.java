package org.xenodev.edj;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EDJApi {
	
	public static final String VERSION = "0.1.0-alpha";
	private static Path journalDir = Paths.get(System.getProperty("user.home") + "/Saved Games/Frontier Developments/Elite Dangerous/");

	public static Path getJournalDir() {
		return journalDir;
	}

}
