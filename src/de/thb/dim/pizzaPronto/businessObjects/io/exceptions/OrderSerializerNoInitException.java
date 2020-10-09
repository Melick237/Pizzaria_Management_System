package de.thb.dim.pizzaPronto.businessObjects.io.exceptions;

public class OrderSerializerNoInitException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4379684360813511592L;

	/**
	 * Initialize Exception
	 */
	public OrderSerializerNoInitException(){
		super("No customer was indicated.");
	}
	
	/**
	 * Initialize detailMessage
	 * 
	 * @param message 
	 */
	public OrderSerializerNoInitException(String message){
		super(message);
	}
}
