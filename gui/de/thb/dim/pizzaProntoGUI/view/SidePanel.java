package de.thb.dim.pizzaProntoGUI.view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SidePanel extends JPanel implements ActionListener {
	
	private SidePanelButton homeButton;
	private SidePanelButton staffButton;
	private SidePanelButton menuButton;
	private SidePanelButton customerButton;
	private SidePanelButton orderButton;
	
	private JPanel mainPanel;
	
	
	public SidePanel() {
		setOpaque(true);
		setBackground(new Color(0x444444));
		setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/border.png")));

		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;

		homeButton = new SidePanelButton("Home", "gui/de/thb/dim/pizzaProntoGUI/images/home_32px.png");	
		homeButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;		
		add(homeButton, c);
		
		staffButton = new SidePanelButton("Staff", "gui/de/thb/dim/pizzaProntoGUI/images/chef_32px.png");		
		staffButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1;
		add(staffButton, c);
		
		menuButton = new SidePanelButton("Menu", "gui/de/thb/dim/pizzaProntoGUI/images/menu_32px.png");
		menuButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 1;
		add(menuButton, c);
		
		customerButton = new SidePanelButton("Customers", "gui/de/thb/dim/pizzaProntoGUI/images/customer_32px.png");
		customerButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 3;
		c.weighty = 1;
		add(customerButton, c);
		
		orderButton = new SidePanelButton("Orders", "gui/de/thb/dim/pizzaProntoGUI/images/order_32px.png");
		orderButton.addActionListener(this);
		c.gridx = 0;
		c.gridy = 4;
		c.weighty = 1;
		add(orderButton, c);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		CardLayout cl = (CardLayout)(mainPanel.getLayout());
	    
		if(e.getSource() == homeButton)
			cl.show(mainPanel, "homePanel");
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
