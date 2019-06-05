package com.sdp.shopping.visitor;

import com.sdp.shopping.products.Drink;
import com.sdp.shopping.products.FruitByPiece;
import com.sdp.shopping.products.FruitByWeight;

public interface Visitor {
	
	public void visit(Drink drink);
	public void visit(FruitByPiece fruitPiece);
	public void visit(FruitByWeight fruitKg);

}
