package de.thb.dim.pizzaProntoGUI.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SidePanelButton extends JButton{
	
	public SidePanelButton(String text, String img) {
		setText(text);
		setIcon(new ImageIcon(img));
		setOpaque(true);
		setBorderPainted(false);
		setFocusPainted(false);
		setFont(new Font("Arial", Font.PLAIN, 14));
		setForeground(new Color(0x999999));
		setVerticalTextPosition(AbstractButton.BOTTOM);
		setHorizontalTextPosition(AbstractButton.CENTER);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setIconTextGap(16);
	}
}
