package de.thb.dim.pizzaPronto.controller;


import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;

public class TestMenu {

	public static void main(String[] args) {
		MenuVO menu = new MenuVO();
		DishVO dishes [] = new DishVO[menu.getNumberOfDishes()];
			
			
		System.out.println(menu.toString());
		
		// Einmal die ganzen Speisen aus der Speisekarte abrufen
		// und ausgeben.
		
		System.out.println("\n");
		
		for(int i = 0; i < menu.getNumberOfDishes();++i){
			dishes[i] = menu.getDish(i);
			System.out.println(dishes[i].toString());
		}

	}

}
