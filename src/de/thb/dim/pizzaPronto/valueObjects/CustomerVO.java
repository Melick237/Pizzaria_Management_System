package de.thb.dim.pizzaPronto.valueObjects;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatter;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

/**
 * CustomerVO represents objects of customer.
 * @author Robert Fischer, Gabriele Schmidt
 * @version 3.0
 *
 */
public class CustomerVO  extends PersonVO {

	private static final long serialVersionUID = 1L;
	private static int nextId = 0;
	private int id;
	
	private Gender gender;
	private LocalDate dateOfBirth;
	
	private OrderVO order;

	/**
	 * initializing constructor
	 * Initialize all instance attributes with values. 
	 * 
	 * @param lastName - Customer's second name
	 * @param firstName - Customer's first name
	 * @param street - Customer's street
	 * @param houseNumber - Customer's house number
	 * @param gender - Customer's gender
	 * @param dateOfBirth - Customer's date of birth
	 * @throws CustomerTooYoungException 
	 * @throws NullPointerException 
	
	 */
	public CustomerVO(String lastName, String firstName, String street, int houseNumber, Gender gender, LocalDate dob) throws NullPointerException, CustomerTooYoungException {
		super(lastName, firstName, street, houseNumber);
		id = nextId;
		nextId++;
		setGender(gender);
		setDateOfBirth(dob);

	}
	
	/**
	 * initializing constructor
	 * Initialize all instance attributes with values. 
	 * 
	 * @param lastName - Customer's second name
	 * @param firstName - Customer's first name
	 * @param dateOfBirth - Customer's date of birth
	 * @throws CustomerTooYoungException 
	 * @throws NullPointerException 
	 * 
	 */
	public CustomerVO(String lastName, String firstName, LocalDate dob) throws NullPointerException, CustomerTooYoungException {
		this(lastName, firstName, null, 0, null, dob);

	}
	
	
	
	/**
	 * the age of customer is a drived attribute, i.e. age is only calculated 
	 * in the method and is not a instance variable
	 *
	 * @return age - short
	 * @throws CustomerNoDateOfBirthException 
	 */
	public short calculateAge() throws CustomerNoDateOfBirthException {
		short alter = -1;
		Period age;
		LocalDate today = LocalDate.now();
		
		if (dateOfBirth == null) {
			throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
		}

		if (dateOfBirth != null) {
			age = Period.between(dateOfBirth, today);
			alter = (short) age.getYears();
		}
		return alter;
	}
	
	/**
	 * Checks whether there is a current orderVO or not
	 * 
	 * @return true => orderVO available, false => there is no orderVO
	 * 
	 */
	public boolean hasOrder() {
		if (order != null) return true;
		else return false;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
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
		CustomerVO other = (CustomerVO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("ID: " + getId());
		
		sb.append("\t" + super.toString());
		
		sb.append("\t" + this.getGender().toString());
		
		try {
			sb.append("\tDate of Birth: " + dobToString());
			sb.append("\tAge: " + calculateAge());
		} catch (CustomerNoDateOfBirthException e) {
			System.err.println(e.getMessage());
		}
		
		if (hasOrder()) {
			sb.append("\nOrder available: \n");
			sb.append(order.toString());
		}
		else sb.append("\nNo order available\n");
		
		return sb.toString();
	}
	
	
	/**
	 * Returns the birth date in human-readable form.
	 * 
	 * @return - the complete string
	 *  
	 */
	private String dobToString() throws CustomerNoDateOfBirthException {
		String s = null;
		if (dateOfBirth == null) {
			throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
		}
		else s = dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
		return s;
	}
	
	//Setter getter
	//only getter für nextID and id
	public static int getNextId() {
		return nextId;
	}
	
	public int getId() {
		return id;
	}


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	

	/**
	 * older than 17 years else dateOfBirth is set null
	 * 
	 * @param dob
	 * @throws CustomerTooYoungException
	 * @throws NullPointerException
	 */
	public void setDateOfBirth(LocalDate dob) throws CustomerTooYoungException, NullPointerException{
		
		Objects.requireNonNull(dob, "dob must not be null");
		
		dateOfBirth = dob;
		
		try {
			if (this.calculateAge() < 18)
				throw new CustomerTooYoungException("Customer is not an adult.");
		} catch (CustomerNoDateOfBirthException e) {
			System.err.println(e.getMessage());
		}
	}
	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO orderVO) {
		this.order = orderVO;
	}
	

	
} // end of class