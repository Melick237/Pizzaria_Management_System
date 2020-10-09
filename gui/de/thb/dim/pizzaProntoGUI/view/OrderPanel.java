package de.thb.dim.pizzaProntoGUI.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel{
	
	private JPanel headerPanel;
	private JPanel newOrderPanel;
	private JPanel hintPanel;
	private JPanel currentOrdersPanel;
	private JPanel editOrderPanel;
	private JPanel menuPanel;
	private JPanel shoppingBasketPanel;
	private JPanel statusPanel;
	private JPanel servicePanel;
	
	private JLabel headerLabelSmall;
	private JLabel headerLabelLarge;
	private JLabel hintLabel;
	private JLabel numberLabelLeft;
	private JLabel selectLabel;
	private JLabel currentOrdersLabel;
	private JLabel editOrdersLabel;
	private JLabel numberLabelRight;
	private JLabel idLabelLeft;
	private JLabel idLabelRight;
	private JLabel nameLabelLeft;
	private JLabel nameLabelRight;
	private JLabel genderLabelLeft;
	private JLabel genderLabelRight;
	private JLabel dateOfBirthLeft;
	private JLabel dateOfBirthRight;
	private JLabel startedLabelLeft;
	private JLabel startedLabelRight;
	private JLabel menuLabel;
	private JLabel itemCountLabel;
	private JLabel streetLabelLeft;
	private JLabel streetLabelRight;	
	private JLabel totalPriceLabel;
	private JLabel stateLabelLeft;
	private JLabel stateLabelRight;
	private JLabel statusLabel;
	private JLabel serviceLabel;
	private JLabel sortLabel;
	
	private JComboBox<Integer> customerComboBox;
	private JComboBox<String> sortComboBox;
	
	private JTable currentOrderstable;
	private JTable menuTable;
	private JTable shoppingBasketTable;
	
	private DefaultTableModel tableModel;
	private DefaultTableModel menuTableModel;
	
	private JScrollPane tableScrollPane;
	private JScrollPane menuTableScrollPane;
	
	private DefaultButton startButton;
	private DefaultButton addButton;
	private DefaultButton removeButton;
	private DefaultButton printButton;
	private DefaultButton addDishButton;
	private DefaultButton confirmButton;
	private DefaultButton importOrdersButton;
	private DefaultButton exportOrdersButton;
	
	private JTextArea serviceTextArea;

	public OrderPanel() {

		setOpaque(true);
		setBackground(new Color(0xeaeaea));
		setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/border.png")));

		setLayout(new GridBagLayout());
		
		headerPanel = new JPanel(new GridBagLayout());
		headerPanel.setBackground(new Color(0xeaeaea));
		addComponentsToHeaderPanel(headerPanel);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.gridwidth = 3;
		c0.gridheight = 1;
		c0.insets = new Insets(15, 30, 0, 10);
		c0.fill = GridBagConstraints.BOTH;
		add(headerPanel, c0);
		
		newOrderPanel = new JPanel();
		newOrderPanel.setBackground(Color.WHITE);
		newOrderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToNewOrderPanel(newOrderPanel);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0;
		c1.weighty = 0;
		c1.fill = GridBagConstraints.BOTH;
		c1.insets = new Insets(0, 30, 10, 10);
		add(newOrderPanel, c1);
		
		currentOrdersPanel = new JPanel();
		currentOrdersPanel.setBackground(Color.WHITE);
		currentOrdersPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToCurrentOrdersPanel(currentOrdersPanel);
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 2;
		c3.gridwidth = 1;
		c3.gridheight = 2;
		c3.weightx = 0;
		c3.weighty = 1;
		c3.fill = GridBagConstraints.BOTH;
		c3.insets = new Insets(0, 30, 10, 10);
		add(currentOrdersPanel, c3);
		
		editOrderPanel = new JPanel();
		editOrderPanel.setBackground(Color.WHITE);
		editOrderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		editOrderPanel.setPreferredSize(new Dimension(350,0));
		editOrderPanel.setMaximumSize(new Dimension(350,0));
		editOrderPanel.setMinimumSize(new Dimension(350,0));
		addComponentsToDetailsPanel(editOrderPanel);
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
		c4.gridy = 1;
		c4.gridwidth = 1;
		c4.gridheight = 2;
		c4.weightx = 0;
		c4.weighty = 1;
		c4.fill = GridBagConstraints.BOTH;
		c4.insets = new Insets(0, 0, 10, 10);
		add(editOrderPanel, c4);
		
		shoppingBasketPanel = new JPanel();
		shoppingBasketPanel.setBackground(Color.WHITE);
		shoppingBasketPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToShoppingBasketPanel(shoppingBasketPanel);
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 2;
		c5.gridy = 1;
		c5.gridwidth = 1;
		c5.gridheight = 3;
		c5.weightx = 1;
		c5.weighty = 1;
		c5.fill = GridBagConstraints.BOTH;
		c5.insets = new Insets(0, 0, 10, 10);
		add(shoppingBasketPanel, c5);
		
		servicePanel = new JPanel();
		servicePanel.setBackground(Color.WHITE);
		servicePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToServicePanel(servicePanel);
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1;
		c6.gridy = 3;
		c6.gridwidth = 1;
		c6.gridheight = 1;
		c6.weightx = 1;
		c6.weighty = 1;
		c6.fill = GridBagConstraints.BOTH;
		c6.insets = new Insets(0, 0, 10, 10);
		add(servicePanel, c6);
		
		hintPanel = new JPanel();
		hintPanel.setBackground(Color.WHITE);
		hintPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToHintPanel(hintPanel);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 4;
		c2.gridheight = 1;
		c2.gridwidth = 3;
		c2.weightx = 1;
		c2.weighty = 0;
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.insets = new Insets(0, 30, 10, 10);
		add(hintPanel, c2);
	}
	
	private void addComponentsToHeaderPanel(JPanel headerPanel) {
		GridBagConstraints c = new GridBagConstraints();
		
		headerLabelSmall = new JLabel("Pizza Pronto");
		headerLabelSmall.setFont(new Font("Helvetica", Font.PLAIN, 20));
		headerLabelSmall.setForeground(new Color(0x505050));
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 1;
		headerPanel.add(headerLabelSmall, c);
		
		headerLabelLarge = new JLabel("Orders");
		headerLabelLarge.setFont(new Font("Helvetica", Font.PLAIN, 30));
		headerLabelLarge.setForeground(new Color(0x606060));
		c.gridx = 0;
		c.gridy = 1;
		headerPanel.add(headerLabelLarge, c);
		
		importOrdersButton = new DefaultButton("Import Orders");
		importOrdersButton.setForeground(new Color(0xEEEEEE));
		importOrdersButton.setBackground(new Color(0x999999));
		importOrdersButton.setIcon(new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/import_24px.png"));
		importOrdersButton.setIconTextGap(8);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0,0,10,0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		headerPanel.add(importOrdersButton, c);
		
		exportOrdersButton = new DefaultButton("Export Orders");
		exportOrdersButton.setForeground(new Color(0xEEEEEE));
		exportOrdersButton.setBackground(new Color(0x999999));
		exportOrdersButton.setIcon(new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/export_24px.png"));
		exportOrdersButton.setIconTextGap(8);
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0;
		c.insets = new Insets(0,10,10,0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		headerPanel.add(exportOrdersButton, c);
	}
	
	private void addComponentsToHintPanel(JPanel hintPanel) {
		hintPanel.setLayout(new GridBagLayout());
		hintLabel = new JLabel("<html><p><strong><span style=\"font-size: 10px;\">Hinweis</span></strong></p>\n" + 
				"<p><span style=\"font-size: 10px;\">Ueber die Export/Import Buttons koennen Bestellungen serialisiert bzw. deserialisiert werden. " +
				"Beim Exportieren werden automatisch alle Bestellungen serialisiert. Beim Importieren werden auch die Kunden in die Kundentabelle uebernommen.</span></p></html>");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.insets = new Insets(10, 10, 10, 10);
		hintPanel.add(hintLabel, c);
	}
	
	private void addComponentsToNewOrderPanel(JPanel addPanel) {
		addPanel.setLayout(new GridBagLayout());
		
		JPanel newPanel = new JPanel(new GridBagLayout());
		newPanel.setBackground(Color.WHITE);
		addPanel.add(newPanel);
		
		numberLabelLeft = new JLabel("Place an Order");
		numberLabelLeft.setFont(new Font("Arial", Font.PLAIN, 24));
		numberLabelLeft.setForeground(Color.DARK_GRAY);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.gridwidth = 2;
		c0.weightx = 0;
		c0.insets = new Insets(10, 12, 0, 10);
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
		newPanel.add(numberLabelLeft, c0);
		
		selectLabel = new JLabel("Select Customer ID:");
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.insets = new Insets(15, 12, 10, 5);
		newPanel.add(selectLabel, c1);
		
		customerComboBox = new JComboBox<>();
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 1;
		c2.gridy = 1;
		c2.insets = new Insets(15, 0, 10, 10);
		newPanel.add(customerComboBox, c2);
		
		startButton = new DefaultButton("New Order");
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 2;
		c3.gridwidth = 2;
		c3.anchor = GridBagConstraints.LAST_LINE_END;
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.insets = new Insets(0, 12, 10, 10);
		newPanel.add(startButton, c3);
				
	}

	private void addComponentsToShoppingBasketPanel(JPanel shoppingBasketPanel) {
		shoppingBasketPanel.setLayout(new GridBagLayout());
		
		JLabel shoppingBasketLabel = new JLabel("Shopping Basket");
		shoppingBasketLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		shoppingBasketLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.weightx = 1;
		c0.fill = GridBagConstraints.HORIZONTAL;
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
		c0.insets = new Insets(10, 12, 10, 10);
		shoppingBasketPanel.add(shoppingBasketLabel, c0);
		
		JLabel itemLabel = new JLabel("Items: ");
//		itemLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//		itemLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 0;
//		c3.weightx = 1;
//		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.anchor = GridBagConstraints.LAST_LINE_END;
		c3.insets = new Insets(10, 12, 10, 10);
		shoppingBasketPanel.add(itemLabel, c3);
		
		itemCountLabel = new JLabel("0");
//		itemCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//		itemCountLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c4 = new GridBagConstraints();
//		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.anchor = GridBagConstraints.LAST_LINE_END;
		c4.gridx = 2;
		c4.gridy = 0;
		c4.insets = new Insets(10, 12, 10, 10);
		shoppingBasketPanel.add(itemCountLabel, c4);
		
		JLabel priceLabel = new JLabel("Total Price: ");
//		priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//		priceLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 3;
		c12.gridy = 0;
//		c3.weightx = 1;
	//	c12.fill = GridBagConstraints.HORIZONTAL;
		c12.gridwidth = 1;
		c12.anchor = GridBagConstraints.LAST_LINE_END;
		c12.insets = new Insets(10, 12, 10, 0);
		shoppingBasketPanel.add(priceLabel, c12);
		
		totalPriceLabel = new JLabel("0,00 Euro");
//		totalPriceLabel.setMinimumSize(new Dimension(50,0));
//		totalPriceLabel.setMaximumSize(new Dimension(50,0));
//		totalPriceLabel.setPreferredSize(new Dimension(50,0));
//		totalPriceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//		totalPriceLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c13 = new GridBagConstraints();
	//	c13.fill = GridBagConstraints.HORIZONTAL;
		c13.anchor = GridBagConstraints.LAST_LINE_END;
		c13.gridx = 4;
		c13.gridy = 0;
		c13.gridwidth = 2;
		c13.insets = new Insets(10, 12, 10, 10);
		shoppingBasketPanel.add(totalPriceLabel, c13);
		
		sortLabel = new JLabel("sort by:");
		GridBagConstraints c8  = new GridBagConstraints();
		c8.gridx = 1;
		c8.gridy = 1;
		c8.gridwidth = 4;
		c8.anchor = GridBagConstraints.LAST_LINE_END;
		c8.insets = new Insets(0, 0, 7, 0);
		shoppingBasketPanel.add(sortLabel, c8);
		
		String[] sorts = {"none", "name", "number", "price"};
		sortComboBox = new JComboBox<>(sorts);
//		sortComboBox.setSelectedItem("sort");
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 5;
		c7.gridy = 1;
		c7.gridwidth = 1;
//		c7.weightx = 1;
//		c7.fill = GridBagConstraints.HORIZONTAL;
		c7.anchor = GridBagConstraints.LAST_LINE_END;
		c7.fill = GridBagConstraints.HORIZONTAL;
		c7.insets = new Insets(10, 5, 0, 5);
		shoppingBasketPanel.add(sortComboBox, c7);


		
		shoppingBasketTable = new JTable();
		DefaultTableModel shoppingBasketTableModel = new DefaultTableModel();
		String[] columns = {"Object", "Name"};
		shoppingBasketTableModel = new DefaultTableModel();
		shoppingBasketTableModel.setColumnIdentifiers(columns);
		shoppingBasketTable = new JTable(shoppingBasketTableModel);
	//	shoppingBasketTable.setRowSelectionAllowed(false);
		shoppingBasketTable.setFocusable(false);
		TableColumnModel tcm2 = shoppingBasketTable.getColumnModel();
		tcm2.removeColumn(tcm2.getColumn(0));
		shoppingBasketTable.setFont(new Font("Arial", Font.PLAIN, 14));
		shoppingBasketTable.setRowHeight(30);
		shoppingBasketTable.setShowGrid(false);
		shoppingBasketTable.setSelectionBackground(new Color(0x50c443));
		shoppingBasketTable.setDefaultEditor(Object.class, null);
		shoppingBasketTable.getTableHeader().setOpaque(false);
		shoppingBasketTable.getTableHeader().setBackground(new Color(240, 240, 240));	

		JScrollPane shoppingBasketScrollPane = new JScrollPane();
		shoppingBasketScrollPane = new JScrollPane(shoppingBasketTable);
		shoppingBasketScrollPane.setBorder(BorderFactory.createEmptyBorder());
		shoppingBasketScrollPane.getViewport().setBackground(Color.WHITE);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.weightx = 1;
		c2.weighty = 1;
		c2.gridwidth = 6;
		c2.fill = GridBagConstraints.BOTH;
		c2.insets = new Insets(10, 10, 10, 10);
		shoppingBasketPanel.add(shoppingBasketScrollPane, c2);
		
		addDishButton = new DefaultButton("Add Dish");
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 2;
		c5.gridy = 3;
		c5.gridwidth = 2;
		c5.anchor = GridBagConstraints.LAST_LINE_END;
		c5.insets = new Insets(10, 10, 10, 10);
		shoppingBasketPanel.add(addDishButton, c5);
		
		removeButton = new DefaultButton("Remove Dish");
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 4;
		c6.gridy = 3;
		c6.gridwidth = 2;
		c6.anchor = GridBagConstraints.LAST_LINE_END;
		c6.insets = new Insets(10, 0, 10, 10);
		shoppingBasketPanel.add(removeButton, c6);
		
	}

	private void addComponentsToDetailsPanel(JPanel detailsPanel) {
		
		detailsPanel.setLayout(new GridBagLayout());
		
		numberLabelLeft = new JLabel("Order No. ");
		numberLabelLeft.setFont(new Font("Arial", Font.PLAIN, 24));
		numberLabelLeft.setForeground(Color.DARK_GRAY);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
//		c0.weightx = 1;
		c0.insets = new Insets(10, 12, 0, 0);
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
//		c0.fill = GridBagConstraints.HORIZONTAL;
		detailsPanel.add(numberLabelLeft, c0);
		
		numberLabelRight = new JLabel();
		numberLabelRight.setFont(new Font("Arial", Font.PLAIN, 24));
		numberLabelRight.setForeground(Color.DARK_GRAY);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.weightx = 1;
		c1.insets = new Insets(10, 0, 0, 10);
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(numberLabelRight, c1);
		
		stateLabelLeft = new JLabel("Status: ");
		GridBagConstraints c14 = new GridBagConstraints();
		c14.gridx = 0;
		c14.gridy = 1;
		c14.insets = new Insets(10, 12, 0, 10);
		c14.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(stateLabelLeft, c14);
		
		stateLabelRight = new JLabel();
		GridBagConstraints c15 = new GridBagConstraints();
		c15.gridx = 1;
		c15.gridy = 1;
		c15.insets = new Insets(10, 0, 0, 10);
		c15.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(stateLabelRight, c15);
		
		startedLabelLeft = new JLabel("Date: ");
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 0;
		c10.gridy = 2;
		c10.insets = new Insets(10, 12, 0, 10);
		c10.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(startedLabelLeft, c10);
		
		startedLabelRight = new JLabel();
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 1;
		c11.gridy = 2;
		c11.insets = new Insets(10, 0, 0, 10);
		c11.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(startedLabelRight, c11);
		
		idLabelLeft = new JLabel("Customer ID: ");
//		idLabelLeft.setFont(new Font("Arial", Font.PLAIN, 24));
//		idLabelLeft.setForeground(Color.DARK_GRAY);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 3;
		c2.insets = new Insets(10, 12, 0, 10);
		c2.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(idLabelLeft, c2);
		
		idLabelRight = new JLabel();
//		idLabelRight.setFont(new Font("Arial", Font.PLAIN, 24));
//		idLabelRight.setForeground(Color.DARK_GRAY);
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 3;
		c3.insets = new Insets(10, 0, 0, 10);
		c3.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(idLabelRight, c3);
		
		nameLabelLeft = new JLabel("Name: ");
//		nameLabelLeft.setFont(new Font("Arial", Font.PLAIN, 24));
//		nameLabelLeft.setForeground(Color.DARK_GRAY);
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 4;
		c4.insets = new Insets(10, 12, 0, 10);
		c4.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(nameLabelLeft, c4);
		
		nameLabelRight = new JLabel();
//		nameLabelRight.setFont(new Font("Arial", Font.PLAIN, 24));
//		nameLabelRight.setForeground(Color.DARK_GRAY);
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 4;
		c5.insets = new Insets(10, 0, 0, 10);
		c5.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(nameLabelRight, c5);
//______________________		
		streetLabelLeft = new JLabel("Street: ");
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 0;
		c12.gridy = 5;
		c12.insets = new Insets(10, 12, 0, 10);
		c12.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(streetLabelLeft, c12);
		
		streetLabelRight = new JLabel();
		GridBagConstraints c13 = new GridBagConstraints();
		c13.gridx = 1;
		c13.gridy = 5;
		c13.insets = new Insets(10, 0, 0, 10);
		c13.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(streetLabelRight, c13);

		
		dateOfBirthLeft = new JLabel("Date of Birth: ");
//		dateOfBirthLeft.setFont(new Font("Arial", Font.PLAIN, 24));
//		dateOfBirthLeft.setForeground(Color.DARK_GRAY);
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 6;
		c6.insets = new Insets(10, 12, 0, 10);
		c6.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(dateOfBirthLeft, c6);
		
		dateOfBirthRight = new JLabel();
//		dateOfBirthRight.setFont(new Font("Arial", Font.PLAIN, 24));
//		dateOfBirthRight.setForeground(Color.DARK_GRAY);
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 1;
		c7.gridy = 6;
		c7.insets = new Insets(10, 0, 0, 10);
		c7.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(dateOfBirthRight, c7);
		
		genderLabelLeft = new JLabel("Gender: ");
//		genderLabelLeft.setFont(new Font("Arial", Font.PLAIN, 24));
//		genderLabelLeft.setForeground(Color.DARK_GRAY);
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 0;
		c8.gridy = 7;
		c8.insets = new Insets(10, 12, 0, 10);
		c8.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(genderLabelLeft, c8);
		
		genderLabelRight = new JLabel();
//		genderLabelRight.setFont(new Font("Arial", Font.PLAIN, 24));
//		genderLabelRight.setForeground(Color.DARK_GRAY);
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 1;
		c9.gridy = 7;
		c9.weighty = 1;
		c9.insets = new Insets(10, 0, 0, 10);
		c9.anchor = GridBagConstraints.FIRST_LINE_START;
		detailsPanel.add(genderLabelRight, c9);
		
		printButton = new DefaultButton("Print Order");
		GridBagConstraints c16 = new GridBagConstraints();
		c16.gridx = 1;
		c16.gridy = 8;
		c16.anchor = GridBagConstraints.LAST_LINE_END;
		c16.insets = new Insets(5, 10, 10, 10);
		detailsPanel.add(printButton, c16);
		
	}

	private void addComponentsToCurrentOrdersPanel(JPanel currentOrdersPanel) {
		currentOrdersPanel.setLayout(new GridBagLayout());
		
		currentOrdersLabel = new JLabel("Current Orders");
		currentOrdersLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		currentOrdersLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.insets = new Insets(10, 12, 0, 10);
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
		currentOrdersPanel.add(currentOrdersLabel, c0);
						
		String[] columns = { "Object", "Order No."};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		currentOrderstable = new JTable(tableModel);
		currentOrderstable.setDefaultEditor(Object.class, null);
		TableColumnModel tcm = currentOrderstable.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
		currentOrderstable.setFont(new Font("Arial", Font.PLAIN, 14));
		currentOrderstable.setRowHeight(30);
		currentOrderstable.setShowGrid(false);
		currentOrderstable.getTableHeader().setOpaque(false);
		currentOrderstable.getTableHeader().setBackground(new Color(240, 240, 240));
		currentOrderstable.setSelectionBackground(new Color(0x50c443));
		
		tableScrollPane = new JScrollPane(currentOrderstable);
		tableScrollPane.setBorder(BorderFactory.createEmptyBorder());
		tableScrollPane.getViewport().setBackground(Color.WHITE);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.weightx = 1;
		c1.weighty = 1;
		c1.fill = GridBagConstraints.BOTH;
		c1.insets = new Insets(10, 10, 10, 10);
		currentOrdersPanel.add(tableScrollPane, c1);
	}
	
//	private void addComponentsToEditOrderPanel(JPanel editOrdersPanel) {
//		editOrderPanel.setLayout(new GridBagLayout());
//		
//		JPanel detailsPanel = new JPanel(new GridBagLayout());
//		detailsPanel.setBackground(Color.WHITE);
//		addComponentsToDetailsPanel(detailsPanel);
//		GridBagConstraints c0 = new GridBagConstraints();
//		c0.gridx = 0;
//		c0.gridy = 0;
//		c0.gridwidth = 1;
//		c0.weightx = 1;
//		c0.weighty = 1;
//		c0.fill = GridBagConstraints.BOTH;
//		c0.insets = new Insets(0, 0, 15, 0);
//		editOrderPanel.add(detailsPanel, c0);
		
//		JPanel shoppingBasketPanel = new JPanel(new GridBagLayout());
//		shoppingBasketPanel.setBackground(Color.WHITE);
//		addComponentsToShoppingBasketPanel(shoppingBasketPanel);
//		GridBagConstraints c1 = new GridBagConstraints();
//		c1.gridx = 1;
//		c1.gridy = 0;
//		c1.gridwidth = 1;
//		c1.weighty = 1;
//		c1.weightx = 1;
//		c1.fill = GridBagConstraints.BOTH;
//		editOrderPanel.add(shoppingBasketPanel, c1);	
//	}
	
	public void addComponentsToStatusPanel(JPanel statusPanel) {
		statusPanel.setLayout(new GridBagLayout());
		
		statusLabel = new JLabel("Status:");
		statusLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		statusLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.weightx = 1;
		c0.insets = new Insets(10, 12, 0, 10);
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
		statusPanel.add(statusLabel, c0);
	}
	
	public void addComponentsToServicePanel(JPanel servicePanel) {
		servicePanel.setLayout(new GridBagLayout());

		serviceLabel = new JLabel("Service");
		serviceLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		serviceLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.insets = new Insets(10, 12, 10, 10);
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
		servicePanel.add(serviceLabel, c0);
		
		serviceTextArea = new JTextArea();
		serviceTextArea.setBorder(null);
		serviceTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
		serviceTextArea.setLineWrap(true);
		serviceTextArea.setWrapStyleWord(true);

		
		JScrollPane textAreaScrollPane = new JScrollPane(serviceTextArea);
		textAreaScrollPane.setBorder(null);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.weightx = 1;
		c1.weighty = 1;
		c1.fill = GridBagConstraints.BOTH;
		c1.insets = new Insets(0,10,0,10);
		servicePanel.add(textAreaScrollPane, c1);
		
		confirmButton = new DefaultButton("Confirm Order");
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.weightx = 1;
		c2.anchor = GridBagConstraints.LAST_LINE_END;
		c2.insets = new Insets(10, 10, 10, 10);
		servicePanel.add(confirmButton, c2);		
	}


	public JComboBox getCustomerComboBox() {
		return customerComboBox;
	}

	public void setCustomerComboBox(JComboBox customerComboBox) {
		this.customerComboBox = customerComboBox;
	}

	public JLabel getHeaderLabelLarge() {
		return headerLabelLarge;
	}

	public void setHeaderLabelLarge(JLabel headerLabelLarge) {
		this.headerLabelLarge = headerLabelLarge;
	}

	public JTable getCurrentOrderstable() {
		return currentOrderstable;
	}

	public void setCurrentOrderstable(JTable currentOrderstable) {
		this.currentOrderstable = currentOrderstable;
	}

	public DefaultButton getStartButton() {
		return startButton;
	}

	public void setStartButton(DefaultButton startButton) {
		this.startButton = startButton;
	}
	

	public JLabel getNumberLabelRight() {
		return numberLabelRight;
	}

	public void setNumberLabelRight(JLabel numberLabelRight) {
		this.numberLabelRight = numberLabelRight;
	}

	public JLabel getIdLabelRight() {
		return idLabelRight;
	}

	public void setIdLabelRight(JLabel idLabelRight) {
		this.idLabelRight = idLabelRight;
	}

	public JLabel getNameLabelRight() {
		return nameLabelRight;
	}

	public void setNameLabelRight(JLabel nameLabelRight) {
		this.nameLabelRight = nameLabelRight;
	}

	public JLabel getGenderLabelRight() {
		return genderLabelRight;
	}

	public void setGenderLabelRight(JLabel genderLabelRight) {
		this.genderLabelRight = genderLabelRight;
	}

	public JLabel getDateOfBirthRight() {
		return dateOfBirthRight;
	}

	public void setDateOfBirthRight(JLabel dateOfBirthRight) {
		this.dateOfBirthRight = dateOfBirthRight;
	}

	public JLabel getStartedLabelRight() {
		return startedLabelRight;
	}

	public void setStartedLabelRight(JLabel startedLabelRight) {
		this.startedLabelRight = startedLabelRight;
	}

	public JTable getMenuTable() {
		return menuTable;
	}

	public void setMenuTable(JTable menuTable) {
		this.menuTable = menuTable;
	}

	public JLabel getItemCountLabel() {
		return itemCountLabel;
	}

	public void setItemCountLabel(JLabel itemCountLabel) {
		this.itemCountLabel = itemCountLabel;
	}

	public DefaultButton getAddButton() {
		return addButton;
	}

	public void setAddButton(DefaultButton addButton) {
		this.addButton = addButton;
	}

	public DefaultButton getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(DefaultButton removeButton) {
		this.removeButton = removeButton;
	}

	public DefaultButton getPrintButton() {
		return printButton;
	}

	public void setPrintButton(DefaultButton printButton) {
		this.printButton = printButton;
	}

	public JTable getShoppingBasketTable() {
		return shoppingBasketTable;
	}

	public void setShoppingBasketTable(JTable shoppingBasketTable) {
		this.shoppingBasketTable = shoppingBasketTable;
	}

	public JLabel getStreetLabelLeft() {
		return streetLabelLeft;
	}

	public void setStreetLabelLeft(JLabel streetLabelLeft) {
		this.streetLabelLeft = streetLabelLeft;
	}

	public JLabel getStreetLabelRight() {
		return streetLabelRight;
	}

	public void setStreetLabelRight(JLabel streetLabelRight) {
		this.streetLabelRight = streetLabelRight;
	}

	public JLabel getTotalPriceLabel() {
		return totalPriceLabel;
	}

	public void setTotalPriceLabel(JLabel totalPriceLabel) {
		this.totalPriceLabel = totalPriceLabel;
	}

	public JLabel getStateLabelRight() {
		return stateLabelRight;
	}

	public void setStateLabelRight(JLabel stateLabelRight) {
		this.stateLabelRight = stateLabelRight;
	}

	public DefaultButton getAddDishButton() {
		return addDishButton;
	}

	public void setAddDishButton(DefaultButton addDishButton) {
		this.addDishButton = addDishButton;
	}

	public DefaultButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(DefaultButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public JTextArea getServiceTextArea() {
		return serviceTextArea;
	}

	public void setServiceTextArea(JTextArea serviceTextArea) {
		this.serviceTextArea = serviceTextArea;
	}

	public JComboBox<String> getSortComboBox() {
		return sortComboBox;
	}

	public void setSortComboBox(JComboBox<String> sortComboBox) {
		this.sortComboBox = sortComboBox;
	}

	public DefaultButton getImportOrdersButton() {
		return importOrdersButton;
	}

	public void setImportOrdersButton(DefaultButton importOrdersButton) {
		this.importOrdersButton = importOrdersButton;
	}

	public DefaultButton getExportOrdersButton() {
		return exportOrdersButton;
	}

	public void setExportOrdersButton(DefaultButton exportOrdersButton) {
		this.exportOrdersButton = exportOrdersButton;
	}
	
	

}
