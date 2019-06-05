package com.sdp.shopping.products;

import com.sdp.shopping.visitor.Visitor;

public class Drink implements Product {
	
	private double pricePerLiter;
	private String name;
	private double volume;
	private double bottlePrice = 1.5;
	//private double availability;
	private double cost;

	
	public Drink(String name, double price) {
		this.pricePerLiter = price;
		this.name = name;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
	public double getPrice() {
		return pricePerLiter;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmount() {
		return volume;
	}
	
	public double getBottlePrice() {
		return bottlePrice;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}


	public void setCost(double cost) {
		this.cost = cost;
		
	}

	@Override
	public double getCost() {
		return cost;
	}

}
