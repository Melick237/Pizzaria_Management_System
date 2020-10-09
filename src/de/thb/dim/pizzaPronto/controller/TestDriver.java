package de.thb.dim.pizzaPronto.controller;

import java.time.LocalDate;

import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.Ordering;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.Gender;

class TestDriver {

	public static void main(String[] args) {

		MenuVO menu;
		CustomerVO customer1 = null,customer2 = null;
		Ordering ordering1, ordering2;
		Random zufall = new Random();

		

		// Kunde1
		try {
			customer1 = new CustomerVO("Mampf", "Manfred", "Essensstra�e", 42,
					Gender.M, LocalDate.of(1990, 6, 28));
		} catch (NullPointerException | CustomerTooYoungException e1) {
			System.err.println(e1.getMessage());
		}
		ordering1 = new Ordering();
		
		try {
		ordering1.startNewOrder(customer1);
		} catch (NullPointerException  e1) {
			System.err.println(e1.getMessage());
		}
		
		menu = Ordering.getMenu();
		// zuf�llige Testbestellung f�r Kunde1 speichern aus Speisekarte
		for (int i = 0; i < 5; i++) {
			try {
				ordering1.addDish(menu.getDish(zufall
						.nextInt(18)));
			} catch (IllegalStateException | NoOrderException e) {
				System.err.println(e.getMessage());
			}
		}

		
	

		// Kunde2 
		try {
			customer2 = new CustomerVO("Genuss", "Gini", "Haribostra�e", 32, Gender.F,
					LocalDate.of(1995, 8, 8));
		} catch (NullPointerException | CustomerTooYoungException e1) {
			
			System.err.println(e1.getMessage());
		}
		ordering2 = new Ordering();
		try {
			ordering2.startNewOrder(customer1);
			} catch (NullPointerException  e1) {
				System.err.println(e1.getMessage());
			}

		// zuf�llige Testbestellung f�r Kunde1 speichern aus Speisekarte
		for (int i = 0; i < 3; i++) {
			try {
				ordering2.addDish(menu.getDish(zufall
						.nextInt(18)));
			} catch (IllegalStateException | NoOrderException e) {
				System.err.println(e.getMessage());
			}
		}
		

		// Speisekarte ausgeben
		System.out.println(menu.toString());
		
		//Bestellen
		try {
			ordering1.confirmOrder();
		} catch (IllegalStateException | NullPointerException | NoOrderException | NoCustomerException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			ordering1.confirmOrder();
		} catch (IllegalStateException | NullPointerException | NoOrderException | NoCustomerException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(customer1);
		System.out.println(customer2);

		
		System.out.println(ordering1.getCurrentOrder().getShoppingBasket());
		
	}
}
