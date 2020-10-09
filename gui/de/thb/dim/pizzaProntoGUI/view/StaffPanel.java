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
public class StaffPanel extends JPanel {

	private JPanel headerPanel;
	private JPanel addPanel;
	private JPanel tablePanel;
	private JPanel hintPanel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField personnelNoTextField;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel colorApronLabel;
	private JLabel addTopicLabel;
	private JLabel tableTopicLabel;
	private JLabel hintLabel;
	private JLabel positionLabel;
	private JLabel personnelNoLabel;
	private JComboBox<String> colorComboBox;
	private JComboBox<String> employeeTypeComboBox;
	private DefaultButton addButton;
	private DefaultButton removeButton;
	private DefaultButton printButton;
	private JTable table;
	private JScrollPane tableScrollPane;
	private DefaultTableModel tableModel;

	public StaffPanel() {
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
		c.insets = new Insets(15, 30, 5, 10);
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
				"<p><span style=\"font-size: 10px;\">Um einen neuen Angestaellten hinzuzufuegen, muss die gesamte " +
				"Vererbungshierarchie, welche in Uebung 4 eingefuehrt wurde, implementiert sein. " +
				"Durch die vereinfachten Initalisierungskonstruktoren, reicht zum Erstellen eines Objekts " +
				"der Vor- und Nachname, sowie die Personalnummer. Alle anderen Attribute koennen im Nachhinein " +
				" ueber die Tabelle editiert werden. Dafuer muessen saemtliche getter und setter richtig " +
				"implementiert sein. Die Farbe der Schuerze kann mit Farbnamen eingegeben werden. Bspw. 'black' oder 'red'.</span></p></html>");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.insets = new Insets(10, 10, 10, 10);
		hintPanel.add(hintLabel, c);
	}

	public void addComponentsToAddPanel(JPanel addPanel) {
		addPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		addTopicLabel = new JLabel("Add an Employee");
		addTopicLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		addTopicLabel.setForeground(Color.DARK_GRAY);
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 12, 0, 10);
		addPanel.add(addTopicLabel, c);
		
		positionLabel = new JLabel("Position:");
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 12, 0, 10);
		addPanel.add(positionLabel, c);
		
		String[] employeeType = {"Chef", "Delivery Man"};
		employeeTypeComboBox = new JComboBox<String>(employeeType);
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 10, 0, 10);
		addPanel.add(employeeTypeComboBox, c);
		
		personnelNoLabel = new JLabel("Personnel No:");
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10, 12, 0, 10);
		addPanel.add(personnelNoLabel, c);
		
		personnelNoTextField = new JTextField();
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(personnelNoTextField, c);
				
		firstNameLabel = new JLabel("First Name:");
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(0, 12, 0, 10);
		addPanel.add(firstNameLabel, c);
		
		firstNameTextField = new JTextField();
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(firstNameTextField, c);
		
		lastNameLabel = new JLabel("Last Name:");
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(0, 12, 0, 10);
		addPanel.add(lastNameLabel, c);
		
		lastNameTextField = new JTextField();
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(0, 10, 10, 10);
		addPanel.add(lastNameTextField, c);
		
