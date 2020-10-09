package de.thb.dim.pizzaProntoGUI;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.thb.dim.pizzaProntoGUI.controller.CustomerController;
import de.thb.dim.pizzaProntoGUI.controller.MenuController;
import de.thb.dim.pizzaProntoGUI.controller.OrderController;
import de.thb.dim.pizzaProntoGUI.controller.StaffController;
import de.thb.dim.pizzaProntoGUI.view.MainView;

public class GUI_Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@SuppressWarnings("unused")
			public  void run() {
				
				try {
					UIManager.setLookAndFeel(
							UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				MainView view = new MainView();
				
				StaffController staffController = new StaffController(view);
				CustomerController customerController = new CustomerController(view);
				OrderController orderController = new OrderController(view);
				MenuController menuController = new MenuController(view);
			}
		});

	}

}
