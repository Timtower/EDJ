/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 07:00
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class SellDronesEvent extends Event {
	
	String type;
	Integer count;
	Long sellPrice, totalSale;
	
	public SellDronesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = json.getString("Type");
		this.count = json.getInt("Count");
		this.sellPrice = json.getLong("SellPrice");
		this.totalSale = json.getLong("TotalSale");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Long getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(Long totalSale) {
		this.totalSale = totalSale;
	}
	
}
