package com.sdp.shopping.products;

import com.sdp.shopping.visitor.Visitor;

public interface Product {
	public void accept(Visitor visitor);
	
	public String getName();
	public double getPrice();
	//public double getAvailability();
	public double getAmount();
	public void setCost(double cost);
	public double getCost();
	}
