package de.thb.dim.pizzaPronto.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.Ordering;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.Gender;

class TestDriverOrdering {

	public static void main(String[] args) {

		MenuVO menu;
		CustomerVO customer1 = null;
		Ordering ordering1;
		Random zufall = new Random();
		List<DishVO> sB;

		
 
		// Kunde1
		try {
			customer1 = new CustomerVO("Mampf", "Manfred", "Essensstra�e", 42,
					Gender.M, LocalDate.of(1990, 6, 28));
		} catch (NullPointerException | CustomerTooYoungException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());

		}
		ordering1 = new Ordering();
		ordering1.startNewOrder(customer1);
		
		menu = Ordering.getMenu();
		// zuf�llige Testbestellung f�r Kunde1 speichern aus Speisekarte
		for (int i = 0; i < 10; i++) {
			try {
				ordering1.addDish(menu.getDish(zufall
						.nextInt(18)));
			} catch (IllegalStateException | NoOrderException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());

			}
		}
		
		sB = ordering1.getCurrentOrder().getShoppingBasket();
		System.out.println(sB);

	
		System.out.println("Natürliche Ordnung");
		try {
			sB = ordering1.sortShoppingBasket();
		} catch (NoOrderException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());

		}
		System.out.println(sB);
		

		System.out.println("Number of Dish");
		try {
			sB = ordering1.sortShoppingBasketByNumber();
		} catch (NoOrderException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());

		}
		System.out.println(sB);
		

		System.out.println("Price");
		try {
			sB = ordering1.sortShoppingBasketByPrice();
		} catch (NoOrderException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());

		}
		System.out.println(sB);
		
	}
}
