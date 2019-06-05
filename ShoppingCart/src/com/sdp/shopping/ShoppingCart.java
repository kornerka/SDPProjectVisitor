package com.sdp.shopping;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.sdp.shopping.products.Drink;
import com.sdp.shopping.products.FruitByPiece;
import com.sdp.shopping.products.FruitByWeight;
import com.sdp.shopping.products.Product;
import com.sdp.shopping.visitor.ShoppingCartVisitor;
import com.sdp.shopping.visitor.Visitor;

public class ShoppingCart {
	
	static Visitor visitor = new ShoppingCartVisitor();
	
	public static ArrayList<Product> cart = new ArrayList<Product>();
	
	//initializing variable that will keep the total cost of the cart
	public static double totalCost = 0;

	//creating the products
	public static FruitByPiece kiwi = new FruitByPiece("kiwi", 0.99);
	public static FruitByPiece lime = new FruitByPiece("lime", 1.39);
	public static FruitByWeight banana = new FruitByWeight("banana", 4.49);
	public static FruitByWeight apple = new FruitByWeight("apple", 2.49);
	public static FruitByWeight orange = new FruitByWeight("orange", 4.99);
	public static Drink stillWater = new Drink("still water", 1.46);
	public static Drink sparklingWater = new Drink("sparkling water", 1.57);
	
	//an array with available products
	public static Product[] stock = new Product[] {
			kiwi,
			lime,
			banana,
			apple,
			orange,
			stillWater,
			sparklingWater
	};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String mainMenu = "Choose an option from the menu:\n\n [A]dd products to cart \n [V]iew cart contents \n [D]isplay total value of the cart \n [R]emove item from cart \n [Q]uit app \n";
		System.out.println(mainMenu);
		
		String menuChoice = scanner.nextLine();
		boolean timeToQuit = false;
		
		//the loop with menu choices - base of the app
		do {
			
			switch (menuChoice) {

			case "A":
				try {
					addToCart();
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input.\n");
				}
				System.out.println(mainMenu);
				menuChoice = scanner.nextLine();
				break;
			
			case "V":
				viewCart();
				System.out.println(mainMenu);
				menuChoice = scanner.nextLine();
				break;
			
			case "D":
				System.out.println("Total value of cart: "+(Math.round(totalCost*100.0)/100.0)+"\n");
				System.out.println(mainMenu);
				menuChoice = scanner.nextLine();
				break;
				
			case "R":
				try {
					removeItem();
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input.\n");
				}
				System.out.println(mainMenu);
				menuChoice = scanner.nextLine();
				break;				
				
			case "Q":
				timeToQuit = true;
				break;
			
			default:
				System.out.println("Incorrect input\n");
				System.out.println(mainMenu);
				menuChoice = scanner.nextLine();
				break;
			}
		} while (timeToQuit==false);

	}
	
	
	public static void addToCart(){
		
		viewStock();
		
		System.out.println("\nChoose product number:\n");

		Scanner pScanner = new Scanner(System.in);
		int productChoice = pScanner.nextInt();
		
		//getting chosen product from the stock array and adding to cart
		Product addedProduct = stock[productChoice];
		cart.add(addedProduct);

		//accepting visitor for amount input and calculating cost
		addedProduct.accept(visitor);

		//adding product cost to total cost of the cart
		totalCost += addedProduct.getCost();
		
		System.out.println("\n"+addedProduct.getName() +" was added to cart\n");
		}
	
	public static void viewCart() {
		if (cart.isEmpty()==true) {
			System.out.println("Your cart is empty");
		} else {
			int i = 0;
			System.out.println("Your cart:");
			for(Product p: cart) {
				System.out.println("["+i+"] " + p.getName()+", amount: "+p.getAmount()+", cost: "+(Math.round(p.getCost()*100.0)/100.0));
				i++;
			}
		}
	}
	
	public static void viewStock() {
		System.out.println("List of products:\n");
		for (int i = 0; i < stock.length; i++) {
			System.out.println("["+i+"] "+stock[i].getName()+", price: "+stock[i].getPrice());
		}
	}
	
	public static void removeItem() {
		viewCart();

		System.out.println("Choose the number of product that you want to remove:");
		
		Scanner rScanner = new Scanner(System.in);
		int removeIndex = rScanner.nextInt();
		
		//subtracting the cost of removed product from the total value
		double removedCost = cart.get(removeIndex).getCost();
		totalCost -= removedCost;
		
		String removedName = cart.get(removeIndex).getName();
		
		//removing product from cart
		cart.remove(removeIndex);
		
		System.out.println(removedName+" was removed from your cart \n");
	}
}

