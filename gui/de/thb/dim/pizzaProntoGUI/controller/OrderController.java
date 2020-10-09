package de.thb.dim.pizzaProntoGUI.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import de.thb.dim.pizzaPronto.businessObjects.Ordering;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.businessObjects.io.OrderSerializer;
import de.thb.dim.pizzaPronto.businessObjects.io.exceptions.OrderSerializerNoInitException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaProntoGUI.view.CustomerPanel;
import de.thb.dim.pizzaProntoGUI.view.DefaultButton;
import de.thb.dim.pizzaProntoGUI.view.ExceptionPanel;
import de.thb.dim.pizzaProntoGUI.view.MainView;
import de.thb.dim.pizzaProntoGUI.view.MenuPanel;
import de.thb.dim.pizzaProntoGUI.view.OrderPanel;

public class OrderController {
	
	@SuppressWarnings("unused")
	private MainView view;
	
	private OrderPanel orderPanel;
	private CustomerPanel customerPanel;
	private MenuPanel menuPanel;
	
	private JTable orderMenuTable;
	private JTable shoppingBasketTable;
	private JTable orderTable;
	private JTable customerTable;
	private JTable menuTable;
	private DefaultTableModel orderMenuTableModel;
	private DefaultTableModel shoppingBasketTableModel;
	private DefaultTableModel orderTableModel;
	private DefaultTableModel customerTableModel;
	private DefaultTableModel menuTableModel;

	public OrderController(MainView view) {
		
		this.view = view;		
		orderPanel = view.getLayoutPanel().getOrderPanel();
		customerPanel = view.getLayoutPanel().getCustomerPanel();
		menuPanel = view.getLayoutPanel().getMenuPanel();		
		customerTable = customerPanel.getTable();
		menuTable = menuPanel.getTable();
		orderMenuTable = orderPanel.getMenuTable();
		shoppingBasketTable = orderPanel.getShoppingBasketTable();
		orderTable = orderPanel.getCurrentOrderstable();
		customerTableModel = (DefaultTableModel) customerTable.getModel();
		menuTableModel = (DefaultTableModel) menuTable.getModel();
//		orderMenuTableModel = (DefaultTableModel) orderMenuTable.getModel();
		shoppingBasketTableModel = (DefaultTableModel) shoppingBasketTable.getModel();
		orderTableModel = (DefaultTableModel) orderTable.getModel();
		
		ListSelectionModel tableSelection = orderTable.getSelectionModel();
		
		JButton startButton = orderPanel.getStartButton();
		JButton addDishButton = orderPanel.getAddDishButton();
		JButton removeButton = orderPanel.getRemoveButton();
		JButton printButton = orderPanel.getPrintButton();
		JButton confirmButton = orderPanel.getConfirmButton();
		JButton importButton = orderPanel.getImportOrdersButton();
		JButton exportButton = orderPanel.getExportOrdersButton();
		
		JComboBox sortComboBox = orderPanel.getSortComboBox();
		


		
		@SuppressWarnings("unchecked")
		JComboBox<Integer> comboBox = view.getLayoutPanel().getOrderPanel().getCustomerComboBox();
		
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				CustomerVO customer = null;
				
				if(comboBox.getSelectedIndex() != -1) {
					int selectedItem = (int)comboBox.getSelectedItem();
					
					boolean isFound = false;
					
					int i = 0;
					
					while(isFound == false){
						if(selectedItem == (int) customerTable.getValueAt(i, 0))
							isFound = true;
						i++;
					}
					if(isFound == true) {
						customer = (CustomerVO) customerTableModel.getValueAt(i-1, 0);
					}
				
				}
				
				
				Ordering ordering = new Ordering();
				
				try {
					ordering.startNewOrder(customer);
					
					Object[] row = new Object[2];

					row[0] = ordering;
					row[1] = ordering.getCurrentOrder().getOrderNo();

					orderTableModel.addRow(row);

					orderTable.setRowSelectionInterval(orderTable.getRowCount()-1, orderTable.getRowCount()-1);

					displayOrderDetails(ordering);	
					
				} catch (NullPointerException ex) {
					new ExceptionPanel(ex);
				}

							

				
			}
			
		});
		
		tableSelection.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
			
				int index = orderTable.getSelectedRow();
				
				Ordering ordering = (Ordering) orderTableModel.getValueAt(index, 0);
				
				displayOrderDetails(ordering);
				updateShoppingBasket(ordering);
				orderPanel.getServiceTextArea().setText(null);
			}
			
		});
		
		customerTableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int cnt = customerTable.getRowCount();				
				Vector<Integer> items = new Vector<Integer>();
				
				for(int i = 0; i < cnt; i++)
				{
					items.add((int) customerTable.getModel().getValueAt(i,1));
				}
				
				comboBox.setModel(new DefaultComboBoxModel<Integer>(items));				
			}
			
		});
		
