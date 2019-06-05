package com.sdp.shopping.products;

import com.sdp.shopping.visitor.Visitor;

public class FruitByPiece implements Product {

	private double pricePerPiece;
	private String name;
	private int amount;
	//private int availability;
	private double cost;
	
	
	public FruitByPiece(String name, double price) {
		this.pricePerPiece=price;
		this.name = name;
	}
		
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public double getPrice() {
		return pricePerPiece;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setCost(double cost) {
		this.cost = cost;		
	}

	@Override
	public double getCost() {
		return cost;
	}
	

}