//		colorApronLabel = new JLabel("Apron Color:");
//		c.gridx = 0;
//		c.gridy = 9;
//		c.insets = new Insets(0, 12, 0, 10);
//		addPanel.add(colorApronLabel, c);
//		
//		String[] colors = {"White", "Black", "Red", "Green", "Blue", "Yellow", "Pink"};
//		colorComboBox = new JComboBox<String>(colors);
//		c.gridx = 0;
//		c.gridy = 10;
//		c.insets = new Insets(0, 10, 20, 10);
//		addPanel.add(colorComboBox, c);
		
		addButton = new DefaultButton("Add Employee");
		c.gridx = 0;
		c.gridy = 11;
		c.insets = new Insets(0, 13, 20, 13);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		addPanel.add(addButton, c);

	}

	public void addComponentsToTablePanel(JPanel tablePanel) {
		tablePanel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		String[] columns = { "Object", "Type", "Personnel No", "First Name", "Last Name", "Street", "No", "Salery", "Vacation Days", "Drivers License", "Apron Color", "hashCode" };
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		table = new JTable(tableModel);
		TableColumnModel tcm = table.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setRowHeight(30);
		table.setShowGrid(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(240, 240, 240));
//		table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 14));
		table.setSelectionBackground(new Color(0x50c443));
		table.putClientProperty("terminateEditOnFocusLost", true);

		
		tableTopicLabel = new JLabel("Your current Employees");
		tableTopicLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		tableTopicLabel.setForeground(Color.DARK_GRAY);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
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
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 10, 10, 10);
		tablePanel.add(tableScrollPane, c);
		
		printButton = new DefaultButton("Print Details");
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(0, 10, 10, 10);
		tablePanel.add(printButton, c);

		
		removeButton = new DefaultButton("Remove Employee");
		c.gridx = 1;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(0, 10, 10, 10);
		tablePanel.add(removeButton, c);
		

	}
	
	public void addComponentsToHeaderPanel(JPanel headerPanel) {
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel headerLabelSmall = new JLabel("Pizza Pronto");
		headerLabelSmall.setFont(new Font("Helvetica", Font.PLAIN, 20));
		headerLabelSmall.setForeground(new Color(0x505050));
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 1;
		headerPanel.add(headerLabelSmall, c);
		
		JLabel headerLabelLarge = new JLabel("Employees");
		headerLabelLarge.setFont(new Font("Helvetica", Font.PLAIN, 30));
		headerLabelLarge.setForeground(new Color(0x606060));
		c.gridx = 0;
		c.gridy = 1;
		headerPanel.add(headerLabelLarge, c);
	}

	public JPanel getAddPanel() {
		return addPanel;
	}

	public JPanel getHintPanel() {
		return hintPanel;
	}

	public void setHintPanel(JPanel hintPanel) {
		this.hintPanel = hintPanel;
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

	public DefaultButton getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(DefaultButton removeButton) {
		this.removeButton = removeButton;
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

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}

	public void setFirstNameLabel(JLabel firstNameLabel) {
		this.firstNameLabel = firstNameLabel;
	}

	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}

	public void setLastNameLabel(JLabel lastNameLabel) {
		this.lastNameLabel = lastNameLabel;
	}

	public JLabel getColorApronLabel() {
		return colorApronLabel;
	}

	public void setColorApronLabel(JLabel colorApronLabel) {
		this.colorApronLabel = colorApronLabel;
	}

	public JComboBox<String> getColorComboBox() {
		return colorComboBox;
	}

	public void setColorComboBox(JComboBox<String> colorComboBox) {
		this.colorComboBox = colorComboBox;
	}

	public DefaultButton getAddButton() {
		return addButton;
	}

	public void setAddButton(DefaultButton addButton) {
		this.addButton = addButton;
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

	public JPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(JPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	public JLabel getPositionLabel() {
		return positionLabel;
	}

	public void setPositionLabel(JLabel positionLabel) {
		this.positionLabel = positionLabel;
	}

	public JComboBox<String> getEmployeeTypeComboBox() {
		return employeeTypeComboBox;
	}

	public void setEmployeeTypeComboBox(JComboBox<String> employeeTypeComboBox) {
		this.employeeTypeComboBox = employeeTypeComboBox;
	}

	public DefaultButton getPrintButton() {
		return printButton;
	}

	public void setPrintButton(DefaultButton printButton) {
		this.printButton = printButton;
	}

	public JTextField getPersonnelNoTextField() {
		return personnelNoTextField;
	}

	public void setPersonnelNoTextField(JTextField personnelNoTextField) {
		this.personnelNoTextField = personnelNoTextField;
	}

}
