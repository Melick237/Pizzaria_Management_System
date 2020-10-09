package de.thb.dim.pizzaProntoGUI.view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomePanel extends JPanel implements ActionListener{
	
	private JPanel headerPanel;	
	private JPanel staffPanel;
	private JPanel menuPanel;
	private JPanel customerPanel;
	private JPanel orderPanel;
	
	private DefaultButton staffButton;
	private DefaultButton menuButton;
	private DefaultButton customerButton;
	private DefaultButton orderButton;

	
	private JPanel mainPanel;

	public HomePanel() {
		setOpaque(true);
		setBackground(new Color(0xeaeaea));
		setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/border.png")));

		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
	
		c.fill = GridBagConstraints.BOTH;
		
		headerPanel = new JPanel(new GridBagLayout());
		headerPanel.setBackground(new Color(0xeaeaea));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.insets = new Insets(15, 30, 0, 10);
		add(headerPanel, c);
		
		staffPanel = new JPanel(new GridBagLayout());
		staffPanel.setBackground(new Color(0xffffff));
		staffPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(50, 30, 130, 0);		
		add(staffPanel, c);
		
		menuPanel = new JPanel(new GridBagLayout());
		menuPanel.setBackground(new Color(0xffffff));
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));		
		c.gridx = 1;
		c.gridy = 1;		
		add(menuPanel, c);
		
		customerPanel = new JPanel(new GridBagLayout());
		customerPanel.setBackground(new Color(0xffffff));
		customerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));		
		c.gridx = 2;
		c.gridy = 1;		
		add(customerPanel, c);
		
		orderPanel = new JPanel(new GridBagLayout());
		orderPanel.setBackground(new Color(0xffffff));
		orderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));		
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(50, 30, 130, 30);		
		add(orderPanel, c);	
		
		
		
		GridBagConstraints c2 = new GridBagConstraints();
		
		JLabel headerLabelSmall = new JLabel("Pizza Pronto");
		headerLabelSmall.setFont(new Font("Helvetica", Font.PLAIN, 20));
		headerLabelSmall.setForeground(new Color(0x505050));
		c2.gridx = 0;
		c2.gridy = 0;
		c2.anchor = GridBagConstraints.FIRST_LINE_START;
		c2.weightx = 1;
		headerPanel.add(headerLabelSmall, c2);
		
		JLabel headerLabelLarge = new JLabel("Home");
		headerLabelLarge.setFont(new Font("Helvetica", Font.PLAIN, 30));
		headerLabelLarge.setForeground(new Color(0x606060));
		c2.gridx = 0;
		c2.gridy = 1;
		headerPanel.add(headerLabelLarge, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		
		c3.gridx = 0;
		c3.gridy = 0;
		c3.weighty = 1;
		c3.weightx = 0;
		c3.insets = new Insets(50, 0, 0, 0);
		
		
		JLabel staffLabel = new JLabel("Staff", new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/employees_128px.png"), JLabel.CENTER);
		staffLabel.setVerticalTextPosition(JLabel.BOTTOM);
		staffLabel.setHorizontalTextPosition(JLabel.CENTER);
		staffLabel.setIconTextGap(40);
		staffLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
		staffLabel.setForeground(new Color(0x606060));
		staffPanel.add(staffLabel, c3);
		
		JLabel menuLabel = new JLabel("Menu", new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/menu_128px.png"), JLabel.CENTER);
		menuLabel.setVerticalTextPosition(JLabel.BOTTOM);
		menuLabel.setHorizontalTextPosition(JLabel.CENTER);
		menuLabel.setIconTextGap(40);
		menuLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
		menuLabel.setForeground(new Color(0x606060));
		menuPanel.add(menuLabel, c3);
		
		JLabel customerLabel = new JLabel("Customers", new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/target_128px.png"), JLabel.CENTER);
		customerLabel.setVerticalTextPosition(JLabel.BOTTOM);
		customerLabel.setHorizontalTextPosition(JLabel.CENTER);
		customerLabel.setIconTextGap(40);
		customerLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
		customerLabel.setForeground(new Color(0x606060));
		customerPanel.add(customerLabel, c3);
		
		JLabel orderLabel = new JLabel("Orders", new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/list_128px.png"), JLabel.CENTER);
		orderLabel.setVerticalTextPosition(JLabel.BOTTOM);
		orderLabel.setHorizontalTextPosition(JLabel.CENTER);
		orderLabel.setIconTextGap(40);
		orderLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
		orderLabel.setForeground(new Color(0x606060));
		orderPanel.add(orderLabel, c3);
		
		c3.gridx = 0;
		c3.gridy = 1;
		c3.weightx = 1;
		c3.anchor = GridBagConstraints.PAGE_END;
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.insets = new Insets(0, 1, 0, 1);

		staffButton = new DefaultButton("Manage Staff");
		staffButton.setPreferredSize(new Dimension(0, 55));
		staffButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
		staffButton.addActionListener(this);
		staffPanel.add(staffButton, c3);
		
		menuButton = new DefaultButton("Edit Menu");
		menuButton.setPreferredSize(new Dimension(0, 55));
		menuButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
		menuButton.addActionListener(this);
		menuPanel.add(menuButton, c3);
		
		customerButton = new DefaultButton("Manage Customers");
		customerButton.setPreferredSize(new Dimension(0, 55));
		customerButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
		customerButton.addActionListener(this);
		customerPanel.add(customerButton, c3);
		
		orderButton = new DefaultButton("Process Orders");
		orderButton.setPreferredSize(new Dimension(0, 55));
		orderButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
		orderButton.addActionListener(this);
		orderPanel.add(orderButton, c3);				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		CardLayout cl = (CardLayout)(mainPanel.getLayout());
	    
		if(e.getSource() == staffButton)
			cl.show(mainPanel, "staffPanel");
		if(e.getSource() == menuButton)
			cl.show(mainPanel, "menuPanel");
		if(e.getSource() == customerButton)
			cl.show(mainPanel, "customerPanel");
		if(e.getSource() == orderButton)
			cl.show(mainPanel, "orderPanel");		
	}
	
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

}
