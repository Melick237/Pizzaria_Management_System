package de.thb.dim.pizzaProntoGUI.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ExceptionPanel{
	
	public ExceptionPanel (Exception e) {
		
		EventQueue.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				JFrame frame = new JFrame("Exception");
									
				JPanel innerPanel = new JPanel(new GridBagLayout());
				innerPanel.setOpaque(true);
				innerPanel.setBackground(Color.WHITE);
				innerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				
				JPanel outerPanel = new JPanel(new GridBagLayout());
				outerPanel.setOpaque(true);
				outerPanel.setBackground(new Color(0xeaeaea));
				
				GridBagConstraints c1 = new GridBagConstraints();
				c1.insets = new Insets(10,10,10,10);
				outerPanel.add(innerPanel,c1);
				
				GridBagConstraints c0 = new GridBagConstraints();
				
				JLabel label = new JLabel(e.getClass().getSimpleName());
				label.setIcon(new ImageIcon("gui/de/thb/dim/pizzaProntoGUI/images/warn_32px.png"));
				label.setFont(new Font("Arial", Font.PLAIN, 20));
				label.setForeground(new Color(0x606060));
				label.setIconTextGap(16);
				c0.gridx = 0;
				c0.gridy = 0;
				c0.insets = new Insets(20,20,10,20);
				innerPanel.add(label, c0);
				
				GridBagConstraints c2 = new GridBagConstraints();
				
				JTextArea details = new JTextArea();						
				details.setBackground(Color.WHITE);
				details.setEditable(false);						
				details.setText(e.getMessage());
				c2.gridx = 0;
				c2.gridy = 1;
				c2.insets = new Insets(10,20,20,20);				
				innerPanel.add(details, c2);
				
				GridBagConstraints c3 = new GridBagConstraints();

				JButton okButton = new DefaultButton("OK");
				okButton.addActionListener(e -> frame.dispose());
				c3.gridx = 0;
				c3.gridy = 2;
				c3.insets = new Insets(10,0,10,0);
				innerPanel.add(okButton, c3);
				
				frame.add(outerPanel);				
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});
	}	

}
