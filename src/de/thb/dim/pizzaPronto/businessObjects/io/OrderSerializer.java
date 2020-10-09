package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.thb.dim.pizzaPronto.businessObjects.io.exceptions.OrderSerializerNoInitException;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public class OrderSerializer {

	private ObjectOutputStream os;
	private ObjectInputStream is;

	public OrderSerializer() {
		os = null;
		is = null;
	}

	public void initOutput(String file) throws  NullPointerException, IOException {

		os = new ObjectOutputStream(new FileOutputStream(file));
	}

	public void initInput(String file) throws  NullPointerException, IOException {

		is = new ObjectInputStream(new FileInputStream(file));
	}

	public void serializeOrder(OrderVO order) throws IOException, OrderSerializerNoInitException {
		if(os == null) {
			throw new OrderSerializerNoInitException("Output was not initialized.");
		}
		os.writeObject(order);
	}

	public void closeOutput() throws  IOException, OrderSerializerNoInitException {
		if(os == null) {
			throw new OrderSerializerNoInitException("Output was not initialized.");
		}
		os.close();
		
	}

	public OrderVO deserializeOrder() throws ClassNotFoundException, IOException, OrderSerializerNoInitException {
		OrderVO order = null;
		if(is == null) {
			throw new OrderSerializerNoInitException("Input was not initialized.");
		}

		order = (OrderVO) is.readObject();
		return order;
	}

	public void closeInput() throws   IOException, OrderSerializerNoInitException {
		if(is == null) {
			throw new OrderSerializerNoInitException("Input was not initialized.");
		}
			is.close();
		
	}
}
