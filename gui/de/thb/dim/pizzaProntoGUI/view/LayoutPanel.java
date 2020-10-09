package de.thb.dim.pizzaProntoGUI.view;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LayoutPanel extends JPanel {
	
	private TopPanel topPanel;
	private SidePanel sidePanel;
	private JPanel mainPanel;
	private HomePanel homePanel;
	private StaffPanel staffPanel2;
	private CustomerPanel customerPanel;
	private MenuPanel menuPanel;
	private OrderPanel orderPanel;
		
	public LayoutPanel() {
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
			
		topPanel = new TopPanel();
		topPanel.setPreferredSize(new Dimension(0, 50));

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(topPanel, c);
		
		sidePanel = new SidePanel();
		sidePanel.setPreferredSize(new Dimension(110, 0));
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.VERTICAL;
		add(sidePanel, c);
		
		homePanel = new HomePanel();
		staffPanel2 = new StaffPanel();
		customerPanel = new CustomerPanel();
		menuPanel = new MenuPanel();
		orderPanel = new OrderPanel();
		
		mainPanel = new JPanel(new CardLayout());
		mainPanel.add(homePanel, "homePanel");
		mainPanel.add(staffPanel2, "staffPanel");
		mainPanel.add(customerPanel, "customerPanel");
		mainPanel.add(menuPanel, "menuPanel");
		mainPanel.add(orderPanel, "orderPanel");
		mainPanel.setPreferredSize(new Dimension(1170, 700));
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		add(mainPanel, c);
		
		sidePanel.setMainPanel(mainPanel);
		homePanel.setMainPanel(mainPanel);

	}

	public TopPanel getTopPanel() {
		return topPanel;
	}

	public void setTopPanel(TopPanel topPanel) {
		this.topPanel = topPanel;
	}

	public SidePanel getSidePanel() {
		return sidePanel;
	}

	public void setSidePanel(SidePanel sidePanel) {
		this.sidePanel = sidePanel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public HomePanel getHomePanel() {
		return homePanel;
	}

	public void setHomePanel(HomePanel homePanel) {
		this.homePanel = homePanel;
	}

	public StaffPanel getStaffPanel2() {
		return staffPanel2;
	}

	public void setStaffPanel2(StaffPanel staffPanel2) {
		this.staffPanel2 = staffPanel2;
	}

	public CustomerPanel getCustomerPanel() {
		return customerPanel;
	}

	public void setCustomerPanel(CustomerPanel customerPanel) {
		this.customerPanel = customerPanel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public OrderPanel getOrderPanel() {
		return orderPanel;
	}

	public void setOrderPanel(OrderPanel orderPanel) {
		this.orderPanel = orderPanel;
	}
	

}
