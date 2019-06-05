package com.sdp.shopping.products;

import com.sdp.shopping.visitor.Visitor;

public class FruitByWeight implements Product {
	
	private double pricePerKg;
	private String name;
	private double weight;
	//private double availability;
	private double cost;

	
	public FruitByWeight(String name, double price) {
		this.pricePerKg=price;
		this.name = name;
	}
		
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public double getPrice() {
		return pricePerKg;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmount() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public double getCost() {
		return cost;
	}


	

}
