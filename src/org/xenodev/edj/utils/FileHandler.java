package org.xenodev.edj.utils;

import java.io.File;

import org.xenodev.edj.EDJApi;

public class FileHandler {

	public static File getLatestJournalFile() {
		File latest = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			 if(!file.isDirectory()) {
				 
				 if(file.getName().contains("Journal")) {
					 
					 if(latest == null) {
						 latest = file;
					 }else {
						 
						 if(latest.lastModified() < file.lastModified()) {
							 latest = file;
						 }
						 
					 }
					 
				 }
				 
			 }
			
		}
		
		return latest;
	}
	
	public static File getShipyardFile() {
		File shipyardFile = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			if(!file.isDirectory()) {
				
				if(file.getName().contains("Shipyard")) {
					shipyardFile = file;
				}
				
			}
			
		}
		
		return shipyardFile;
	}
	
	public static File getCargoFile() {
		File cargoFile = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			if(!file.isDirectory()) {
				
				if(file.getName().contains("Cargo")) {
					cargoFile = file;
				}
				
			}
			
		}
		
		return cargoFile;
	}
	
	public static File getMarketFile() {
		File marketFile = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			if(!file.isDirectory()) {
				
				if(file.getName().contains("Market")) {
					marketFile = file;
				}
				
			}
			
		}
		
		return marketFile;
	}
	
	public static File getModulesInfo() {
		File modulesInfoFile = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			if(!file.isDirectory()) {
				
				if(file.getName().contains("ModulesInfo")) {
					modulesInfoFile = file;
				}
				
			}
			
		}
		
		return modulesInfoFile;
	}
	
	public static File getOutfittingFile() {
		File outfittingFile = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			if(!file.isDirectory()) {
				
				if(file.getName().contains("Outfitting")) {
					outfittingFile = file;
				}
				
			}
			
		}
		
		return outfittingFile;
	}
	
	public static File getStatusFile() {
		File statusFile = null;
		
		for(File file : EDJApi.getJournalDir().toFile().listFiles()) {
			
			if(!file.isDirectory()) {
				
				if(file.getName().contains("Status")) {
					statusFile = file;
				}
				
			}
			
		}
		
		return statusFile;
	}

}