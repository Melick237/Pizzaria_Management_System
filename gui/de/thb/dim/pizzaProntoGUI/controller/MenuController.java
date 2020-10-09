package de.thb.dim.pizzaProntoGUI.controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.thb.dim.pizzaPronto.businessObjects.io.MenuImporter;
import de.thb.dim.pizzaPronto.valueObjects.DessertVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.PastaVO;
import de.thb.dim.pizzaPronto.valueObjects.PizzaVO;
import de.thb.dim.pizzaProntoGUI.view.MainView;
import de.thb.dim.pizzaProntoGUI.view.MenuPanel;

public class MenuController {
	
	private MainView view;
	private MenuPanel menuPanel;

	public MenuController(MainView view) {
		
	setView(view);
		
	menuPanel = view.getLayoutPanel().getMenuPanel();
	
	MenuVO menu = new MenuVO();
	
	loadMenu(menu);
		
		JButton addButton = menuPanel.getAddButton();
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int ingredientCount = menuPanel.getIngredientTableModel().getRowCount();
				int number = Integer.parseInt(menuPanel.getNumberTextField().getText());
				int typeOfPasta = (int) menuPanel.getTypeComboBox().getSelectedItem();
				int size = (int) menuPanel.getSizeComboBox().getSelectedItem();
				float priceAsFloat = 0.0F;
				String name = menuPanel.getNameTextField().getText();
				String[] ingredients = new String [ingredientCount];				
				String priceAsString = menuPanel.getPriceTextField().getText().replace(',', '.');
				String typeOfDish = (String) menuPanel.getDishComboBox().getSelectedItem();
				

				
				if (!priceAsString.equals("")) {
					try {
						priceAsFloat = Float.parseFloat(priceAsString);
					} catch (NumberFormatException exception) {
						System.err.println("Input error by price: " + exception.getMessage() );
					}
				}
					
				for(int i = 0; i < ingredientCount; i++) {
					ingredients[i] = (String) menuPanel.getIngredientTableModel().getValueAt(i, 0);
				}
				
				DishVO dish = null;
				
				if(typeOfDish.equals("Pasta"))
					dish = new PastaVO(number, name, ingredients, priceAsFloat, typeOfPasta);
				else if(typeOfDish.equals("Pizza"))
					dish = new PizzaVO(number, name, ingredients, priceAsFloat, size);
				else if(typeOfDish.equals("Dessert"))
					dish = new DessertVO(number, name, priceAsFloat);
				
				int rowCnt = menuPanel.getTableModel().getRowCount();
				
				boolean isEqual = false;
				
				for(int i = 0; i < rowCnt; i++) {
					if (dish.equals(menuPanel.getTableModel().getValueAt(i, 5)))
						isEqual = true;
				}
				
				if(isEqual == true) {
						EventQueue.invokeLater(new Runnable(){
							
							@Override
							public void run(){
								JFrame frame = new JFrame("Note");
													
								JPanel innerPanel = new JPanel(new GridBagLayout());
								innerPanel.setOpaque(true);
								innerPanel.setBackground(Color.WHITE);
								innerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
								
								GridBagConstraints c0 = new GridBagConstraints();
								
								JLabel label = new JLabel("This dish is already on the menu.");
								label.setFont(new Font("Arial", Font.PLAIN, 18));
								label.setForeground(new Color(0x606060));

								c0.insets = new Insets(20,20,20,20);
								innerPanel.add(label, c0);
								
								JPanel outerPanel = new JPanel(new GridBagLayout());
								outerPanel.setOpaque(true);
								outerPanel.setBackground(new Color(0xeaeaea));
								
								GridBagConstraints c1 = new GridBagConstraints();
								c1.insets = new Insets(20,20,20,20);
								outerPanel.add(innerPanel,c1);
								
								frame.add(outerPanel);
								
								frame.setLocationRelativeTo(null);
								frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								frame.pack();
								frame.setVisible(true);
							}
							
						});
					
				} else {
					Object[] row = new Object[9];
					
					row[0] = dish;
					row[1] = dish.getNumberOfDish();
					row[2] = dish.getClass().getSimpleName();
					row[3] = dish.getName();
					if(dish instanceof PizzaVO || dish instanceof PastaVO)
						row[4] = Arrays.toString(dish.getIngredients());
					if(dish instanceof PizzaVO)
						row[5] = ((PizzaVO) dish).getSize();
					if(dish instanceof PastaVO)
						row[6] = ((PastaVO) dish).getTypeOfPasta();
					row[7] = dish.getPrice();
					row[8] = dish.hashCode();

					
					menuPanel.getTableModel().addRow(row);
					
					menuPanel.getPriceTextField().setText(null);
					menuPanel.getNameTextField().setText(null);
					menuPanel.getIngredientTableModel().setRowCount(0);					
				}
				
			}
			
		});
		
		
		JButton removeButton = menuPanel.getRemoveButton();
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numRows = menuPanel.getTable().getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {

					menuPanel.getTableModel().removeRow(menuPanel.getTable().getSelectedRow());
				}
				
			}
			
		});
		
		JButton addIngredientButton = menuPanel.getAddIngredientButton();
		addIngredientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
				Object[] row = new Object[1];
				
				row[0] = menuPanel.getIngredientTextField().getText();
				
				menuPanel.getIngredientTableModel().addRow(row);
				
				menuPanel.getIngredientTextField().setText(null);
				
			}
			
		});
		
		JButton removeIngredientButton = menuPanel.getRemoveIngredientButton();
		removeIngredientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numRows = menuPanel.getIngredientsTable().getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {

					menuPanel.getIngredientTableModel().removeRow(menuPanel.getIngredientsTable().getSelectedRow());
				}
				
			}
			
		});
		
		JButton printButton = menuPanel.getPrintButton();
		printButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable(){
					
					@Override
					public void run(){
						JFrame frame = new JFrame("Print Details");
						
						int numRows = menuPanel.getTable().getSelectedRows().length;
						
						StringBuilder sb = new StringBuilder();
						
						int[] idx = menuPanel.getTable().getSelectedRows();
						
						for(int i=0; i<numRows ; i++ ) {

							String s = menuPanel.getTableModel().getValueAt(idx[i], 0).toString();
							sb.append(s);
							sb.append("\n");
						}
											
						JPanel innerPanel = new JPanel(new GridBagLayout());
						innerPanel.setOpaque(true);
						innerPanel.setBackground(Color.WHITE);
						innerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
						
						GridBagConstraints c0 = new GridBagConstraints();
						
						JLabel label = new JLabel("Printed Dishes:");
						label.setFont(new Font("Arial", Font.PLAIN, 20));
						label.setForeground(new Color(0x606060));
						c0.gridx = 0;
						c0.gridy = 0;
						c0.insets = new Insets(20,20,10,20);
						innerPanel.add(label, c0);
						
						JTextArea details = new JTextArea();						
						details.setBackground(Color.WHITE);
						details.setEditable(false);						
						details.setText(sb.toString());
						c0.gridx = 0;
						c0.gridy = 1;
						c0.insets = new Insets(10,20,20,20);
						innerPanel.add(details, c0);
						
						JPanel outerPanel = new JPanel(new GridBagLayout());
						outerPanel.setOpaque(true);
						outerPanel.setBackground(new Color(0xeaeaea));
						
						GridBagConstraints c1 = new GridBagConstraints();
						c1.insets = new Insets(20,20,20,20);
						outerPanel.add(innerPanel,c1);
						
						frame.add(outerPanel);
						
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.pack();
						frame.setVisible(true);
					}
					
				});
				
			}
		});
		
