package de.thb.dim.pizzaProntoGUI.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DefaultButton extends JButton {

	public DefaultButton(String text) {
		setText(text);
		setOpaque(true);
		setBorderPainted(false);
		setFocusPainted(false);
		setFont(new Font("Arial", Font.PLAIN, 14));
		setForeground(Color.WHITE);
		setBackground(new Color(0x50c443));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(true);
	//	setPreferredSize(new Dimension(150,30));
	}
}
