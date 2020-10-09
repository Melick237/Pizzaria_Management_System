package de.thb.dim.pizzaPronto.valueObjects.exceptions;




public class CustomerTooYoungException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5165067382209404005L;

	/**
	 * Initialize Exception
	 */
	public CustomerTooYoungException(){
		super("Customer is too jung.");
	}
	
	/**
	 * Initialize detailMessage
	 * 
	 * @param message 
	 */
	public CustomerTooYoungException(String message){
		super(message);
	}
}
