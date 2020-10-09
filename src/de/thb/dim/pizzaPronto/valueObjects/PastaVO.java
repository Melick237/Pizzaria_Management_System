package de.thb.dim.pizzaPronto.valueObjects;

/**
 * @author Robert Fischer, Gabriele Schmidt
 * @version 0.1
 * @since 27.05.2013
 *
 */
public class PastaVO extends DishVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeOfPasta;
	
	
	public PastaVO(int number, String name, String[] ingredients, float price, int pastaType) {
		super(number, name, ingredients, price);
		setTypeOfPasta(pastaType);
	}
	
	/**
	 * Defaultkonstruktor 
	 * Ruft den Initialisierungskonstruktor auf, um Standardwerte f�r Instanzattribute zu setzen.
	 * 
	 */
	public PastaVO() {
		this(0, null, null, 0.00f, 0);
	}
	

	
	
	///
	/// Getter und Setter
	///
	public int getTypeOfPasta() {
		return typeOfPasta;
	}

	public void setTypeOfPasta(int pastaType) {
		this.typeOfPasta = pastaType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + typeOfPasta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PastaVO other = (PastaVO) obj;
		if (typeOfPasta != other.typeOfPasta)
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "PastaVO [" + super.toString() + "\t typeOfPasta =" + typeOfPasta  + "]\n";
//	}
	
	@Override
	public String getNameOfDish() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pasta ");
		
		switch(typeOfPasta) {
			case 4 : 
				sb.append(getName() + " - Spaghetti");
				break;
			case 5 : 
				sb.append(getName() + " - Tortellini");
				break;
			case 6 : 
				sb.append(getName() + " - Gnocchi");
				break;
			default : 
				sb.append(getName());
				break;
		}
		
		return sb.toString();
	}

	@Override
	public int getNumberOfDish() {
		return this.typeOfPasta * 100 + this.number;
	}
		
	
	
} 
