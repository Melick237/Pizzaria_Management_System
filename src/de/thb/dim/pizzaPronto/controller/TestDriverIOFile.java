package de.thb.dim.pizzaPronto.controller;


import java.io.FileNotFoundException;
import java.io.IOException;

import de.thb.dim.pizzaPronto.businessObjects.io.MenuImporter;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;




class TestDriverIOFile {

	public static void main(String[] args) {

		MenuVO menu;
		MenuImporter importer = null;

		try {
			importer = new MenuImporter();
			menu = importer.readMenu("myLittleMenu.txt");
			System.out.println(menu.toString());
		} catch (FileNotFoundException e1) {
			System.err.println("File not found: " + e1.getMessage());
			e1.printStackTrace();
		} catch (IOException e1) {
		System.err.println("File not found");
		e1.printStackTrace();
	}
	}
}
