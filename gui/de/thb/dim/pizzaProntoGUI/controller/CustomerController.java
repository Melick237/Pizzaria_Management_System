package de.thb.dim.pizzaProntoGUI.controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.Gender;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;
import de.thb.dim.pizzaProntoGUI.view.CustomerPanel;
import de.thb.dim.pizzaProntoGUI.view.ExceptionPanel;
import de.thb.dim.pizzaProntoGUI.view.MainView;

public class CustomerController {
	
	private MainView view;

	public CustomerController(MainView view) {
		
		setView(view);
		
		CustomerPanel customerPanel = view.getLayoutPanel().getCustomerPanel();
		
		JButton addButton = customerPanel.getAddButton();
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String lastName = customerPanel.getLastNameTextField().getText();
				String firstName = customerPanel.getFirstNameTextField().getText();
				Gender gender = (Gender) customerPanel.getGenderComboBox().getSelectedItem();
				String street = customerPanel.getStreetTextField().getText();
				
				int houseNumber = 0;
				
				try {
					houseNumber = Integer.parseInt(customerPanel.getHouseNoTextField().getText());
				} catch (NumberFormatException exception) {
					System.err.println("House number must be an integer." + exception.getMessage());
				}	
				
				
				int day = (int) customerPanel.getDayComboBox().getSelectedItem();
				int month = (int) customerPanel.getMonthComboBox().getSelectedItem();
				String yearAsString = customerPanel.getYearTextField().getText();
				int yearAsInt = 0;
				
				if(!yearAsString.equals(""))
					yearAsInt = Integer.parseInt(yearAsString);
				
				LocalDate dob = null;
				
				if(yearAsInt != 0)
					dob = LocalDate.of(yearAsInt, month, day);
				
				CustomerVO customer = null;
				
				try {
					customer = new CustomerVO(lastName, firstName, street, houseNumber, gender, dob);
				} catch (NullPointerException | CustomerTooYoungException ex) {
					new ExceptionPanel(ex);
				}
				
				int rowCnt = customerPanel.getTableModel().getRowCount();
				
				boolean isEqual = false;
				
				if(customer != null) {
					
					for(int i = 0; i < rowCnt; i++) {
						if (customer.equals(customerPanel.getTableModel().getValueAt(i, 0)))
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
									
									JLabel label = new JLabel("This person is already a customer.");
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
						
						row[0] = customer;
						row[1] = customer.getId();
						row[2] = customer.getFirstName();
						row[3] = customer.getLastName();
						row[4] = customer.getStreet();
						row[5] = customer.getHouseNumber();
						row[6] = customer.getGender();
						
						if(customer.getDateOfBirth() != null) {
							try {
								row[7] = customer.calculateAge();
							} catch (CustomerNoDateOfBirthException ex) {
								new ExceptionPanel(ex);
							}
						}
						
						row[8] = customer.hashCode();
							
						customerPanel.getTableModel().addRow(row);
						
						customerPanel.getFirstNameTextField().setText(null);
						customerPanel.getLastNameTextField().setText(null);
						customerPanel.getYearTextField().setText(null);
						customerPanel.getDayComboBox().setSelectedIndex(0);
						customerPanel.getMonthComboBox().setSelectedIndex(0);
						customerPanel.getGenderComboBox().setSelectedIndex(0);
						customerPanel.getStreetTextField().setText(null);
						customerPanel.getHouseNoTextField().setText(null);
					}
					
				}
				
				
				
			}
			
		});
		
		
		JButton removeButton = customerPanel.getRemoveButton();
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numRows = customerPanel.getTable().getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {

					customerPanel.getTableModel().removeRow(customerPanel.getTable().getSelectedRow());
				}
				
			}
			
		});
		
		JButton printButton = customerPanel.getPrintButton();
		printButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable(){
					
					@Override
					public void run(){
						JFrame frame = new JFrame("Print Details");
						
						int numRows = customerPanel.getTable().getSelectedRows().length;
						
						StringBuilder sb = new StringBuilder();
						
						int[] idx = customerPanel.getTable().getSelectedRows();
						
						for(int i=0; i<numRows ; i++ ) {

							String s = customerPanel.getTableModel().getValueAt(idx[i], 0).toString();
							sb.append(s);
							sb.append("\n");
						}
											
						JPanel innerPanel = new JPanel(new GridBagLayout());
						innerPanel.setOpaque(true);
						innerPanel.setBackground(Color.WHITE);
						innerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
						
						GridBagConstraints c0 = new GridBagConstraints();
						
						JLabel label = new JLabel("Printed Customers:");
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

		
	}
	
	public void setView(MainView view) {
		this.view = view;
	}

}
