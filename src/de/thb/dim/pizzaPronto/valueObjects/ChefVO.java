package de.thb.dim.pizzaPronto.valueObjects;
import java.awt.Color;

/**
 * ChefVO represents the objects of chef 
 * @author Robert Fischer, Gabriele Schmidt
 * @version 3.0
 *
 */
public class ChefVO extends EmployeeVO{
	private Color colorApron;
	
	/**
	 * initializing constructor
	 * Initialize all instance attributes with values. 
	 * 
	 * @param lastName - Chef's second name
	 * @param firstName - Chef's first name
	 * @param colorApron - Color of apron
	 *  
	 */
	public ChefVO(String pNo,String lastName, String firstName) {
		super( pNo, lastName,  firstName);
	}
	
	/**
	 * default constructor 
	 * calls initializing constructor with default values for instance attributes
	 * 
	 */
	public ChefVO() {
		this(null, null,null);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nChef:\n" );
		
		sb.append(super.toString());
		
		if(colorApron != null)
			sb.append("\nApron " + colorApron.toString());
		
		return sb.toString();
	}

	
	/// 
	/// Setter und Getter
	///

	public Color getColorApron() {
		return colorApron;
	}

	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}
} // End  of class
