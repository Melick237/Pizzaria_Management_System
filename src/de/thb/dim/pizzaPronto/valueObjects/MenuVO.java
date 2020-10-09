package de.thb.dim.pizzaPronto.valueObjects;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MenuVO {
	private List<DishVO> dishes;
	
	public MenuVO(ArrayList<DishVO> dishes) {
		this.dishes = dishes;
	}

	/**
	 * Defaultkonstruktor
	 * 
	 */
	public MenuVO() {
		initMenu();
	}

	/**
	 * Method to initialize the menu and create all objects of dishes.
	 * 
	 */
	private void initMenu() {
		this.dishes = new ArrayList<DishVO>();

		dishes.add( new PizzaVO(30, "Popeye", new String[] { "Schinken",
				"Spinat", "Champignon", "Ei" }, 7.00f, 1));
		dishes.add( new PizzaVO(30, "Popeye", new String[] { "Schinken",
				"Spinat", "Champignon", "Ei" }, 8.90f, 2));
		dishes.add(  new PizzaVO(31, "Hawaii", new String[] { "Schinken",
				"Ananas", "Curry" }, 5.80f, 1));
		dishes.add( new PizzaVO(31, "Hawaii", new String[] { "Schinken",
				"Ananas", "Curry" }, 7.40f, 2));

		
		dishes.add( new PizzaVO(32, "Prima", new String[] { "Schinken",
				"Salami", "Zwiebeln", "Ei" }, 7.00f, 1));
		dishes.add( new PizzaVO(32, "Prima", new String[] { "Schinken",
				"Salami", "Zwiebeln", "Ei" }, 8.90f, 2));

		dishes.add( new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },
				5.60f, 4));
		dishes.add( new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },
				5.60f, 5));
		dishes.add( new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },
				5.60f, 6));
		dishes.add( new PastaVO(12, "Bolognese",
				new String[] { "Hackfleischsauce" }, 6.40f, 4));
		dishes.add( new PastaVO(12, "Bolognese",
				new String[] { "Hackfleischsauce" }, 6.40f, 5));
		dishes.add( new PastaVO(12, "Bolognese",
				new String[] { "Hackfleischsauce" }, 6.40f, 6));
		dishes.add( new PastaVO(13, "alla Panna", new String[] { "Schinken",
				"Sahne" }, 6.40f, 4));
		dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken",
				"Sahne" }, 6.40f, 5));
		dishes.add( new PastaVO(13, "alla Panna", new String[] { "Schinken",
				"Sahne" }, 6.40f, 6));

		dishes.add( new DessertVO(21, "Hausgemachter Obstsalat", 2.30f));
		dishes.add( new DessertVO(22, "Hausgemachte Pannacotta", 2.60f));
		dishes.add( new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f));
	}

	/**
	 * Returns the object in human-readable form. Calls for getter of the individual courts. 
	 * Is based on the initialization sequence: pizza, pasta, dessert
	 * @return - complete String
	 * 
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		DecimalFormat dFormat = new DecimalFormat(".00"); //Format the price ...

		sb.append("MENU PIZZA PRONTO\n\n");
		// Pizzas
		sb.append("Prima special pizzas: \n   1 normal (Diameter approx. 26 cm) and \n   2 grande (Diameter approx. 32 cm)\n");
		int i = 0;
		do {
			sb.append(dishes.get(i).getNumber() + "\t");
			sb.append(dishes.get(i).getName() + "\t");
			sb.append(dishes.get(i).ingredientsToString());
			sb.append("\n\tPrice:\t\t\t"
					+ dFormat.format(dishes.get(i).getPrice()) + " Euro");
			if(dishes.get(i).getNumber() == dishes.get(i+1).getNumber()){
				sb.append("\n\tPrice:\t\t\t"
						+ dFormat.format(dishes.get(i+1).getPrice()) + " Euro");
				sb.append("\n");
				i+=2;
			}
			else i++;
		} while (i < dishes.size() && dishes.get(i) instanceof PizzaVO );
		
		//Pasta 
		
		sb.append("\nPrima special pastas: \n4  Spaghetti\n5  Tortellini\n6  Gnocchi\n");
		do {
			sb.append(" " + dishes.get(i).getNumber() + "\t");
			sb.append(dishes.get(i).getName() + "\t");

			sb.append(dishes.get(i).ingredientsToString());

			sb.append("\n\tPrice:\t\t\t"
					+ dFormat.format(dishes.get(i).getPrice()) + " Euro");
			if(dishes.get(i).getNumber() == dishes.get(i+1).getNumber() && dishes.get(i).getNumber() == dishes.get(i+2).getNumber()){
				i+=3;
			} else {
			if(dishes.get(i).getNumber() == dishes.get(i+1).getNumber()){
				i+=2;
			}
			else
				i++;
			}
			sb.append("\n");
		} while (i < dishes.size() && dishes.get(i) instanceof PastaVO);
		
		sb.append("\nPrima desserts\n");
		do {
			sb.append(dishes.get(i).getNumber() + "\t");
			sb.append(dishes.get(i).getName() + "\t");

			sb.append(dishes.get(i).ingredientsToString());

			sb.append("\n\tPrice:\t\t\t"
					+ dFormat.format(dishes.get(i).getPrice()) + " Euro");
			sb.append("\n");
			i++;
		} while (i < dishes.size() && dishes.get(i) instanceof DessertVO);

		return sb.toString();
	}

	
	
	// /
	// / Getter und Setter
	// /
	public DishVO getDish(int index) {
			return dishes.get(index);
	}

	public int getNumberOfDishes() {
		return dishes.size();
	}

} 

