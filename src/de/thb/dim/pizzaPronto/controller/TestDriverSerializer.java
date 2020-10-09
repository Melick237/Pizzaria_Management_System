package de.thb.dim.pizzaPronto.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.io.OrderSerializer;
import de.thb.dim.pizzaPronto.businessObjects.io.exceptions.OrderSerializerNoInitException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.Gender;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;


class TestDriverSerializer {

	public static void main(String[] args) throws IOException, OrderSerializerNoInitException {

		final int COUNTER = 1;
		MenuVO menu;
		List<CustomerVO> customers= new ArrayList<CustomerVO>();
		List<OrderVO> orders= new ArrayList<OrderVO>();
		List<OrderVO> orderDeserialized= new ArrayList<OrderVO>();
		Random random = new Random();
		String file = "Order.ser";
		OrderSerializer orderSerializer = new OrderSerializer();



		menu = new MenuVO();

 		for (int i = 0; i < COUNTER; i++) {
			try {
				customers.add(new CustomerVO("Mustermann_" + (i + 1), "Max",
						"Stra�e_" + (i + 1), (i + 1), Gender.M,
						LocalDate.of(1990, 1, (i + 1))));
			} catch ( NullPointerException e) {

				System.err.println(e.getMessage());
			} catch (CustomerTooYoungException e) {
				System.err.println(e.getMessage());
			}
		}

		// random order from menu
		for (int i = 0; i < COUNTER; i++) {
			orders.add(new OrderVO(1,StateOfOrderVO.STARTED,LocalDateTime.now(), customers.get(i)));
			for (int j = 0; j < 3; j++) {
				orders.get(i).addDish(menu
						.getDish(random.nextInt(18)));
			}
			customers.get(i).setOrder(orders.get(i));
		}

		// output customer an order
		// Polymorphism
		
		try {
			orderSerializer.initOutput(file);
		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
			e1.printStackTrace();
		}


		for (CustomerVO k : customers) {
			System.out.println();
			System.out.println(k.toString());
			if (k.hasOrder()) {
				System.out.println(k.getOrder().toString());
			}
		}
		for (OrderVO bestell : orders) {
			orderSerializer.serializeOrder(bestell);
		}
		
		

		orderSerializer.closeOutput();
		
		//Input from file
		
		try {
			orderSerializer.initInput(file);;
		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
			e1.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("=======================================================");
		for (int i = 0; i < orders.size(); i++) {
			try {
				orderDeserialized.add(orderSerializer.deserializeOrder());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OrderSerializerNoInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
					.println(orderDeserialized.get(i).getCustomer().toString());
			System.out.println(orderDeserialized.get(i));
		}
		System.out.println(orders.equals(orderDeserialized));
		orderSerializer.closeInput();

	}
}