//		menuTableModel.addTableModelListener(new TableModelListener() {
//
//			@Override
//			public void tableChanged(TableModelEvent e) {
//				int rowCount = menuTable.getRowCount();
//				
//				orderMenuTableModel.setRowCount(0);
//				
//				for(int i = 0;i < rowCount; i++) {
//						Object[] row = new Object[6];
//					
//						row[0] = menuTableModel.getValueAt(i, 0);
//						row[1] = menuTableModel.getValueAt(i, 0);
//						
//						orderMenuTableModel.addRow(row);											
//				}
//			}
//			
//		});
		
		
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ordering ordering = null;
				
				try {
					ordering = getSelectedOrder();
					
					ByteArrayOutputStream os = new ByteArrayOutputStream();					
					PrintStream ps = new PrintStream(os);
					
					PrintStream old = System.out;
					System.setOut(ps);

					try {
						ordering.confirmOrder();
					} catch (IllegalStateException | NoOrderException | NoCustomerException ex) {
						new ExceptionPanel(ex);
					}

					System.out.flush();
					System.setOut(old);

					orderPanel.getServiceTextArea().setText(os.toString());	
					
					updateShoppingBasket(ordering);
					displayOrderDetails(ordering);
					
				} catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
					System.err.print(e);
				} 
				
			}
			
		});
		

		
		
		
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ordering ordering = getSelectedOrder();
				
				if(ordering.getCurrentOrder() == null || ordering.getCurrentOrder().getState() != StateOfOrderVO.STARTED) {
					try {
						ordering.deleteDish(null);
					} catch (IllegalStateException | NoOrderException ex) {
						new ExceptionPanel(ex);
					}
				
				}

				int[] idx = shoppingBasketTable.getSelectedRows();
				
				for(int i=0; i<idx.length ; i++ ) {

					DishVO dish = (DishVO) shoppingBasketTableModel.getValueAt(idx[i], 1);
					
					try {
						ordering.deleteDish(dish);
					} catch (IllegalStateException | NoOrderException ex) {
						new ExceptionPanel(ex);
					}
					
					updateShoppingBasket(ordering);					
				}
				
				
			}
			
		});
		
		
		sortComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ordering ordering = getSelectedOrder();
				
				OrderVO order = ordering.getCurrentOrder();
				
				try {
					switch(sortComboBox.getSelectedIndex()) {
					case(1):
						order.setShoppingBasket(ordering.sortShoppingBasket());
						break;
					case(2):
						order.setShoppingBasket(ordering.sortShoppingBasketByNumber());
						break;
					case(3):
						order.setShoppingBasket(ordering.sortShoppingBasketByPrice());
						break;
					default:
						break;						
				}
				} catch (NoOrderException ex) {
					new ExceptionPanel(ex);
				}

				if(order != null)
					updateShoppingBasket(ordering);				
			}
			
		});
		
		addDishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ordering ordering = getSelectedOrder();
				
				if(ordering.getCurrentOrder() == null || ordering.getCurrentOrder().getState() != StateOfOrderVO.STARTED) {
					try {
						ordering.addDish(null);
					} catch (IllegalStateException | NoOrderException ex) {
						new ExceptionPanel(ex);
					}
				
				} else {

					EventQueue.invokeLater(new Runnable(){
						
						@Override
						public void run(){
							
							JFrame frame = new JFrame("Add Dish to Shopping Basket");						
							
							JPanel outerPanel = new JPanel(new GridBagLayout());
							outerPanel.setOpaque(true);
							outerPanel.setBackground(new Color(0xeaeaea));
							
							JPanel menuPanel = new JPanel();
							menuPanel.setBackground(Color.WHITE);
							menuPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

							GridBagConstraints c0 = new GridBagConstraints();
							c0.weightx = 1;
							c0.weighty = 1;
							c0.fill = GridBagConstraints.BOTH;
							c0.insets = new Insets(20, 20, 20, 20);
							outerPanel.add(menuPanel, c0);
							
							menuPanel.setLayout(new GridBagLayout());
								
							JLabel menuLabel = new JLabel("Menu");
							menuLabel.setFont(new Font("Arial", Font.PLAIN, 24));
							menuLabel.setForeground(Color.DARK_GRAY);
							GridBagConstraints c1 = new GridBagConstraints();
							c1.gridx = 0;
							c1.gridy = 0;
							c1.weightx = 1;
							c1.insets = new Insets(10, 12, 10, 10);
							c1.anchor = GridBagConstraints.FIRST_LINE_START;
							menuPanel.add(menuLabel, c1);
							
							JTable table = new JTable(menuTableModel);
							table.setDefaultEditor(Object.class, null);
							table.setFont(new Font("Arial", Font.PLAIN, 14));
							table.setRowHeight(30);
							table.setShowGrid(false);
							table.getTableHeader().setOpaque(false);
							table.getTableHeader().setBackground(new Color(240, 240, 240));
							table.setSelectionBackground(new Color(0x50c443));
								
							JScrollPane menuTableScrollPane = new JScrollPane(table);
							menuTableScrollPane.setBorder(BorderFactory.createEmptyBorder());
							menuTableScrollPane.getViewport().setBackground(Color.WHITE);
							GridBagConstraints c2 = new GridBagConstraints();
							c2.gridx = 0;
							c2.gridy = 1;
							c2.weightx = 1;
							c2.weighty = 1;
							c2.fill = GridBagConstraints.BOTH;
							c2.insets = new Insets(10, 10, 10, 10);
							menuPanel.add(menuTableScrollPane, c2);
							
							JButton addButton = new DefaultButton("Add Dish to Order");
							GridBagConstraints c3 = new GridBagConstraints();
							c3.gridx = 0;
							c3.gridy = 2;
							c3.anchor = GridBagConstraints.LAST_LINE_END;
							c3.insets = new Insets(10, 10, 10, 10);
							menuPanel.add(addButton, c3);
							
							frame.add(outerPanel);
							frame.setPreferredSize(new Dimension(858,480));
//							frame.setLocationRelativeTo(null);
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							frame.pack();
							frame.setVisible(true);
							
							addButton.addActionListener(new ActionListener() {
							
								@Override
									public void actionPerformed(ActionEvent e) {
									Ordering ordering = getSelectedOrder();
											
										int[] index = table.getSelectedRows();
										for(int i=0; i<index.length ; i++ ) {
											
											DishVO dish = (DishVO)menuTableModel.getDataVector().get(index[i]).get(0);
							
											try {
												ordering.addDish(dish);
											} catch (IllegalStateException | NoOrderException ex) {
												new ExceptionPanel(ex);
											}	
											updateShoppingBasket(ordering);
										}
													
										
									}
										
							});

							
						}
					
					});
				}
				
			}
			
		});
		
		printButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ordering ordering = getSelectedOrder();
				OrderVO order = ordering.getCurrentOrder();
				
				EventQueue.invokeLater(new Runnable(){
					
					@Override
					public void run(){
						JFrame frame = new JFrame("Print Order");
											
						JPanel innerPanel = new JPanel(new GridBagLayout());
						innerPanel.setOpaque(true);
						innerPanel.setBackground(Color.WHITE);
						innerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
						
						GridBagConstraints c0 = new GridBagConstraints();
						
						JLabel label = new JLabel("Invoice:");
						label.setFont(new Font("Arial", Font.PLAIN, 20));
						label.setForeground(new Color(0x606060));
						c0.gridx = 0;
						c0.gridy = 0;
						c0.insets = new Insets(20,20,10,20);
						innerPanel.add(label, c0);
						
						JTextArea details = new JTextArea();						
						details.setBackground(Color.WHITE);
						details.setEditable(false);						
						details.setText(order.toString());
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
		
		importButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("./");
			    
			    int returnVal = chooser.showOpenDialog(orderPanel);
			    
			    if(returnVal == JFileChooser.APPROVE_OPTION) {

					String fileName = null;
					
					try {
						fileName = chooser.getSelectedFile().getCanonicalPath();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    	
			    	OrderSerializer s = new OrderSerializer();
			    	
			    	try {
			    		s.initInput(fileName);
			    		
			    		try {
			    			while(true) {
				    			
				    			OrderVO order = s.deserializeOrder();
				    			
				    			Ordering ordering = new Ordering();
				    			CustomerVO customer = order.getCustomer();
				    			
				    			ordering.setCurrentCustomer(customer);
				    			ordering.setCurrentOrder(order);
				    			
				    			Object[] orderingRow = new Object[2];

								orderingRow[0] = ordering;
								orderingRow[1] = ordering.getCurrentOrder().getOrderNo();

								orderTableModel.addRow(orderingRow);
								
								boolean isEqual = false;
								
								for(int i = 0; i < customerTableModel.getRowCount() ; i++) {
									if (customer.equals(customerTableModel.getValueAt(i, 0)))
										isEqual = true;
								}
								
								if(!isEqual) {
									
									Object[] customerRow = new Object[9];							
									
									customerRow[0] = customer;
									customerRow[1] = customer.getId();
									customerRow[2] = customer.getFirstName();
									customerRow[3] = customer.getLastName();
									customerRow[4] = customer.getStreet();
									customerRow[5] = customer.getHouseNumber();
									customerRow[6] = customer.getGender();
									try {
										customerRow[7] = customer.calculateAge();
									} catch (CustomerNoDateOfBirthException e1) {
									}								
									customerRow[8] = customer.hashCode();
										
									customerTableModel.addRow(customerRow);
									
								}
				    			
				    		}
			    		} catch (EOFException ex) {
			    			
			    		}					
						
						s.closeInput();
						
					} catch (NullPointerException | IOException | ClassNotFoundException | OrderSerializerNoInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					
							    
				  
			    }			    
				
			}
			
		});
		
		exportButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("./");
			    
			    int returnVal = chooser.showSaveDialog(orderPanel);
			    
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	
			    	String fileName= null;
			    
					try {
						fileName = chooser.getSelectedFile().getCanonicalPath();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    	
			    	OrderSerializer s = new OrderSerializer();
			    	
			    	try {
			    		s.initOutput(fileName);
			    		
			    		for(int i = 0; i < orderTable.getRowCount(); i++) {
				    		Ordering ordering = (Ordering) orderTableModel.getDataVector().get(i).get(0);
				    		OrderVO order = ordering.getCurrentOrder();
				    		s.serializeOrder(order);
				    	}				
						
						s.closeOutput();
						
					} catch (NullPointerException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			    				    					  
			    }			    
				
			}
			
		});
		
		
		
		
	}
	
	private void updateShoppingBasket(Ordering ordering) {
		OrderVO order = ordering.getCurrentOrder();
		shoppingBasketTableModel.setRowCount(0);
		for(int i = 0; i < order.getNumberOfDishes(); i++) {
			Object[] row = new Object[2];
			row[1] = order.getShoppingBasket().get(i);
			
			shoppingBasketTableModel.addRow(row);
		}
		orderPanel.getItemCountLabel().setText(Integer.toString(order.getNumberOfDishes()));
		try {
			orderPanel.getTotalPriceLabel().setText(String.format("%.2f Euro", ordering.calculateTotalPrice()));
		} catch (NoOrderException ex) {
//			new ExceptionPanel(ex);
		}

	}
	
	private void displayOrderDetails(Ordering ordering) {
		
		OrderVO order = ordering.getCurrentOrder();
		CustomerVO customer = ordering.getCurrentCustomer();		
		
		orderPanel.getNumberLabelRight().setText(Integer.toString(order.getOrderNo()));
		orderPanel.getStartedLabelRight().setText(String.format("%1$tm/%1$td/%1$tY %1$tH:%1$tM", order.getTimestampStartedOrder()));
		orderPanel.getIdLabelRight().setText(Integer.toString(customer.getId()));
		orderPanel.getNameLabelRight().setText(customer.getFirstName() + " " + customer.getLastName());
		orderPanel.getGenderLabelRight().setText(customer.getGender().toString());
		orderPanel.getDateOfBirthRight().setText(customer.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
		orderPanel.getItemCountLabel().setText(Integer.toString(order.getNumberOfDishes()));
		orderPanel.getStreetLabelRight().setText(customer.getStreet() + " " + customer.getHouseNumber());
		orderPanel.getStateLabelRight().setText(order.getState().toString());

	}
	
	private Ordering getSelectedOrder() {
		Ordering ordering = null;
		
		int idx = orderTable.getSelectedRow();
		
		if(idx != -1)
			ordering = (Ordering) orderTableModel.getDataVector().get(idx).get(0);
		return ordering;
	}
	
	public void setView(MainView view) {
		this.view = view;
	}

}
