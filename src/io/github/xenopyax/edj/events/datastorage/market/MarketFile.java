package io.github.xenopyax.edj.events.datastorage.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.github.xenopyax.edj.utils.FileHandler;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MarketFile {
	
	private Integer marketID;
	private String stationName, starSystem;
	private List<Item> items;
	
	public MarketFile() {
		String marketFileContent = null;
		File file = FileHandler.getMarketFile();
		if(file != null) {
			try {
				FileInputStream fis = new FileInputStream(file);
				byte[] data = new byte[(int) file.length()];
				
				fis.read(data);
				fis.close();
	
				marketFileContent = new String(data, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			JSONArray array = new JSONObject(marketFileContent).getJSONArray("Items");
			items = JournalUtils.createItemList(array);
		}
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

	public List<Item> getItems() {
		return items;
	}

}
