package de.thb.dim.pizzaPronto.businessObjects;


import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;

import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

public class Kitchen implements IService {  

	private EmployeeVO[] employees;

	public Kitchen() {
		employees = new EmployeeVO[1];
		// Koch erstellen
		employees[0] = new ChefVO("Koch5Sterne", "Bocuse", "Bruno");
	}

	@Override
	public String startService(OrderVO order) throws NullPointerException, IllegalStateException{
		String s = String.format("\nService of ChefVO %s: No order available.", employees[0].getPersonnelNo());

		Objects.requireNonNull(order, s);
		
			if (order.getState() != StateOfOrderVO.CONFIRMED) {
				
				s = String.format("\nService of ChefVO %s: No order for processing available.",
						employees[0].getPersonnelNo());
				throw new IllegalStateException(s);
			}
			else {
				order.setState(StateOfOrderVO.READY);
				s  = String.format("\nService of ChefVO %s: Order is ready.", employees[0].getPersonnelNo());
			} 
			return s;
	}

	/**
	 * @return the employees
	 */
	public EmployeeVO[] getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}
	
	
}
