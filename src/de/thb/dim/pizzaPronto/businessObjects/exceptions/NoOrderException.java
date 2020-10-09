package de.thb.dim.pizzaPronto.businessObjects.exceptions;



public class NoOrderException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6889739443415526906L;

	/**
	 * Initialize Exception
	 */
	public NoOrderException(){
		super("Order could not be found.");
	}
	
	/**
	 * Initialize detailMessage
	 * 
	 * @param message 
	 */
	public NoOrderException(String message){
		super(message);
	}
}
