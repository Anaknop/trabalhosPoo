package Conversor;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sobre extends JFrame {
	private static final long serialVersionUID = 1L;

	public Sobre() {
		setTitle("Conversor Universal");
		setSize(600, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout();
	}
	
	private void setLayout() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 150));

		JLabel label = new JLabel();
		
		panel.add(label);
		
		add(panel);
	}
}
