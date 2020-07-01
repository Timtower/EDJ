/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 07:00
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SellDronesEvent extends Event {
	
	private String type;
	private Integer count;
	private Long sellPrice, totalSale;
	
	public SellDronesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.count = json.pullInt("Count");
		this.sellPrice = json.pullLong("SellPrice");
		this.totalSale = json.pullLong("TotalSale");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public Integer getCount() {
		return count;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Long getTotalSale() {
		return totalSale;
	}

}
