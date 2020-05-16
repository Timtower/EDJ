/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:52
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class PayFinesEvent extends Event {
	
	Long amount;

	public PayFinesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.amount = json.getLong("Amount");
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