//		JButton copyButton = menuPanel.getCopyButton();
//		copyButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int numRows = menuPanel.getTable().getSelectedRows().length;
//				for(int i=0; i<numRows ; i++ ) {
//
//					int[] idx = menuPanel.getTable().getSelectedRows();
//					
//					DishVO org = (DishVO) menuPanel.getTableModel().getValueAt(idx[i], 5);
//					DishVO cpy = (DishVO) org.clone();
//					
//					Object[] row = new Object[6];
//					
//					row[0] = "Pizza";
//					row[1] = cpy.getName();
//					row[2] = Arrays.toString(cpy.getIngredients());
//					row[3] = cpy.getPrice();
//					row[4] = cpy.hashCode();
//					row[5] = cpy;
//					
//					menuPanel.getTableModel().addRow(row);
//				}
//				
//			}
//			
//		});
		
		JComboBox<String> dishComboBox = menuPanel.getDishComboBox();
		dishComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String typeOfDish = (String) menuPanel.getDishComboBox().getSelectedItem();
				
				if(typeOfDish.equals("Pasta")) {
					menuPanel.getTypeComboBox().setEnabled(true);
					menuPanel.getSizeComboBox().setEnabled(false);
					menuPanel.getIngredientTextField().setEnabled(true);
					menuPanel.getIngredientsTable().setEnabled(true);
					menuPanel.getAddIngredientButton().setVisible(true);
					menuPanel.getRemoveIngredientButton().setVisible(true);

					
				} else if(typeOfDish.equals("Pizza")) {
					menuPanel.getSizeComboBox().setEnabled(true);
					menuPanel.getTypeComboBox().setEnabled(false);
					menuPanel.getIngredientTextField().setEnabled(true);
					menuPanel.getIngredientsTable().setEnabled(true);
					menuPanel.getAddIngredientButton().setEnabled(true);
					menuPanel.getRemoveIngredientButton().setEnabled(true);

					
				} else if(typeOfDish.equals("Dessert")) {
					menuPanel.getSizeComboBox().setEnabled(false);
					menuPanel.getTypeComboBox().setEnabled(false);
					menuPanel.getIngredientTextField().setEnabled(false);
					menuPanel.getIngredientsTable().setEnabled(false);
					menuPanel.getAddIngredientButton().setEnabled(false);
					menuPanel.getRemoveIngredientButton().setEnabled(false);
					
				}
					
				
			}
			
		});
		
		JButton importButton = menuPanel.getLoadButton();
		importButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("./");
				
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("Menu File", "txt");
			    
			    chooser.setFileFilter(filter);
			    
			    int returnVal = chooser.showOpenDialog(menuPanel);
			    
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       
			    	String fileName = null;
			    	
					try {
						fileName = chooser.getSelectedFile().getCanonicalPath();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    	MenuImporter mi = new MenuImporter();
				    
				    try {
						MenuVO menu = mi.readMenu(fileName);						
						loadMenu(menu);
					} catch (IOException ex) {
						System.err.println(ex.getMessage());
					}
			    }			    
				
			}
			
		});
		
		
	}
	
	private void loadMenu(MenuVO menu) {
		
		menuPanel.getTableModel().setRowCount(0);
		
		int length = menu.getNumberOfDishes();
		
		for(int i = 0; i < length; i++) {
			
			DishVO dish = menu.getDish(i);
			
			Object[] row = new Object[9];
			
			row[0] = dish;
			row[1] = dish.getNumberOfDish();
			row[2] = dish.getClass().getSimpleName();
			row[3] = dish.getName();
			if(dish instanceof PizzaVO || dish instanceof PastaVO)
				row[4] = Arrays.toString(dish.getIngredients());
			if(dish instanceof PizzaVO)
				row[5] = ((PizzaVO) dish).getSize();
			if(dish instanceof PastaVO)
				row[6] = ((PastaVO) dish).getTypeOfPasta();
			row[7] = dish.getPrice();
			row[8] = dish.hashCode();

			
			menuPanel.getTableModel().addRow(row);
		}
	}
	
	public void setView(MainView view) {
		this.view = view;
	}

}
