package io.github.xenopyax.edj;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EDJApi {
	
	private static Path journalDir = Paths.get(System.getProperty("user.home") + "/Saved Games/Frontier Developments/Elite Dangerous/");

	public static Path getJournalDir() {
		return journalDir;
	}

}
