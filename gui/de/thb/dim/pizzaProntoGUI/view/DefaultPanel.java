package de.thb.dim.pizzaProntoGUI.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DefaultPanel extends JPanel {
	
	private JLabel header;
	private JPanel content;
	
	public DefaultPanel(String headerText) {
		setLayout(new GridBagLayout());
		setBackground(new Color(0xffffff));
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		header = new JLabel(headerText);
		header.setBackground(new Color(0x4fb8e0));
		header.setForeground(new Color(0xffffff));
		header.setFont(new Font("Arial", Font.PLAIN, 30));
		header.setOpaque(true);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(header, c);
		
		content = new JPanel();
		content.setBackground(new Color(0xffffff));
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		add(content, c);
		
	}
}
