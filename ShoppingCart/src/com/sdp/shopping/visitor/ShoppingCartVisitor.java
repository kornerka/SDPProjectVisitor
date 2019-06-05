package com.sdp.shopping.visitor;

import java.util.Scanner;

import com.sdp.shopping.products.Drink;
import com.sdp.shopping.products.FruitByPiece;
import com.sdp.shopping.products.FruitByWeight;

public class ShoppingCartVisitor implements Visitor {

	Scanner amountScanner = new Scanner(System.in);
	
	@Override
	public void visit(Drink drink) {
		// adds also a cost of a glass bottle (it's an eco-shop) - only 1 liter bottles are available
		System.out.println("\nInput volume you want to buy\n");
		double inputVolume = amountScanner.nextDouble();
		drink.setVolume(inputVolume);
		double bottleCost = Math.ceil(drink.getAmount())*drink.getBottlePrice();
		double cost = drink.getPrice()*drink.getAmount()+bottleCost;
		drink.setCost(cost);
	}

	@Override
	public void visit(FruitByPiece fruitPiece) {
		System.out.println("\nInput amount you want to buy\n");
		int inputAmount = amountScanner.nextInt();
		fruitPiece.setAmount(inputAmount);
		double cost = fruitPiece.getPrice()*fruitPiece.getAmount();
		fruitPiece.setCost(cost);
	}

	@Override
	public void visit(FruitByWeight fruitKg) {
		System.out.println("\nInput weight you want to buy\n");
		double inputWeight = amountScanner.nextDouble();
		fruitKg.setWeight(inputWeight);
		double cost = fruitKg.getPrice()*fruitKg.getAmount();
		fruitKg.setCost(cost);
	}

}
