package de.thb.dim.pizzaPronto.valueObjects;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * The class OrderVO contains the begin and the end, i.e. delivery, of order as
 * a date timestamp Furthermore the class provides an objectmamagement of the
 * ordered pizzas (later dishes). The order has an identifiers.
 * 
 * @author Gabriele Schmidt
 * @version 2.0
 *
 */

public class OrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderNo;
	private StateOfOrderVO state;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private List<DishVO> shoppingBasket;
	private CustomerVO customer;

	public OrderVO(int orderNo, StateOfOrderVO state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
		
		this.orderNo = orderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		this.setState(state);		
		shoppingBasket = new LinkedList<DishVO>();
	}

	/**
	 * Methode for adding a dish to the shopping basket of OrderVO. Object is
	 * inserted in the position index, if the maximum number yet was not reached.
	 * 
	 * @param dish - the to be added dish
	 * 
	 */
	public void addDish(DishVO dish) {
			shoppingBasket.add(dish); // add dish 
	}

	/**
	 * Methode for deleting the dish from the shoppingbasket of OrderVO at the index
	 * 
	 */
	public void deleteDish(int index) {
		
			shoppingBasket.remove(index); // delete object at position index 

	}
	
	/**
	 * Methode for deleting the dish from the shoppingbaske of OrderVO.
	 * 
	 */
	public void deleteDish(DishVO dish) {
		
			shoppingBasket.remove(dish); // delete object at position index 

	}

	/**
	 * Calculates the total price of the order.
	 * 
	 * @return - totalPrice
	 * 
	 */
	public float calculatePriceDishes() {
		float total = 0.0f; // Gesamtpreis = 0 ...

		for (DishVO currentDish : shoppingBasket) { // f�r alle Gerichte im
													// Warenkorb ...
			if (currentDish != null)
				total += currentDish.getPrice(); // Gesamtpreis = Gesamtpreis
													// + Preis der aktuellen
													// Gericht ...
		}
		return total;
	}

	/**
	 * Method returns the dish at the position of index.
	 * 
	 * @param index - Index
	 * @return - objects of PizzaVO later Dishes, is null if no object exists on
	 *         position index
	 * 
	 */
	public DishVO  getDish(int index) {
		
			return shoppingBasket.get(index);
	}

	/**
	 * Method returns number of dishes
	 * 
	 * @return - number of pizzas
	 * 
	 */
	public int getNumberOfDishes() {
		return shoppingBasket.size();
	}

	// default management method of Java

	public String toString() {

		StringBuilder text = new StringBuilder(String.format(
				"OrderVO " + getOrderNo()
						+ " from %1$tm/%1$td/%1$tY %1$tH:%1$tM with delivery at  %2$tm/%2$td/%2$tY %2$tH:%2$tM\n",
				timestampStartedOrder, timestampDeliveredOrder));

		text.append("of customer: " + customer.getLastName() + " " + customer.getFirstName() + ", ID of customer: "
				+ customer.getId() + "\n");

		for (int i = 0; i < shoppingBasket.size(); i++) {
			if (shoppingBasket.get(i) != null) {
				text.append(shoppingBasket.get(i).toString());
				text.append("\n");
			}
		}

		return text.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}

		OrderVO other = (OrderVO) obj;
		if (orderNo != other.getOrderNo()) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hc = 0;
		final int hashMultiplier = 59;
		hc = hashMultiplier * orderNo;

		return hc;
	}

	// setter und getter

	// Setter und Getter
	/**
	 * @return the nextOrderNo
	 */
	public List<DishVO> getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(List<DishVO> warenkorb) {
		this.shoppingBasket = warenkorb;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	public void setTimestampStartedOrder(LocalDateTime order) {
		this.timestampStartedOrder = order;
	}

	public LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}

	public void setTimestampDeliveredOrder(LocalDateTime delivery) {
		this.timestampDeliveredOrder = delivery;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	/**
	 * @return the state
	 */
	public StateOfOrderVO getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(StateOfOrderVO state) {
		this.state = state;
	}

}
