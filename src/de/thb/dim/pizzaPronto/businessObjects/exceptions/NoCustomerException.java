package de.thb.dim.pizzaPronto.businessObjects.exceptions;

public class NoCustomerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4379684360813511592L;

	/**
	 * Initialize Exception
	 */
	public NoCustomerException(){
		super("No customer was indicated.");
	}
	
	/**
	 * Initialize detailMessage
	 * 
	 * @param message 
	 */
	public NoCustomerException(String message){
		super(message);
	}
}
