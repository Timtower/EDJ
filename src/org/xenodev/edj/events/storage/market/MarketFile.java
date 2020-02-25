package org.xenodev.edj.events.storage.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xenodev.edj.utils.FileHandler;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

public class MarketFile {
	
	private Integer marketID;
	private String stationName, starSystem;
	private Item[] items;
	
	public MarketFile() {
		String marketFileContent = null;
		try {
			File file = FileHandler.getMarketFile();
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			
			fis.read(data);
			fis.close();

			marketFileContent = new String(data, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONArray array = JsonTranslator.getJSONArray(new JSONObject(marketFileContent), "Items");
		items = JournalUtils.createItemList(array);
	}

	public Integer getMarketID() {
		return marketID;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Item[] getItems() {
		return items;
	}

}
