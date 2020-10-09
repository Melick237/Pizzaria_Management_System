package de.thb.dim.pizzaProntoGUI.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TopPanelButton extends JButton{
	
	public TopPanelButton(String text, String img) {
		setText(text);
		setIcon(new ImageIcon(img));
		setOpaque(true);
		setBorderPainted(false);
		setFocusPainted(false);
		setFont(new Font("Arial", Font.BOLD, 14));
		setForeground(new Color(0xffffff));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setIconTextGap(12);
	}
}
