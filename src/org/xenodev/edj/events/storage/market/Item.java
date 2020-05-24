package org.xenodev.edj.events.storage.market;

public class Item {
	
	private Integer id, buyPricce, sellPrice, meanPrice, stockBracket, demandBracket, stock, demand;
	private String name, category;
	private Boolean consumer, producer, rare;
	
	public Item(Integer id, Integer buyPricce, Integer sellPrice, Integer meanPrice, Integer stockBracket,
			Integer demandBracket, Integer stock, Integer demand, String name, String category, Boolean consumer,
			Boolean producer, Boolean rare) {
		this.id = id;
		this.buyPricce = buyPricce;
		this.sellPrice = sellPrice;
		this.meanPrice = meanPrice;
		this.stockBracket = stockBracket;
		this.demandBracket = demandBracket;
		this.stock = stock;
		this.demand = demand;
		this.name = name;
		this.category = category;
		this.consumer = consumer;
		this.producer = producer;
		this.rare = rare;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBuyPricce(Integer buyPricce) {
		this.buyPricce = buyPricce;
	}

	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setMeanPrice(Integer meanPrice) {
		this.meanPrice = meanPrice;
	}

	public void setStockBracket(Integer stockBracket) {
		this.stockBracket = stockBracket;
	}

	public void setDemandBracket(Integer demandBracket) {
		this.demandBracket = demandBracket;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setDemand(Integer demand) {
		this.demand = demand;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setConsumer(Boolean consumer) {
		this.consumer = consumer;
	}

	public void setProducer(Boolean producer) {
		this.producer = producer;
	}

	public void setRare(Boolean rare) {
		this.rare = rare;
	}

	public Integer getBuyPricce() {
		return buyPricce;
	}

	public Integer getSellPrice() {
		return sellPrice;
	}

	public Integer getMeanPrice() {
		return meanPrice;
	}

	public Integer getStockBracket() {
		return stockBracket;
	}

	public Integer getDemandBracket() {
		return demandBracket;
	}

	public Integer getStock() {
		return stock;
	}

	public Integer getDemand() {
		return demand;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Boolean getConsumer() {
		return consumer;
	}

	public Boolean getProducer() {
		return producer;
	}

	public Boolean getRare() {
		return rare;
	}

}
