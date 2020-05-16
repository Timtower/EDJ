/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:29
*/

package org.xenodev.edj.events.storage;

public class TradeData {
	
	String material, materialLocalised, category, categoryLocalised;
	Integer quantity;
	
	public TradeData(String material, String materialLocalised, String category, String categoryLocalised,
			Integer quantity) {
		this.material = material;
		this.materialLocalised = materialLocalised;
		this.category = category;
		this.categoryLocalised = categoryLocalised;
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterialLocalised() {
		return materialLocalised;
	}

	public void setMaterialLocalised(String materialLocalised) {
		this.materialLocalised = materialLocalised;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryLocalised() {
		return categoryLocalised;
	}

	public void setCategoryLocalised(String categoryLocalised) {
		this.categoryLocalised = categoryLocalised;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
