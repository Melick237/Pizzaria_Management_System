package de.thb.dim.pizzaPronto.valueObjects.exceptions;



public class CustomerNoDateOfBirthException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3319565690504052208L;

	/**
	 * Initialize Exception
	 */
	public CustomerNoDateOfBirthException(){
		super("There is no date of birth available.");
	}
	
	/**
	 * Initialize detailMessage
	 * 
	 * @param message 
	 */
	public CustomerNoDateOfBirthException(String message){
		super(message);
	}
}
