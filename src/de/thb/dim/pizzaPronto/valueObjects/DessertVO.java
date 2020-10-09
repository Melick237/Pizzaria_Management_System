package de.thb.dim.pizzaPronto.valueObjects;


/**
 *  
 * @author Robert Fischer, Gabriele Schmidt
 * @version 0.1
 * @since 27.05.2013
 *
 */
public class DessertVO extends DishVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialisierungkonstruktor
	 * Initialisiert die Werte der Instanzattribute, ruft Konstruktor der Oberklasse auf.
	 *  
	 * @param number - Nummer des Dessert
	 * @param name - Name des Dessert
	 * @param price - Preis des Dessert
	 * 
	 */
	public DessertVO(int number, String name, float price) {
		super(number, name, price);
	}
	
	/**
	 * Defaultkonstruktor 
	 * Ruft den Initialisierungskonstruktor auf, um Standardwerte f�r Instanzattribute zu setzen.
	 * 
	 */
	public DessertVO() {
		this(0, null, 0.00f);
	}
	
	
	
//	public String toString() {
//		
//		StringBuffer sb = new StringBuffer(); // R�ckgabewert ...
//		sb.append("Dessert: " );
//		sb.append(super.toString());
//		
//		return sb.toString();
//	}


	@Override
	public String getNameOfDish() {
		return this.name;
	}

	@Override
	public int getNumberOfDish() {
		return this.number;
	}
		

} // Ende Klasse
