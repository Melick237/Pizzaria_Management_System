package de.thb.dim.pizzaPronto.valueObjects;

/**
 * EmployeeVO represents an object of employees and inherits from PersonVO 
 * 
 */
public abstract class EmployeeVO extends PersonVO {
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	
	public EmployeeVO(String personnelNo, String lastName, String firstName) {
		super(lastName, firstName);
		setPersonnelNo(personnelNo);
	}

	
	public EmployeeVO() {
		this(null, null, null);
	}
	
	//Java standard operations
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((personnelNo == null) ? 0 : personnelNo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
//		if (!super.equals(obj))
//			return false;
		if (getClass() != obj.getClass()) {
			return false;}
		EmployeeVO other = (EmployeeVO) obj;
		if (personnelNo == null) {
			if (other.personnelNo != null)
				return false;
		} else if (!personnelNo.equals(other.personnelNo))
			return false;
		return true;
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(getPersonnelNo() + " ");

		sb.append(super.toString());

		sb.append("\tSalary: " + getSalary() + "\n");
		sb.append("\tNumber of vacation days: " + getVacationDays());

		return sb.toString();
	}


	//
	// Setter und Getter
	//
	public String getPersonnelNo() {
		return personnelNo;
	}

	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
} 
