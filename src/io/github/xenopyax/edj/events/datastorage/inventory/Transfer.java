/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:09
*/

package io.github.xenopyax.edj.events.datastorage.inventory;

public class Transfer {
	
	private String type, typeLocalised, direction;
	private Integer count;
	
	public Transfer(String type, String typeLocalised, String direction, Integer count) {
		this.type = type;
		this.typeLocalised = typeLocalised;
		this.direction = direction;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

	public String getDirection() {
		return direction;
	}

	public Integer getCount() {
		return count;
	}

}
