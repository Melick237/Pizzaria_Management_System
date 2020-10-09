package de.thb.dim.pizzaProntoGUI.view;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

	private JPanel headerPanel;
	private JPanel addPanel;
	private JPanel tablePanel;
	private JPanel hintPanel;
	private JPanel buttonPanel;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextField ingredientTextField;
	private JTextField numberTextField;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel dishLabel;
	private JLabel addTopicLabel;
	private JLabel tableTopicLabel;
	private JLabel hintLabel;
	private JLabel ingredientsLabel;
	private JLabel numberLabel;
	private JLabel sizeLabel;
	private JLabel typeOfPastaLabel;
	private JComboBox<String> dishComboBox;
	private JComboBox<Integer> typeComboBox;
	private JComboBox<Integer> sizeComboBox;
	private DefaultButton addButton;
	private DefaultButton removeButton;
	private DefaultButton addIngredientButton;
	private DefaultButton removeIngredientButton;
	private DefaultButton printButton;
	private DefaultButton copyButton;
	private DefaultButton loadButton;
	private JTable table;
	private JTable ingredientsTable;
	private JScrollPane tableScrollPane;
	private JScrollPane ingredientsTableScrollPane;
	private DefaultTableModel tableModel;
	private DefaultTableModel ingredientTableModel;


	public MenuPanel() {
		setOpaque(true);
		setBackground(new Color(0xeaeaea));
		setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/border.png")));
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		headerPanel = new JPanel();
		headerPanel = new JPanel(new GridBagLayout());
		headerPanel.setBackground(new Color(0xeaeaea));
		addComponentsToHeaderPanel(headerPanel);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(15, 30, 0, 10);
		c.fill = GridBagConstraints.BOTH;
		add(headerPanel, c);

		addPanel = new JPanel();
		addPanel.setBackground(Color.WHITE);
		addPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToAddPanel(addPanel);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 1;
		c.insets = new Insets(10, 30, 10, 10);
		add(addPanel, c);

		tablePanel = new JPanel();
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToTablePanel(tablePanel);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 0, 10, 10);
		add(tablePanel, c);
		
		hintPanel = new JPanel();
		hintPanel.setBackground(Color.WHITE);
		hintPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addComponentsToHintPanel(hintPanel);
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 0;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 30, 10, 10);
		add(hintPanel, c);
	}

	private void addComponentsToHintPanel(JPanel hintPanel) {
		hintPanel.setLayout(new GridBagLayout());
		hintLabel = new JLabel("<html><p><strong><span style=\"font-size: 10px;\">Hinweis</span></strong></p>\n" + 
				"<p><span style=\"font-size: 10px;\">Ueber den Import Menu Button koennen Speisekarten als txt Datein geladen werden. " +
				"Sollte nach dem Laden nicht das entsprechende Menue angezeigt werden, kann es moeglich sein, dass die Datei beschaedigt ist oder nicht der vorgegebenen Form entspricht. " +
				"Es wird in dem Fall keine Fehlermeldung ausgegeben.</span></p></html>");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.insets = new Insets(10, 10, 10, 10);
		hintPanel.add(hintLabel, c);
	}

	private void addComponentsToAddPanel(JPanel addPanel) {
		addPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		
		addTopicLabel = new JLabel("Add a Dish");
		addTopicLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		addTopicLabel.setForeground(Color.DARK_GRAY);
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 12, 0, 10);
		addPanel.add(addTopicLabel, c);
		
		dishLabel = new JLabel("Type:");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.insets = new Insets(10, 12, 0, 10);
		addPanel.add(dishLabel, c);
		
		String[] dishes = {"Pasta", "Pizza", "Dessert"};
		
		dishComboBox = new JComboBox<String>(dishes);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;

		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(dishComboBox, c);
		
		//______________________________
		
		numberLabel = new JLabel("Number:");
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 3;
		c1.insets = new Insets(0, 12, 0, 10);
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		addPanel.add(numberLabel, c1);
		
		sizeLabel = new JLabel("Pizza Size:");
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 1;
		c2.gridy = 3;
		c2.insets = new Insets(0, 12, 0, 10);
		c2.anchor = GridBagConstraints.FIRST_LINE_START;
		addPanel.add(sizeLabel, c2);
		
		typeOfPastaLabel = new JLabel("Pasta Type:");
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 2;
		c3.gridy = 3;
		c3.insets = new Insets(0, 12, 0, 10);
		c3.anchor = GridBagConstraints.FIRST_LINE_START;
		addPanel.add(typeOfPastaLabel, c3);
		
		numberTextField = new JTextField();
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 4;
		c4.insets = new Insets(0, 12, 0, 10);
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.anchor = GridBagConstraints.FIRST_LINE_START;
		addPanel.add(numberTextField, c4);
		
		Integer[] sizes = {1,2};
		sizeComboBox = new JComboBox<Integer>(sizes);
		sizeComboBox.setEnabled(false);
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 4;
		c5.insets = new Insets(0, 12, 0, 10);
		c5.anchor = GridBagConstraints.FIRST_LINE_START;
		addPanel.add(sizeComboBox, c5);
		
		Integer[] types = {4,5,6};
		typeComboBox = new JComboBox<Integer>(types);
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 2;
		c6.gridy = 4;
		c6.insets = new Insets(0, 12, 0, 10);
		c6.anchor = GridBagConstraints.FIRST_LINE_START;
		addPanel.add(typeComboBox, c6);
		
		

		
		//______________________________
				
		nameLabel = new JLabel("Name:");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.insets = new Insets(0, 12, 0, 10);
		addPanel.add(nameLabel, c);
		
		nameTextField = new JTextField();
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 3;
		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(nameTextField, c);
		
		priceLabel = new JLabel("Price:");
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 3;
		c.insets = new Insets(0, 12, 0, 10);
		addPanel.add(priceLabel, c);
		
		priceTextField = new JTextField();
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 3;
		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(priceTextField, c);
		
		ingredientsLabel = new JLabel("Ingredients:");
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 3;
		c.insets = new Insets(0, 12, 0, 10);
		addPanel.add(ingredientsLabel, c);
		
		ingredientTextField = new JTextField();
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 3;
		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(ingredientTextField, c);
		
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setBackground(Color.white);
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 0;
		c9.gridy = 11;
		c9.gridwidth = 3;
		c9.insets = new Insets(0, 13, 10, 13);
		addPanel.add(buttonPanel, c9);
		
		addIngredientButton = new DefaultButton("Add Ingredient");
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0;
		c7.gridy = 0;
		c7.insets = new Insets(0, 0, 0, 5);
		buttonPanel.add(addIngredientButton, c7);
		
		removeIngredientButton = new DefaultButton("Remove Ingredient");
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 1;
		c8.gridy = 0;
		buttonPanel.add(removeIngredientButton, c8);
		
		String[] ingredientColumn = { "Current Ingredients:" };
		ingredientTableModel = new DefaultTableModel();
		ingredientTableModel.setColumnIdentifiers(ingredientColumn);
		ingredientsTable = new JTable(ingredientTableModel);
		ingredientsTable.setFont(new Font("Arial", Font.PLAIN, 14));
		ingredientsTable.setRowHeight(20);
		ingredientsTable.setShowGrid(false);
		ingredientsTable.getTableHeader().setOpaque(false);
		ingredientsTable.getTableHeader().setBackground(new Color(240, 240, 240));
		ingredientsTable.setSelectionBackground(new Color(0x50c443));

		ingredientsTableScrollPane = new JScrollPane(ingredientsTable);
		ingredientsTableScrollPane.setBorder(BorderFactory.createEmptyBorder());
		ingredientsTableScrollPane.getViewport().setBackground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 12;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 12, 10, 12);
		addPanel.add(ingredientsTableScrollPane, c);
						
		addButton = new DefaultButton("Add Dish");
		c.gridx = 0;
		c.gridy = 13;
		c.gridwidth = 3;
		c.weighty = 0;
		c.insets = new Insets(10, 10, 10, 12);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		addPanel.add(addButton, c);

	}

	private void addComponentsToTablePanel(JPanel tablePanel) {
		tablePanel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		String[] columns = { "Object", "Number", "Type", "Name", "Ingredients", "Size", "Type", "Price", "hashCode"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null);
		TableColumnModel tcm = table.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setRowHeight(30);
		table.setShowGrid(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(240, 240, 240));
//		table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 14));
		table.setSelectionBackground(new Color(0x50c443));
		
		tableTopicLabel = new JLabel("Your current Menu");
		tableTopicLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		tableTopicLabel.setForeground(Color.DARK_GRAY);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(10, 12, 10, 10);
		tablePanel.add(tableTopicLabel, c);

		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBorder(BorderFactory.createEmptyBorder());
		tableScrollPane.getViewport().setBackground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 10, 10, 10);
		tablePanel.add(tableScrollPane, c);
		
		copyButton = new DefaultButton("Copy Dish");
		copyButton.setVisible(false);
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(0, 10, 10, 10);
		tablePanel.add(copyButton, c);

		
		printButton = new DefaultButton("Print Details");
		c.gridx = 1;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(0, 10, 10, 10);
		tablePanel.add(printButton, c);
		
		removeButton = new DefaultButton("Remove Dish");
		c.gridx = 2;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(0, 10, 10, 10);
		tablePanel.add(removeButton, c);
		

	}
	
	private void addComponentsToHeaderPanel(JPanel headerPanel) {
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel headerLabelSmall = new JLabel("Pizza Pronto");
		headerLabelSmall.setFont(new Font("Helvetica", Font.PLAIN, 20));
		headerLabelSmall.setForeground(new Color(0x505050));
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 1;
		headerPanel.add(headerLabelSmall, c);
		
		JLabel headerLabelLarge = new JLabel("Menu");
		headerLabelLarge.setFont(new Font("Helvetica", Font.PLAIN, 30));
		headerLabelLarge.setForeground(new Color(0x606060));
		c.gridx = 0;
		c.gridy = 1;
		headerPanel.add(headerLabelLarge, c);
		
		loadButton = new DefaultButton("Import Menu");
		loadButton.setForeground(new Color(0xEEEEEE));
		loadButton.setBackground(new Color(0x999999));
		loadButton.setIcon(new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/import_24px.png"));
		loadButton.setIconTextGap(8);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		headerPanel.add(loadButton, c);
	}

	public JPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(JPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	public JPanel getAddPanel() {
		return addPanel;
	}

	public void setAddPanel(JPanel addPanel) {
		this.addPanel = addPanel;
	}

	public JPanel getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JPanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public JPanel getHintPanel() {
		return hintPanel;
	}

	public void setHintPanel(JPanel hintPanel) {
		this.hintPanel = hintPanel;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JTextField getPriceTextField() {
		return priceTextField;
	}

	public void setPriceTextField(JTextField priceTextField) {
		this.priceTextField = priceTextField;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(JLabel priceLabel) {
		this.priceLabel = priceLabel;
	}

	public JLabel getDishLabel() {
		return dishLabel;
	}

	public void setDishLabel(JLabel dishLabel) {
		this.dishLabel = dishLabel;
	}

	public JLabel getAddTopicLabel() {
		return addTopicLabel;
	}

	public void setAddTopicLabel(JLabel addTopicLabel) {
		this.addTopicLabel = addTopicLabel;
	}

	public JLabel getTableTopicLabel() {
		return tableTopicLabel;
	}

	public void setTableTopicLabel(JLabel tableTopicLabel) {
		this.tableTopicLabel = tableTopicLabel;
	}

	public JLabel getHintLabel() {
		return hintLabel;
	}

	public void setHintLabel(JLabel hintLabel) {
		this.hintLabel = hintLabel;
	}

	public JComboBox<String> getDishComboBox() {
		return dishComboBox;
	}

	public void setDishComboBox(JComboBox<String> dishComboBox) {
		this.dishComboBox = dishComboBox;
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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getTableScrollPane() {
		return tableScrollPane;
	}

	public void setTableScrollPane(JScrollPane tableScrollPane) {
		this.tableScrollPane = tableScrollPane;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public JTextField getIngredientTextField() {
		return ingredientTextField;
	}

	public void setIngredientTextField(JTextField ingredientTextField) {
		this.ingredientTextField = ingredientTextField;
	}

	public JLabel getIngredientsLabel() {
		return ingredientsLabel;
	}

	public void setIngredientsLabel(JLabel ingredientsLabel) {
		this.ingredientsLabel = ingredientsLabel;
	}

	public DefaultButton getAddIngredientButton() {
		return addIngredientButton;
	}

	public void setAddIngredientButton(DefaultButton addIngredientButton) {
		this.addIngredientButton = addIngredientButton;
	}

	public DefaultButton getRemoveIngredientButton() {
		return removeIngredientButton;
	}

	public void setRemoveIngredientButton(DefaultButton removeIngredientButton) {
		this.removeIngredientButton = removeIngredientButton;
	}

	public JTable getIngredientsTable() {
		return ingredientsTable;
	}

	public void setIngredientsTable(JTable ingredientsTable) {
		this.ingredientsTable = ingredientsTable;
	}

	public JScrollPane getIngredientsTableScrollPane() {
		return ingredientsTableScrollPane;
	}

	public void setIngredientsTableScrollPane(JScrollPane ingredientsTableScrollPane) {
		this.ingredientsTableScrollPane = ingredientsTableScrollPane;
	}

	public DefaultTableModel getIngredientTableModel() {
		return ingredientTableModel;
	}

	public void setIngredientTableModel(DefaultTableModel ingredientTableModel) {
		this.ingredientTableModel = ingredientTableModel;
	}

	public DefaultButton getPrintButton() {
		return printButton;
	}

	public void setPrintButton(DefaultButton printButton) {
		this.printButton = printButton;
	}

	public DefaultButton getCopyButton() {
		return copyButton;
	}

	public void setCopyButton(DefaultButton copyButton) {
		this.copyButton = copyButton;
	}

	public JLabel getTypeOfPastaLabel() {
		return typeOfPastaLabel;
	}

	public void setTypeOfPastaLabel(JLabel typeOfPastaLabel) {
		this.typeOfPastaLabel = typeOfPastaLabel;
	}

	public JComboBox<Integer> getTypeComboBox() {
		return typeComboBox;
	}

	public void setTypeComboBox(JComboBox<Integer> typeComboBox) {
		this.typeComboBox = typeComboBox;
	}

	public JComboBox<Integer> getSizeComboBox() {
		return sizeComboBox;
	}

	public void setSizeComboBox(JComboBox<Integer> sizeComboBox) {
		this.sizeComboBox = sizeComboBox;
	}

	public JTextField getNumberTextField() {
		return numberTextField;
	}

	public void setNumberTextField(JTextField numberTextField) {
		this.numberTextField = numberTextField;
	}

	public DefaultButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(DefaultButton loadButton) {
		this.loadButton = loadButton;
	}


}
