package de.thb.dim.pizzaProntoGUI.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	private LayoutPanel layoutPanel;
	private JScrollPane scrollPane;

	public MainView() {
		layoutPanel = new LayoutPanel();

		scrollPane = new JScrollPane(layoutPanel);

		add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public LayoutPanel getLayoutPanel() {
		return layoutPanel;
	}

	public void setLayoutPanel(LayoutPanel layoutPanel) {
		this.layoutPanel = layoutPanel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}
