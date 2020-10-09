package de.thb.dim.pizzaProntoGUI.view;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
	
	private JLabel logo;
//	private TopPanelButton loadButton;
//	private TopPanelButton saveButton;
	
	public TopPanel() {
		setOpaque(true);
		setBackground(new Color(0xaa0000));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		logo = new JLabel(new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/logo.png"));
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 10, 0, 0);		
		add(logo, c);
//		
//		loadButton = new TopPanelButton("Load", "images/load_24px.png");		
//		c.gridx = 1;
//		c.gridy = 0;
//		c.weightx = 0;
//		c.anchor = GridBagConstraints.LINE_END;
//		c.insets = new Insets(0, 0, 0, 30);		
//		add(loadButton, c);
//		
//		saveButton = new TopPanelButton("Save", "images/save_24px.png");		
//		c.gridx = 2;
//		c.gridy = 0;
//		c.weightx = 0;
//		c.anchor = GridBagConstraints.LINE_END;
//		c.insets = new Insets(0, 0, 0, 40);		
//		add(saveButton, c);

	}
	
}
