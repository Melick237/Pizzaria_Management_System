package de.thb.dim.pizzaProntoGUI.controller;

// import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.DeliveryManVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaProntoGUI.view.MainView;
import de.thb.dim.pizzaProntoGUI.view.StaffPanel;

public class StaffController {
	
	private MainView view;

	public StaffController(MainView view) {
		
		setView(view);
		
		StaffPanel staffPanel = view.getLayoutPanel().getStaffPanel2();
		
		JTable staffTable = staffPanel.getTable();
		TableModel staffTableModel = staffTable.getModel();
		
		JButton addButton = staffPanel.getAddButton();
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
//				String colorString = (String) staffPanel.getColorComboBox().getSelectedItem();
				
//				Color color = convertStringToColor(colorString);
				
				String type = (String) staffPanel.getEmployeeTypeComboBox().getSelectedItem();
				
				EmployeeVO employee = null;
				
				if(type.equals("Chef")) {
					employee = new ChefVO(staffPanel.getPersonnelNoTextField().getText(),
							staffPanel.getLastNameTextField().getText(),
							staffPanel.getFirstNameTextField().getText());
				} else if(type.equals("Delivery Man")) {
					employee = new DeliveryManVO(staffPanel.getPersonnelNoTextField().getText(),
							staffPanel.getLastNameTextField().getText(),
							staffPanel.getFirstNameTextField().getText());
				}
				
				
				int rowCnt = staffPanel.getTableModel().getRowCount();
				
				boolean isEqual = false;
				
				for(int i = 0; i < rowCnt; i++) {
					if (employee.equals(staffPanel.getTableModel().getValueAt(i, 0)))
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
								
								JLabel label = new JLabel("This person is already an employee.");
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
				
					Object[] row = new Object[12];
					row[0] = employee;
					row[1] = type;
					row[2] = employee.getPersonnelNo();
					row[3] = employee.getFirstName();
					row[4] = employee.getLastName();				
//					color = chef.getColorApron();
//					row[2] = convertColorToString(color);
					
					if(type.equals("Chef"))
						row[9] = "n/a";
					if(type.equals("Delivery Man"))
						row[10] = "n/a";
					row[11] = employee.hashCode();
					
									
					staffPanel.getTableModel().addRow(row);
					
					staffPanel.getFirstNameTextField().setText(null);
					staffPanel.getLastNameTextField().setText(null);
					staffPanel.getPersonnelNoTextField().setText(null);
				}
				
			}
			
		});
		
		
		JButton removeButton = staffPanel.getRemoveButton();
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numRows = staffPanel.getTable().getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {

					staffPanel.getTableModel().removeRow(staffPanel.getTable().getSelectedRow());
				}
				
			}
			
		});
		
		JButton printButton = staffPanel.getPrintButton();
		printButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable(){
					
					@Override
					public void run(){
						JFrame frame = new JFrame("Print Details");
						
						int numRows = staffPanel.getTable().getSelectedRows().length;
						
						StringBuilder sb = new StringBuilder();
						
						int[] idx = staffPanel.getTable().getSelectedRows();
						
						for(int i=0; i<numRows ; i++ ) {

							String s = staffPanel.getTableModel().getValueAt(idx[i], 0).toString();
							sb.append(s);
							sb.append("\n");
						}
											
						JPanel innerPanel = new JPanel(new GridBagLayout());
						innerPanel.setOpaque(true);
						innerPanel.setBackground(Color.WHITE);
						innerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
						
						GridBagConstraints c0 = new GridBagConstraints();
						
						JLabel label = new JLabel("Printed Employees:");
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
		
		staffTableModel.addTableModelListener(new TableModelListener() {		

			@Override
			public void tableChanged(TableModelEvent e) {
				int index = staffTable.getSelectedRow();
				
				if(index != -1) {
										
					EmployeeVO employee = (EmployeeVO) staffTableModel.getValueAt(index, 0);
					
					String type = (String) staffTableModel.getValueAt(index, 1);
					
					employee.setPersonnelNo((String)staffTableModel.getValueAt(index, 2));
					employee.setFirstName((String)staffTableModel.getValueAt(index, 3));
					employee.setLastName((String)staffTableModel.getValueAt(index, 4));
					employee.setStreet((String)staffTableModel.getValueAt(index, 5));
					
					if(staffTableModel.getValueAt(index, 6)!= null)
						employee.setHouseNumber(Integer.parseInt((String)staffTableModel.getValueAt(index, 6)));
					
					if(staffTableModel.getValueAt(index, 7)!= null) {
						String salary = (String) staffTableModel.getValueAt(index, 7);
						salary = salary.replace(',', '.');						
						employee.setSalary(Float.parseFloat(salary));
					}
					
					if(staffTableModel.getValueAt(index, 8)!= null)
						employee.setVacationDays(Integer.parseInt((String) staffTableModel.getValueAt(index, 8)));
					
					if(type.equals("Delivery Man")) {
						DeliveryManVO dm = (DeliveryManVO) employee;
						dm.setDriverLicence((String)staffTableModel.getValueAt(index, 9));
					}
					
					if(type.equals("Chef")) {
						ChefVO c = (ChefVO) employee;
						
						Color color;
						
						try {
						    Field field = Class.forName("java.awt.Color").getField((String)staffTableModel.getValueAt(index, 10));
						    color = (Color)field.get(null);
						} catch (Exception e1) {
						    color = null; 
						}
						
						c.setColorApron(color);
					}
					
				}
									
			}

	    });
	
	}
	
	static Color convertStringToColor(String name) {
		
		Color color = null;
		
        switch(name){ 
        case "White": 
            color = Color.WHITE; 
            break; 
        case "Black": 
        	color = Color.BLACK; 
            break; 
        case "Red": 
        	color = Color.RED; 
        	break; 
        case "Green": 
        	color = Color.GREEN; 
            break; 
        case "Blue":
        	color = Color.BLUE;
        	break;
        case "Yellow":
        	color = Color.YELLOW;
        	break;
        case "Pink":
        	color = Color.PINK; 
        	break;
        }
        return color;
	}
	
	static String convertColorToString(Color color) {
		
		String name = null;
		
		if (color == Color.WHITE)
			name = "White";
		else if (color == Color.BLACK)
			name = "Black";
		else if (color == Color.RED)
			name = "Red";
		else if (color == Color.GREEN)
			name = "Green";
		else if (color == Color.BLUE)
			name = "Blue";
		else if (color == Color.YELLOW)
			name = "Yellow";
		else if (color == Color.PINK)
			name = "Pink";
		
        return name;
	}
	
	public void setView(MainView view) {
		this.view = view;
	}

}
